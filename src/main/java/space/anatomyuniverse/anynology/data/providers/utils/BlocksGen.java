// file: src/main/java/space/anatomyuniverse/anynology/data/providers/utils/BlocksGen.java
package space.anatomyuniverse.anynology.data.providers.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

//? if <1.21.4 {
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
//?} else {
/*import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
*///?}

public final class BlocksGen {
    private BlocksGen() {}

    //? if <1.21.4 {
    /** Standard cube_all with matching block item model. */
    public static void cubeAllWithItem(BlockStateProvider gen, Block... blocks) {
        for (Block b : blocks) {
            BlockModelBuilder model = gen.models().cubeAll(ModelUtil.pathOf(b), ModelUtil.blockTex(b));
            gen.simpleBlock(b, model);
            gen.simpleBlockItem(b, model);
        }
    }

    /** cube_column where top/bottom texture is "<block>_top", with matching block item model. */
    public static void cubeColumnTopSuffixWithItem(BlockStateProvider gen, Block... blocks) {
        for (Block b : blocks) {
            ResourceLocation side = ModelUtil.blockTex(b); // "block/<id>"
            ResourceLocation end  = ResourceLocation.fromNamespaceAndPath(side.getNamespace(), side.getPath() + "_top");
            BlockModelBuilder model = gen.models().cubeColumn(ModelUtil.pathOf(b), side, end);
            gen.simpleBlock(b, model);
            gen.simpleBlockItem(b, model);
        }
    }
    //?} else {
    /*/^* Standard cube_all. (Block item models auto-generate if you don't define custom client items.) ^/
    public static void cubeAll(BlockModelGenerators gen, Block... blocks) {
        for (Block b : blocks) gen.createTrivialCube(b);
    }

    /^* cube_column where top/bottom texture is "<block>_top" (your naming). ^/
    public static void cubeColumnTopSuffix(BlockModelGenerators gen, Block... blocks) {
        for (Block b : blocks) {
            TexturedModel.Provider provider = TexturedModel.createDefault(
                    blk -> new TextureMapping()
                            .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(blk))
                            .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(blk))
                            .put(TextureSlot.END, TextureMapping.getBlockTexture(blk, "_top")),
                    ModelTemplates.CUBE_COLUMN
            );
            gen.createTrivialBlock(b, provider);
        }
    }
    *///?}
}
