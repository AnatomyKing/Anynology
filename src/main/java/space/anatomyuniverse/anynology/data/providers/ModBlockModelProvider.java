// file: src/main/java/space/anatomyuniverse/anynology/data/providers/ModBlockModelProvider.java
package space.anatomyuniverse.anynology.data.providers;

import net.minecraft.data.PackOutput;
import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.data.ModelSets;
import space.anatomyuniverse.anynology.data.providers.utils.BlocksGen;


//? if <1.21.4 {
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class ModBlockModelProvider extends BlockStateProvider {

    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AnyCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // cube_all (+ auto item models here)
        BlocksGen.cubeAllWithItem(this, ModelSets.cubeAllBlocks());

        // cube_column with "<id>_top" ends (+ auto item models here)
        BlocksGen.cubeColumnTopSuffixWithItem(this, ModelSets.columnTopSuffixBlocks());
    }
}
//?} else {
/*import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import space.anatomyuniverse.anynology.data.providers.utils.ItemsGen;

public final class ModBlockModelProvider extends ModelProvider {

    public ModBlockModelProvider(PackOutput output) {
        super(output, AnyCore.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blocks, ItemModelGenerators items) {
        // Blocks
        BlocksGen.cubeAll(blocks, ModelSets.cubeAllBlocks());
        BlocksGen.cubeColumnTopSuffix(blocks, ModelSets.columnTopSuffixBlocks());

        // Non-block items only.
        // BlockItems are auto-generated if you don't generate custom client items. :contentReference[oaicite:2]{index=2}
        ItemsGen.flatItems(items, ModelSets.flatItems());
    }
}
*///?}
