// file: src/main/java/space/anatomyuniverse/anynology/data/providers/utils/ItemsGen.java
package space.anatomyuniverse.anynology.data.providers.utils;

import net.minecraft.world.level.ItemLike;

//? if <1.21.4 {
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
//?} else {
/*import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
*///?}

public final class ItemsGen {
    private ItemsGen() {}

    //? if <1.21.4 {
    /** Flat generated item (parent: minecraft:item/generated). */
    public static void flatItems(ItemModelProvider itemModels, ItemLike... items) {
        for (ItemLike it : items) itemModels.basicItem(it.asItem());
    }

    /** Handheld (parent: minecraft:item/handheld). */
    public static void handheldItems(ItemModelProvider itemModels, ItemLike... items) {
        for (ItemLike it : items) itemModels.handheldItem(it.asItem());
    }

    /** Item model that points at an existing model id (e.g. "anynology:item/foo_custom"). */
    public static void customItemModel(ItemModelProvider itemModels, ItemLike item, String modelId) {
        ResourceLocation parent = ResourceLocation.parse(modelId);
        itemModels.withExistingParent(ModelUtil.pathOf(item), parent);
    }

    /** Make item use the block model: parent = <ns>:block/<blockname>. */
    public static void itemUsesOwnBlockModel(ItemModelProvider itemModels, Block block) {
        ResourceLocation id = ModelUtil.idOf(block);
        ResourceLocation parent = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/" + id.getPath());
        itemModels.withExistingParent(id.getPath(), parent);
    }

    /** If you generate block models via BlockStateProvider, you can also generate the block item model there. */
    public static void simpleBlockWithItem(BlockStateProvider blockGen, Block block) {
        blockGen.simpleBlock(block);
        blockGen.simpleBlockItem(block, blockGen.cubeAll(block));
    }
    //?} else {
    /*/^* Flat generated item for 1.21.4+ via ItemModelGenerators. ^/
    public static void flatItems(ItemModelGenerators gen, ItemLike... items) {
        for (ItemLike it : items) {
            Item item = it.asItem();
            gen.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }
    *///?}
}
