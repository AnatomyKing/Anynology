// file: src/main/java/space/anatomyuniverse/anynology/data/providers/ModBlockLootProvider.java
package space.anatomyuniverse.anynology.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import space.anatomyuniverse.anynology.block.ModBlocks;

import java.util.Set;

public final class ModBlockLootProvider extends BlockLootSubProvider {

    public ModBlockLootProvider(HolderLookup.Provider registries) {
        // 1.21.1: BlockLootSubProvider needs registries in the ctor
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // One clean call, as requested
        dropSelfAll(
                ModBlocks.PURPISH_ANYTOMITHIUM_BLOCK.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BLOCK.get(),

                ModBlocks.CUT_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CUT_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.POLISHED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.POLISHED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_GRATE.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_GRATE.get()
        );
    }

    private void dropSelfAll(Block... blocks) {
        for (Block b : blocks) dropSelf(b);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Only your mod blocks
        return ModBlocks.BLOCKS.getEntries().stream()
                .map(h -> (Block) h.get())
                .toList();
    }
}
