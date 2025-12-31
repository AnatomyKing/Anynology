// file: src/main/java/space/anatomyuniverse/anynology/data/providers/ModBlockTagsProvider.java
package space.anatomyuniverse.anynology.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

//? if <1.21.4 {
/*import net.neoforged.neoforge.common.data.ExistingFileHelper;
*///?}

public final class ModBlockTagsProvider extends BlockTagsProvider {

    //? if <1.21.4 {
    /*public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AnyCore.MOD_ID, existingFileHelper);
    }
    *///?}

    //? if >=1.21.4 {
    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AnyCore.MOD_ID);
    }
    //?}

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.PURPISH_ANYTOMITHIUM_BLOCK.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BLOCK.get(),

                ModBlocks.POLISHED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.POLISHED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CUT_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CUT_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_GRATE.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_GRATE.get(),

                ModBlocks.BANNER_EATER.get()
        );

        tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.PURPISH_ANYTOMITHIUM_BLOCK.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BLOCK.get(),

                ModBlocks.POLISHED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.POLISHED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CUT_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CUT_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM.get(),

                ModBlocks.CHISELED_PURPISH_ANYTOMITHIUM_BRICKS.get(),
                ModBlocks.CHISELED_TEALISH_ANYTOMITHIUM_BRICKS.get(),

                ModBlocks.PURPISH_ANYTOMITHIUM_GRATE.get(),
                ModBlocks.TEALISH_ANYTOMITHIUM_GRATE.get(),

                ModBlocks.BANNER_EATER.get()
        );
    }
}
