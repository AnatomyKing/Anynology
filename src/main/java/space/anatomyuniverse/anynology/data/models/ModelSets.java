// file: src/main/java/space/anatomyuniverse/anynology/data/models/ModelSets.java
// file: src/main/java/space/anatomyuniverse/anynology/data/utils/ModelSets.java
// file: src/main/java/space/anatomyuniverse/anynology/data/providers/utils/ModelSets.java
package space.anatomyuniverse.anynology.data.models;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.block.ModBlocks;
import space.anatomyuniverse.anynology.item.ModItems;

import space.anatomyuniverse.anynology.data.models.block.helpers.BlockstateOwnModel;

/**
 * Single source of truth for which things get which models.
 * Keeps your lists in ONE place so you don't repeat them per version/provider.
 */
public final class ModelSets {
    private ModelSets() {}

    /** Full cube_all blocks. */
    public static Block[] cubeAllBlocks() {
        return new Block[] {
                // Base
                ModBlocks.PURPISH_ANYTOMITHIUM_BLOCK.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BLOCK.get(),

                // Polished / Cut / Bricks
                ModBlocks.POLISHED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.POLISHED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CUT_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CUT_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BRICKS.get(),

                // Grates
                ModBlocks.PURPISH_ANYTOMITHIUM_GRATE.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_GRATE.get()
        };
    }

    /** cube_column blocks where end textures use "<id>_top" */
    public static Block[] CubePillarLikeBlocks() {
        return new Block[] {
                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM_BRICKS.get()
        };
    }

    /**
     * Crafter-like cube blocks (6 textures: _bottom/_top/_north/_south/_west/_east).
     * Put your blocks here.
     */
    public static Block[] CubeCrafterLikeBlocks() {
        return new Block[] {
//                ModBlocks.BANNER_EATER.get(),
        };
    }

    public static Block[] CubeOwnModelBlocks() {
        return new Block[] {
                ModBlocks.BANNER_EATER.get(),
        };
    }


    public static BlockstateOwnModel.Definition[] BlockstateOwnModel() {
        return new BlockstateOwnModel.Definition[] {
                // Minimal default example (single-variant):
//                BlockstateOwnModel.of(ModBlocks.BANNER_EATER.get(), b -> b
//                        .variant(
//                                "", // selector for the "default" variant
//                                AnyCore.MOD_ID + ":block/" + ModelUtil.pathOf(ModBlocks.BANNER_EATER.get())
//                        )
//                )


                // Rotation example (copy your crafter-style logic):
//                BlockstateOwnModel.of(ModBlocks.SOME_BLOCK.get(), b -> b
//                        .variant("crafting=false,orientation=down_east,triggered=false", AnyCore.MOD_ID + ":block/some_model", 90, 90)
//                        .variant("crafting=false,orientation=down_north,triggered=false", AnyCore.MOD_ID + ":block/some_model", 90, null)
//                        .variant("crafting=false,orientation=east_up,triggered=false", AnyCore.MOD_ID + ":block/some_model", null, 90)
//                        .variant("crafting=false,orientation=north_up,triggered=false", AnyCore.MOD_ID + ":block/some_model")
//                )

        };
    }

    /** Non-block items that need item/generated (or similar) models. */
    public static ItemLike[] flatItems() {
        return new ItemLike[] {
                ModItems.RAW_ANYTOMITHIUM.get(),
                ModItems.PURPISH_ANYTOMITHIUM_INGOT.get(),
                ModItems.TEALISH_ANYTOMITHIUM_INGOT.get()
        };
    }
}
