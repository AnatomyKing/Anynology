// file: src/main/java/space/anatomyuniverse/anynology/data/providers/utils/ModelSets.java
package space.anatomyuniverse.anynology.data;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import space.anatomyuniverse.anynology.block.ModBlocks;
import space.anatomyuniverse.anynology.item.ModItems;

/**
 * Single source of truth for which things get which models.
 * Keeps your lists in ONE place so you don't repeat them per version/provider.
 */
public final class ModelSets {
    private ModelSets() {}

    /** Full cube_all blocks (includes grates, etc). */
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

    /**
     * cube_column blocks where end textures use "<id>_top"
     * (perfect for your chiseled variants).
     */
    public static Block[] columnTopSuffixBlocks() {
        return new Block[] {
                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM_BRICKS.get()
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
