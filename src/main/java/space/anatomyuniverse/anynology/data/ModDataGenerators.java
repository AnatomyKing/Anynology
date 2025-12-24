// file: src/main/java/space/anatomyuniverse/anynology/data/ModDataGenerators.java
package space.anatomyuniverse.anynology.data;


import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import space.anatomyuniverse.anynology.data.providers.*;

import java.util.List;
import java.util.Set;

//? if <1.21.4 {
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
//?}

public final class ModDataGenerators {

    //? if <1.21.4 {
    public static void gatherData(final GatherDataEvent event) {
        final PackOutput output = event.getGenerator().getPackOutput();
        final ExistingFileHelper efh = event.getExistingFileHelper();

        if (event.includeClient()) {
            event.getGenerator().addProvider(true, new ModLanguageProvider(output, "en_us"));
            event.getGenerator().addProvider(true, new ModBlockModelProvider(output, efh));
            event.getGenerator().addProvider(true, new ModItemModelProvider(output, efh));
        }

        if (event.includeServer()) {
            // Recipes
            //? if <1.21.3 {
            event.getGenerator().addProvider(true, new ModRecipeProvider(output, event.getLookupProvider()));
            //?}
            //? if >=1.21.3 {
            /*event.getGenerator().addProvider(true, new ModRecipeProvider.Runner(output, event.getLookupProvider()));
            *///?}

            event.getGenerator().addProvider(true,
                    new ModBlockTagsProvider(output, event.getLookupProvider(), efh)
            );

            event.getGenerator().addProvider(true,
                    new LootTableProvider(
                            output,
                            Set.of(),
                            List.of(new LootTableProvider.SubProviderEntry(
                                    ModBlockLootProvider::new,
                                    LootContextParamSets.BLOCK
                            )),
                            event.getLookupProvider()
                    )
            );
        }
    }
    //?}

    //? if >=1.21.4 {
    /*/^*
     * 1.21.4+: register providers via GatherDataEvent.Client#createProvider(...).
     * (NeoForge docs recommend registering *all* providers here, and using runClientData.)
     ^/
    public static void gatherData(final GatherDataEvent.Client event) {
        // Client-side generators
        event.createProvider(output -> new ModLanguageProvider(output, "en_us"));
        event.createProvider(ModBlockModelProvider::new); // ModelProvider generates block models + blockitems (+ your non-block items)

        // Server/datapack generators
        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider(ModBlockTagsProvider::new);
        event.createProvider((output, lookup) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(
                        ModBlockLootProvider::new,
                        LootContextParamSets.BLOCK
                )),
                lookup
        ));
    }
    *///?}

    private ModDataGenerators() {}
}
