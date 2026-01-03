// file: src/main/java/space/anatomyuniverse/anynology/data/models/block/helpers/BlockstateOwnModel.java
package space.anatomyuniverse.anynology.data.models.block.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

//? if <1.21.4 {
/*import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
*///?} else {
import net.minecraft.client.data.models.BlockModelGenerators;
//?}

/**
 * Writes fully custom blockstates JSON (variants map) with optional rotations (x/y) and uvlock.
 *
 * Output:
 *  assets/<modid>/blockstates/<block_path>.json
 */
public final class BlockstateOwnModel {
    private BlockstateOwnModel() {}

    public static Definition of(Block block, Consumer<Builder> consumer) {
        Builder b = new Builder(block);
        consumer.accept(b);
        return b.build();
    }

    public static final class Definition {
        public final Block block;
        public final JsonObject variants; // selector -> {model,x,y,uvlock,...}

        private Definition(Block block, JsonObject variants) {
            this.block = block;
            this.variants = variants;
        }
    }

    public static final class Builder {
        private final Block block;
        private final JsonObject variants = new JsonObject();

        private Builder(Block block) {
            this.block = block;
        }

        public Builder variant(String selector, String model) {
            return variant(selector, model, null, null, null);
        }

        public Builder variant(String selector, String model, Integer x, Integer y) {
            return variant(selector, model, x, y, null);
        }

        public Builder variant(String selector, String model, Integer x, Integer y, Boolean uvlock) {
            JsonObject obj = new JsonObject();
            obj.addProperty("model", model);

            if (x != null) obj.addProperty("x", x);
            if (y != null) obj.addProperty("y", y);
            if (uvlock != null) obj.addProperty("uvlock", uvlock);

            variants.add(selector, obj);
            return this;
        }

        private Definition build() {
            return new Definition(block, variants);
        }
    }

    /**
     * Normalize the RESOURCE_PACK output folder across versions:
     * - Some versions return .../src/generated/resources
     * - Other versions return .../src/generated/resources/assets
     *
     * We want the folder that CONTAINS mod namespaces, i.e. .../assets
     */
    private static Path assetsRoot(PackOutput output) {
        Path root = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK);

        Path name = root.getFileName();
        if (name != null && "assets".equals(name.toString())) {
            return root; // already points at .../assets
        }
        return root.resolve("assets"); // points at .../resources/assets
    }

    /**
     * Picks a placeholder model for a Definition: FIRST variant's "model".
     * (Your banner_eater first variant is banner_eater_closed, so it validates.)
     */
    public static ResourceLocation pickPlaceholderModel(Definition def) {
        if (def == null || def.variants == null) {
            return ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_all");
        }

        for (var entry : def.variants.entrySet()) {
            JsonElement el = entry.getValue();
            if (el == null || !el.isJsonObject()) continue;

            JsonObject obj = el.getAsJsonObject();
            if (!obj.has("model")) continue;

            String modelId = obj.get("model").getAsString();
            if (modelId == null || modelId.isBlank()) continue;

            return ResourceLocation.parse(modelId);
        }

        return ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_all");
    }

    //? if <1.21.4 {
    /*public static void generatePlaceholders(BlockStateProvider gen, Definition[] defs) {
        if (defs == null || defs.length == 0) return;

        for (Definition def : defs) {
            if (def == null || def.block == null) continue;

            ResourceLocation model = pickPlaceholderModel(def);
            ModelFile existing = gen.models().getExistingFile(model);

            gen.simpleBlock(def.block, existing);
            gen.simpleBlockItem(def.block, existing);
        }
    }*/
    //?} else {
    public static void generatePlaceholders(BlockModelGenerators blocks, Definition[] defs) {
        if (defs == null || defs.length == 0) return;

        for (Definition def : defs) {
            if (def == null || def.block == null) continue;

            ResourceLocation model = pickPlaceholderModel(def);

            //? if <1.21.5 {
            /*blocks.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(def.block, model));
            *///?} else {
            blocks.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(def.block, BlockModelGenerators.plainVariant(model))
            );
            //?}

            blocks.registerSimpleItemModel(def.block, model);
        }
    }
    //?}

    /**
     * Save all custom blockstates (overwrites placeholders).
     */
    public static CompletableFuture<?> saveAll(
            PackOutput output,
            CachedOutput cache,
            String modId,
            Definition[] defs
    ) {
        if (defs == null || defs.length == 0) {
            return CompletableFuture.completedFuture(null);
        }

        final Path assets = assetsRoot(output);
        final List<CompletableFuture<?>> futures = new ArrayList<>();

        for (Definition def : defs) {
            if (def == null || def.block == null) continue;

            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(def.block);

            // assets/<modid>/blockstates/<path>.json
            Path out = assets
                    .resolve(modId)
                    .resolve("blockstates")
                    .resolve(blockId.getPath() + ".json");

            JsonObject json = new JsonObject();
            json.add("variants", def.variants);

            futures.add(DataProvider.saveStable(cache, json, out));
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }
}
