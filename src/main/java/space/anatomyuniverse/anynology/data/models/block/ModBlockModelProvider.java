// file: src/main/java/space/anatomyuniverse/anynology/data/models/block/ModBlockModelProvider.java
package space.anatomyuniverse.anynology.data.models.block;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.data.models.ModelSets;

import space.anatomyuniverse.anynology.data.models.block.helpers.BlockstateOwnModel;
import space.anatomyuniverse.anynology.data.models.block.helpers.CubeAll;
import space.anatomyuniverse.anynology.data.models.block.helpers.CubeCrafterLike;
import space.anatomyuniverse.anynology.data.models.block.helpers.CubeOwnModel;
import space.anatomyuniverse.anynology.data.models.block.helpers.CubePillarLike;

//? if <1.21.4 {
/*import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class ModBlockModelProvider extends BlockStateProvider {
    private final PackOutput output;

    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AnyCore.MOD_ID, existingFileHelper);
        this.output = output;
    }

    @Override
    protected void registerStatesAndModels() {
        CubeAll.generate(this, ModelSets.cubeAllBlocks());
        CubePillarLike.generate(this, ModelSets.CubePillarLikeBlocks());
        CubeCrafterLike.generate(this, ModelSets.CubeCrafterLikeBlocks());

        // Blocks that point at existing models (no custom variants)
        CubeOwnModel.generate(this, ModelSets.CubeOwnModelBlocks());

        // Blocks with custom blockstates:
        // Generate placeholder blockstate + block item model using the FIRST variant model (e.g. banner_eater_closed).
        // Then run() will overwrite the blockstate JSON with the real variants.
        BlockstateOwnModel.generatePlaceholders(this, ModelSets.BlockstateOwnModel());
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        // Run normal model/blockstate generation first, then overwrite/add our fully custom blockstates.
        return super.run(cache).thenCompose(ignored ->
                BlockstateOwnModel.saveAll(
                        this.output,
                        cache,
                        AnyCore.MOD_ID,
                        ModelSets.BlockstateOwnModel()
                )
        );
    }
}
*///?} else {
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;

import space.anatomyuniverse.anynology.data.models.item.helpers.FlatItems;

public final class ModBlockModelProvider extends ModelProvider {
    private final PackOutput output;

    public ModBlockModelProvider(PackOutput output) {
        super(output, AnyCore.MOD_ID);
        this.output = output;
    }

    @Override
    protected void registerModels(BlockModelGenerators blocks, ItemModelGenerators items) {
        CubeAll.generate(blocks, ModelSets.cubeAllBlocks());
        CubePillarLike.generate(blocks, ModelSets.CubePillarLikeBlocks());
        CubeCrafterLike.generate(blocks, ModelSets.CubeCrafterLikeBlocks());

        // Blocks that point at existing models (no custom variants)
        CubeOwnModel.generate(blocks, ModelSets.CubeOwnModelBlocks());

        // Blocks with custom blockstates:
        // ModelProvider validates blockstate defs during registerModels,
        // so we emit placeholders now (using the FIRST variant model).
        // Your custom writer in run() overwrites the final blockstates JSON.
        BlockstateOwnModel.generatePlaceholders(blocks, ModelSets.BlockstateOwnModel());

        // Non-block items only.
        FlatItems.generate(items, ModelSets.flatItems());
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        // Run normal model/blockstate generation first, then overwrite/add our fully custom blockstates.
        return super.run(cache).thenCompose(ignored ->
                BlockstateOwnModel.saveAll(
                        this.output,
                        cache,
                        AnyCore.MOD_ID,
                        ModelSets.BlockstateOwnModel()
                )
        );
    }
}
//?}
