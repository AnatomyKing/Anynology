// file: src/main/java/space/anatomyuniverse/anynology/data/models/block/helpers/CubeOwnModel.java
package space.anatomyuniverse.anynology.data.models.block.helpers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import space.anatomyuniverse.anynology.AnyCore;

//? if <1.21.4 {
/*import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import space.anatomyuniverse.anynology.data.models.ModelUtil;
*///?} else {
import net.minecraft.client.data.models.BlockModelGenerators;
import space.anatomyuniverse.anynology.data.models.ModelUtil;
//?}

public final class CubeOwnModel {
    private CubeOwnModel() {}

    //? if <1.21.4 {
    /*/^*
     * Blockstate points at an existing model id: anynology:block/<path>
     * Item model also points at the same model id.
     *
     * You must have: assets/anynology/models/block/<path>.json already.
     ^/
    public static void generate(BlockStateProvider gen, Block... blocks) {
        for (Block b : blocks) {
            ResourceLocation model = ResourceLocation.fromNamespaceAndPath(
                    AnyCore.MOD_ID,
                    "block/" + ModelUtil.pathOf(b)
            );

            ModelFile existing = gen.models().getExistingFile(model);

            gen.simpleBlock(b, existing);
            gen.simpleBlockItem(b, existing);
        }
    }
    *///?} else {
    /**
     * 1.21.4+:
     * Blockstate points at existing model id: anynology:block/<path>
     * Item model points at same model id.
     */
    public static void generate(BlockModelGenerators gen, Block... blocks) {
        for (Block b : blocks) {
            ResourceLocation model = ResourceLocation.fromNamespaceAndPath(
                    AnyCore.MOD_ID,
                    "block/" + ModelUtil.pathOf(b)
            );

            //? if <1.21.5 {
            /*gen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(b, model));
            *///?} else {
            gen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(b, BlockModelGenerators.plainVariant(model)));
            //?}

            gen.registerSimpleItemModel(b, model);
        }
    }
    //?}
}
