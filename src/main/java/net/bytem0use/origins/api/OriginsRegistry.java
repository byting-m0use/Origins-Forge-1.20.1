package net.bytem0use.origins.api;

import net.bytem0use.origins.ability.OriginsAbilities;
import net.bytem0use.origins.api.effects.PassiveEffect;
import net.bytem0use.origins.api.effects.TraitModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.function.Supplier;

public class OriginsRegistry {
    private static HashMap<String, String> langMap = new HashMap();
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

    public static <A extends OriginsAbilities> RegistryObject<A> registerAbility(String id, OriginsAbilities ability) {
        String resourceName = OriginsRegistry.getResourceName(OriginsAbilities.getId(id));
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath("origins", resourceName);
        getLangMap().put("OriginsAbilities: " + resourceName, OriginsAbilities.getId(id));
        RegistryObject<OriginsAbilities> ret = RegistryObject.create(key, OriginsRegistries.ABILITIES);
        if (!ABILITIES.getEntries().contains(ret)) {
            ABILITIES.register(resourceName, () -> ability);
        }
        return registerAbility(id, ability);
    }

    public static RegistryObject<Attribute> registerAttribute(String iDName, Supplier<Attribute> attr) {
        String resourceName = OriginsRegistry.getResourceName(iDName);
        getLangMap().put("OriginsAttribute: " + resourceName, iDName);
        RegistryObject<Attribute> reg = ATTRIBUTE.register("attribute." + resourceName, attr);
        return reg;
    }

    public static RegistryObject<AttributeModifier> registerAttributeModifier(String iDName, Supplier<AttributeModifier> attr) {
        String resourceName = OriginsRegistry.getResourceName(iDName);
        getLangMap().put("OriginsAttribute: " + resourceName, iDName);
        RegistryObject<AttributeModifier> reg = ATTRIBUTE_MOD.register("modifier." + resourceName, attr);
        return reg;
    }

    static {
        PASSIVE = DeferredRegister.create(OriginsRegistries.PASSIVES, "origins");
        ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "origins");
        ATTRIBUTE_MOD = DeferredRegister.create(OriginsRegistries.ATTRIBUTE_MODIFIERS, "origins");
        ABILITIES = DeferredRegister.create(OriginsRegistries.ABILITIES, "origins");

    }
}
