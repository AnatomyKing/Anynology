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
import space.anatomyuniverse.anynology.block.custom.BannerEaterBlock;

import java.util.Set;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AnyCore.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AnyCore.MOD_ID);

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


    public static final DeferredBlock<Block> PURPISH_ANYTOMITHIUM_GRATE =
            BLOCKS.registerBlock("purpish_anytomithium_grate",
                    props -> new Block(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()

                            .noOcclusion()
                            .isSuffocating((state, level, pos) -> false)
                            .isViewBlocking((state, level, pos) -> false)


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


                            .noOcclusion()
                            .isSuffocating((state, level, pos) -> false)
                            .isViewBlocking((state, level, pos) -> false)


                            .isRedstoneConductor((state, level, pos) -> false)
                            .isValidSpawn((state, level, pos, entityType) -> false)

                            .pushReaction(PushReaction.NORMAL)));

    public static final DeferredBlock<Block> BANNER_EATER =
            BLOCKS.registerBlock("banner_eater",
                    props -> new BannerEaterBlock(props
                            .mapColor(MapColor.COLOR_ORANGE)
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.COPPER)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
                            .isSuffocating((state, level, pos) -> false)
                            .isViewBlocking((state, level, pos) -> false)
                            .isRedstoneConductor((state, level, pos) -> false)
                            .isValidSpawn((state, level, pos, entityType) -> false)
                            .pushReaction(PushReaction.NORMAL)));


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
