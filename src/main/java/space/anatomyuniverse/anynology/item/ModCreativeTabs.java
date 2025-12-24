package space.anatomyuniverse.anynology.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import space.anatomyuniverse.anynology.AnyCore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnyCore.MOD_ID);

    // Optional: skip specific registry paths from showing up in the tab
    private static final Set<String> BLACKLIST = Set.of(
            // "debug_item"
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ANYNOLOGY_TAB =
            TABS.register("anynology_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + AnyCore.MOD_ID + ".anynology_tab"))
                    .icon(() -> new ItemStack(ModItems.PURPISH_ANYTOMITHIUM_INGOT.get()))
                    .displayItems((params, output) -> {
                        List<Item> mine = new ArrayList<>();
                        for (Item item : BuiltInRegistries.ITEM) {
                            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
                            if (id != null
                                    && AnyCore.MOD_ID.equals(id.getNamespace())
                                    && !BLACKLIST.contains(id.getPath())) {
                                mine.add(item);
                            }
                        }
                        mine.sort(Comparator.comparing(i -> BuiltInRegistries.ITEM.getKey(i).getPath()));
                        mine.forEach(output::accept);
                    })
                    .build()
            );

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }

    private ModCreativeTabs() {}
}
