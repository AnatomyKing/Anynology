// file: src/main/java/space/anatomyuniverse/anynology/data/models/block/helpers/CubePillarLike.java
package space.anatomyuniverse.anynology.data.models.block.helpers;

import net.minecraft.world.level.block.Block;

//? if <1.21.4 {
/*import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import space.anatomyuniverse.anynology.data.models.ModelUtil;
*///?} else {
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
//?}

public final class CubePillarLike {
    private CubePillarLike() {}

    //? if <1.21.4 {
    /*/^* cube_column where top/bottom texture is "<block>_top", with matching block item model. ^/
    public static void generate(BlockStateProvider gen, Block... blocks) {
        for (Block b : blocks) {
            ResourceLocation side = ModelUtil.blockTex(b); // "block/<id>"
            ResourceLocation end = ResourceLocation.fromNamespaceAndPath(
                    side.getNamespace(),
                    side.getPath() + "_top"
            );

            BlockModelBuilder model = gen.models().cubeColumn(ModelUtil.pathOf(b), side, end);
            gen.simpleBlock(b, model);
            gen.simpleBlockItem(b, model);
        }
    }
    *///?} else {
    /** cube_column where end textures use "<id>_top" (your naming). */
    public static void generate(BlockModelGenerators gen, Block... blocks) {
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
    //?}
}
