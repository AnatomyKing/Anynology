// file: src/main/java/space/anatomyuniverse/anynology/block/ModBlocks.java
package space.anatomyuniverse.anynology.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import space.anatomyuniverse.anynology.AnyCore;

import java.util.Set;

/**
 * Blocks + auto BlockItems.
 *
 * - Registers all blocks.
 * - Auto-registers BlockItems for all blocks (unless skipped).
 */
public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AnyCore.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AnyCore.MOD_ID);

    /* -------------------- Blocks -------------------- */

    // Copper-block-like feel (strength 3 / 6, copper sound, requires tool)
    public static final DeferredBlock<Block> PURPISH_ANYTOMITHIUM_BLOCK =
            BLOCKS.registerBlock("purpish_anytomithium_block",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> TEALISH_ANYTOMITHIUM_BLOCK =
            BLOCKS.registerBlock("tealish_anytomithium_block",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CUT_PURPISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("cut_purpish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CUT_TEALISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("cut_tealish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> POLISHED_PURPISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("polished_purpish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> POLISHED_TEALISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("polished_tealish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> PURPISH_ANYTOMITHIUM_BRICKS =
            BLOCKS.registerBlock("purpish_anytomithium_bricks",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> TEALISH_ANYTOMITHIUM_BRICKS =
            BLOCKS.registerBlock("tealish_anytomithium_bricks",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CHISELED_PURPISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("chiseled_purpish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CHISELED_TEALISH_ANYTOMITHIUM =
            BLOCKS.registerBlock("chiseled_tealish_anytomithium",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CHISELED_PURPISH_ANYTOMITHIUM_BRICKS =
            BLOCKS.registerBlock("chiseled_purpish_anytomithium_bricks",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> CHISELED_TEALISH_ANYTOMITHIUM_BRICKS =
            BLOCKS.registerBlock("chiseled_tealish_anytomithium_bricks",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .pushReaction(PushReaction.NORMAL)));

    /**
     * “Grate” blocks:
     * Make them GLASS-LIKE (transparent / light passing / non-occluding / non-suffocating / non-view-blocking),
     * but with COPPER FEEL (sound + strength + correct tool).
     *
     * These property goals match copper grate behavior (transparent, no suffocation, no redstone conduction, no mob spawning). :contentReference[oaicite:2]{index=2}
     *
     * IMPORTANT: render layer (cutout) is client-side — keep adding these blocks to your existing render-layer setup.
     */
    public static final DeferredBlock<Block> PURPISH_ANYTOMITHIUM_GRATE =
            BLOCKS.registerBlock("purpish_anytomithium_grate",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()

                            // glass-like transparency behavior:
                            .noOcclusion()
                            .isSuffocating((state, level, pos) -> false)
                            .isViewBlocking((state, level, pos) -> false)

                            // grate-like rules:
                            .isRedstoneConductor((state, level, pos) -> false)
                            .isValidSpawn((state, level, pos, entityType) -> false)

                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> TEALISH_ANYTOMITHIUM_GRATE =
            BLOCKS.registerBlock("tealish_anytomithium_grate",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()

                            // glass-like transparency behavior:
                            .noOcclusion()
                            .isSuffocating((state, level, pos) -> false)
                            .isViewBlocking((state, level, pos) -> false)

                            // grate-like rules:
                            .isRedstoneConductor((state, level, pos) -> false)
                            .isValidSpawn((state, level, pos, entityType) -> false)

                            .pushReaction(PushReaction.NORMAL)));

    /* -------------------- Auto BlockItems -------------------- */

    private static final Set<DeferredBlock<? extends Block>> SKIP_BLOCK_ITEMS = Set.of(
            // Add blocks here if you ever want NO BlockItem for them.
    );

    static {
        BLOCKS.getEntries().forEach(entry -> {
            if (!SKIP_BLOCK_ITEMS.contains(entry)) {
                ITEMS.registerSimpleBlockItem(entry);
            }
        });
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    private ModBlocks() {}
}
