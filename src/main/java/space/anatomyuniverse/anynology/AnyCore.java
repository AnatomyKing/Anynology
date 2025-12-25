// file: src/main/java/space/anatomyuniverse/anynology/AnyCore.java
package space.anatomyuniverse.anynology;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import space.anatomyuniverse.anynology.block.ModBlocks;
import space.anatomyuniverse.anynology.client.render.AnyRenderLayers;
import space.anatomyuniverse.anynology.data.ModDataGenerators;
import space.anatomyuniverse.anynology.item.ModCreativeTabs;
import space.anatomyuniverse.anynology.item.ModItems;


//? if <1.21.9 {
import net.neoforged.fml.loading.FMLLoader;
//?} else {
/*import net.neoforged.fml.loading.FMLEnvironment;
*///?}


@Mod(AnyCore.MOD_ID)
public final class AnyCore {
    public static final String MOD_ID = "anynology";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String VERSION = /*$ mod_version*/ "0.0.0";
    public static final String MINECRAFT = /*$ minecraft*/ "1.21.8";

    public AnyCore(IEventBus modBus, ModContainer container) {
        // Registries
        ModItems.register(modBus);
        ModBlocks.register(modBus);
        ModCreativeTabs.register(modBus);

        // Common lifecycle
        modBus.addListener(this::commonSetup);

        // Datagen hook (MUST be unconditional)
        modBus.addListener(ModDataGenerators::gatherData);

        // Client-only hooks
        //? if <1.21.9 {
        if (FMLLoader.getDist() == Dist.CLIENT) {
            modBus.addListener(AnyRenderLayers::onModifyBakingResult);
        }
        //?} else {
        /*if (FMLEnvironment.getDist() == Dist.CLIENT) {
            modBus.addListener(AnyRenderLayers::onModifyBakingResult);
        }
        *///?}
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

}
