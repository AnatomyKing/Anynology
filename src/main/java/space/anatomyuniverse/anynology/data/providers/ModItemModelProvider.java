// file: src/main/java/space/anatomyuniverse/anynology/data/providers/ModItemModelProvider.java
package space.anatomyuniverse.anynology.data.providers;

import net.minecraft.data.PackOutput;


//? if <1.21.4 {
/*import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import space.anatomyuniverse.anynology.AnyCore;
import space.anatomyuniverse.anynology.data.utils.ItemsGen;
import space.anatomyuniverse.anynology.data.utils.ModelSets;

public final class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AnyCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemsGen.flatItems(this, ModelSets.flatItems());
    }
}
*///?} else {
/**
 * 1.21.4+: item models are handled from the ModelProvider (ModBlockModelProvider),
 * and BlockItems get auto-generated if you don't specify custom client items. :contentReference[oaicite:3]{index=3}
 *
 * Keep this file so older versions still compile without deleting/renaming stuff.
 */
public final class ModItemModelProvider {
    private ModItemModelProvider(PackOutput output) {}
}
//?}
