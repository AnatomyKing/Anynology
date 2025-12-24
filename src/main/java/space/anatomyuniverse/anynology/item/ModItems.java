package space.anatomyuniverse.anynology.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import space.anatomyuniverse.anynology.AnyCore;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AnyCore.MOD_ID);

    public static final DeferredItem<Item> RAW_ANYTOMITHIUM =
            ITEMS.registerItem("raw_anytomithium", props -> new Item(props.rarity(Rarity.RARE)));

    public static final DeferredItem<Item> PURPISH_ANYTOMITHIUM_INGOT =
            ITEMS.registerItem("purpish_anytomithium_ingot", props -> new Item(props.rarity(Rarity.RARE)));

    public static final DeferredItem<Item> TEALISH_ANYTOMITHIUM_INGOT =
            ITEMS.registerItem("tealish_anytomithium_ingot", props -> new Item(props.rarity(Rarity.RARE)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    private ModItems() {}
}
