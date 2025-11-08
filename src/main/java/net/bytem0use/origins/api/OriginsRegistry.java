package net.bytem0use.origins.api;

import net.bytem0use.origins.ability.OriginsAbilities;
import net.bytem0use.origins.api.effects.PassiveEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.function.Supplier;

public class OriginsRegistry {
    private static final HashMap<String, String> langMap = new HashMap<>();
    public static final DeferredRegister<PassiveEffect> PASSIVE;
    public static final DeferredRegister<Attribute> ATTRIBUTE;
    public static final DeferredRegister<AttributeModifier> ATTRIBUTE_MOD;
    public static final DeferredRegister<OriginsAbilities> ABILITIES;

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

    public static RegistryObject<Attribute> registerAttribute(String iDName, Supplier<Attribute> attr) {
        String resourceName = OriginsRegistry.getResourceName(iDName);
        getLangMap().put("OriginsAttribute: " + resourceName, iDName);
        return ATTRIBUTE.register("attribute." + resourceName, attr);
    }

    public static RegistryObject<AttributeModifier> registerAttributeModifier(String iDName, Supplier<AttributeModifier> attribute) {
        String resourceName = OriginsRegistry.getResourceName(iDName);
        getLangMap().put("OriginsAttribute: " + resourceName, iDName);
        return ATTRIBUTE_MOD.register("modifier." + resourceName, attribute);
    }

    static {
        PASSIVE = DeferredRegister.create(OriginsRegistries.PASSIVES, "origins");
        ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "origins");
        ATTRIBUTE_MOD = DeferredRegister.create(OriginsRegistries.ATTRIBUTE_MODIFIERS, "origins");
        ABILITIES = DeferredRegister.create(OriginsRegistries.ABILITIES, "origins");

    }
}
