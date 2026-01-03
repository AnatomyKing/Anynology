// file: src/main/java/space/anatomyuniverse/anynology/data/models/ModelSets.java
package space.anatomyuniverse.anynology.data.models;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.block.ModBlocks;
import space.anatomyuniverse.anynology.item.ModItems;

import space.anatomyuniverse.anynology.data.models.block.helpers.BlockstateOwnModel;

import java.util.ArrayList;
import java.util.List;

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

    /** Crafter-like cube blocks (6 textures: _bottom/_top/_north/_south/_west/_east). */
    public static Block[] CubeCrafterLikeBlocks() {
        return new Block[] {
                // put crafter-like blocks here (NOT banner_eater; it's handled by BlockstateOwnModel)
        };
    }

    /** Blocks that simply point at an existing block model (no custom blockstate variants needed). */
    public static Block[] CubeOwnModelBlocks() {
        return new Block[] {
                // put simple “existing model” blocks here (NOT banner_eater if it needs facing-variants)
        };
    }

    /** Your fully custom blockstate definitions (variants map). */
    public static BlockstateOwnModel.Definition[] BlockstateOwnModel() {
        return new BlockstateOwnModel.Definition[]{

                BlockstateOwnModel.of(ModBlocks.BANNER_EATER.get(), b -> b
                        .variant("facing=north,eater_state=closed", AnyCore.MOD_ID + ":block/banner_eater_closed")
                        .variant("facing=east,eater_state=closed",  AnyCore.MOD_ID + ":block/banner_eater_closed", null, 90)
                        .variant("facing=south,eater_state=closed", AnyCore.MOD_ID + ":block/banner_eater_closed", null, 180)
                        .variant("facing=west,eater_state=closed",  AnyCore.MOD_ID + ":block/banner_eater_closed", null, 270)

                        .variant("facing=north,eater_state=open", AnyCore.MOD_ID + ":block/banner_eater_open")
                        .variant("facing=east,eater_state=open",  AnyCore.MOD_ID + ":block/banner_eater_open", null, 90)
                        .variant("facing=south,eater_state=open", AnyCore.MOD_ID + ":block/banner_eater_open", null, 180)
                        .variant("facing=west,eater_state=open",  AnyCore.MOD_ID + ":block/banner_eater_open", null, 270)
                )
        };
    }

    /**
     * Convenience: the blocks that will have their blockstates overwritten by BlockstateOwnModel.saveAll(...).
     * Used to generate placeholder blockstates/items so ModelProvider validation passes (and old versions get item models).
     */
    public static Block[] BlockstateOwnModelBlocks() {
        BlockstateOwnModel.Definition[] defs = BlockstateOwnModel();
        List<Block> blocks = new ArrayList<>(defs.length);
        for (BlockstateOwnModel.Definition d : defs) {
            if (d != null && d.block != null) blocks.add(d.block);
        }
        return blocks.toArray(new Block[0]);
    }

    /** Non-block items that need item/generated models. */
    public static ItemLike[] flatItems() {
        return new ItemLike[] {
                ModItems.RAW_ANYTOMITHIUM.get(),
                ModItems.PURPISH_ANYTOMITHIUM_INGOT.get(),
                ModItems.TEALISH_ANYTOMITHIUM_INGOT.get()
        };
    }
}
