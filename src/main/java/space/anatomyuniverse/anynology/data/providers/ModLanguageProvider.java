package space.anatomyuniverse.anynology.data.providers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import space.anatomyuniverse.anynology.AnyCore;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Auto language provider:
 * - Adds names for ALL blocks in "anynology".
 * - Adds names for NON-block items only (skips BlockItems; they use block.* keys).
 * - Humanizes ids: "lobby_wallpaper_plinth" -> "Lobby Wallpaper Plinth".
 * - OVERRIDES are applied, and auto-generation SKIPS overridden keys (so no duplicates).
 *
 * Output: assets/anynology/lang/<locale>.json
 */
public final class ModLanguageProvider extends LanguageProvider {

    /** Full translation key -> custom text. */
    private static final Map<String, String> OVERRIDES = new LinkedHashMap<>();

    static {
        // Creative tab display name
        OVERRIDES.put("itemGroup." + AnyCore.MOD_ID + ".anynology_tab", "Anynology");

        // Examples (uncomment if needed):
        // OVERRIDES.put("item.anynology.purpish_anytomithium_ingot", "Purplish Anytomithium Ingot");
        // OVERRIDES.put("block.anynology.some_block", "Some Block");
    }

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, AnyCore.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        final String modid = AnyCore.MOD_ID;

        // 1) Blocks -> block.anynology.<id> = Human Name (skip if overridden)
        for (Block b : BuiltInRegistries.BLOCK) {
            ResourceLocation id = BuiltInRegistries.BLOCK.getKey(b);
            if (id == null || !modid.equals(id.getNamespace())) continue;

            String path = id.getPath();
            String key = "block." + modid + "." + path;

            if (OVERRIDES.containsKey(key)) continue; // avoid duplicates; overrides win
            add(key, humanize(path));
        }

        // 2) Items (non-BlockItems) -> item.anynology.<id> = Human Name (skip if overridden)
        for (Item it : BuiltInRegistries.ITEM) {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(it);
            if (id == null || !modid.equals(id.getNamespace())) continue;
            if (it instanceof BlockItem) continue;

            String path = id.getPath();
            String key = "item." + modid + "." + path;

            if (OVERRIDES.containsKey(key)) continue; // avoid duplicates; overrides win
            add(key, humanize(path));
        }

        // 3) Creative tab name: only add a default if NOT overridden
        String tabKey = "itemGroup." + modid + ".anynology_tab";
        if (!OVERRIDES.containsKey(tabKey)) {
            add(tabKey, "Anynology");
        }

        // 4) Apply overrides last (safe: we skipped any auto-generated keys that collide)
        OVERRIDES.forEach(this::add);
    }

    /** "lobby_wallpaper_plinth" -> "Lobby Wallpaper Plinth" (with acronym touch-ups). */
    private static String humanize(String registryPath) {
        String[] parts = registryPath.toLowerCase(Locale.ROOT).split("[_\\-]+");
        StringBuilder out = new StringBuilder(parts.length * 6);
        for (String p : parts) {
            if (p.isEmpty()) continue;
            out.append(Character.toUpperCase(p.charAt(0)))
                    .append(p.length() > 1 ? p.substring(1) : "")
                    .append(' ');
        }
        String s = out.toString().trim();
        return s.replace("Tnt", "TNT")
                .replace("Tv", "TV")
                .replace("Gps", "GPS");
    }
}
