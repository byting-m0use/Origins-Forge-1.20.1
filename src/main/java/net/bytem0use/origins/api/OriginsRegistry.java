package net.bytem0use.origins.api;

import net.bytem0use.origins.ability.PassiveEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.function.Supplier;

public class OriginsRegistry {
    private static HashMap<String, String> langMap = new HashMap();
    public static final DeferredRegister<PassiveEffect> PASSIVE;

    public static HashMap<String, String> getLangMap() {
        return langMap;
    }

    public static String getResourceName(String text) {
        return text.replaceAll("[ \\t]+$", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\s+", "_")
                .replaceAll("[\\'\\:\\-\\,\\#]",
                        "").replaceAll("\\&",
                        "and").toLowerCase();
    }

    public static <T extends PassiveEffect> RegistryObject<T> registerPassive(String idName, Supplier<T> effect) {
        String resourceName = OriginsRegistry.getResourceName(idName);
        return registerPassive(idName, resourceName, effect);
    }

    public static <T extends PassiveEffect> RegistryObject<T> registerPassive(String idName, String resourceKey, Supplier<T> effect) {
        String resourceName = OriginsRegistry.getResourceName(resourceKey);
        getLangMap().put("effect.origins." + resourceName, idName);
        RegistryObject<T> reg = PASSIVE.register(resourceName, effect);
        return reg;
    }
    static {
        PASSIVE = DeferredRegister.create(OriginsRegistries.PASSIVES, "origins");
    }
}
