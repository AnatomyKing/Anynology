// file: src/main/java/space/anatomyuniverse/anynology/data/models/block/helpers/BlockstateOwnModel.java
package space.anatomyuniverse.anynology.data.models.block.helpers;

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

/**
 * Writes fully custom blockstates JSON (variants map) with optional rotations (x/y) and uvlock.
 *
 * Output:
 *  assets/<modid>/blockstates/<block_path>.json
 *
 * Example variant JSON emitted:
 *  "age=0,attached=false": { "model":"modid:block/my_model", "x":90, "y":180, "uvlock":true }
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

        /** Minimal: selector -> model */
        public Builder variant(String selector, String model) {
            return variant(selector, model, null, null, null);
        }

        /** With rotations (degrees, typically 0/90/180/270). */
        public Builder variant(String selector, String model, Integer x, Integer y) {
            return variant(selector, model, x, y, null);
        }

        /** With rotations + uvlock. */
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
     * Save all custom blockstates.
     *
     * NOTE: this intentionally writes AFTER the normal model provider runs (we chain it in the provider),
     * so you can "override" generated blockstates for the same block if needed.
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

        final Path root = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK);
        final List<CompletableFuture<?>> futures = new ArrayList<>();

        for (Definition def : defs) {
            if (def == null || def.block == null) continue;

            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(def.block);

            // assets/<modid>/blockstates/<path>.json
            Path out = root
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
