// file: src/main/java/space/anatomyuniverse/anynology/data/models/item/helpers/HandheldItems.java
package space.anatomyuniverse.anynology.data.models.item.helpers;

import net.minecraft.world.level.ItemLike;

//? if <1.21.4 {
/*import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
*///?}

public final class HandheldItems {
    private HandheldItems() {}

    //? if <1.21.4 {
    /*/^* Handheld (parent: minecraft:item/handheld). ^/
    public static void generate(ItemModelProvider itemModels, ItemLike... items) {
        for (ItemLike it : items) itemModels.handheldItem(it.asItem());
    }
    *///?}
}
