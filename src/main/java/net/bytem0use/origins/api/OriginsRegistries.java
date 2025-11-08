package net.bytem0use.origins.api;

import net.bytem0use.origins.ability.OriginsAbilities;
import net.bytem0use.origins.api.effects.PassiveEffect;
import net.bytem0use.origins.api.effects.TraitModifier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.*;

public class OriginsRegistries {
    public static final IForgeRegistry<PassiveEffect> PASSIVES;
    public static final IForgeRegistry<Attribute> ATTRIBUTE;
    public static final IForgeRegistry<AttributeModifier> ATTRIBUTE_MODIFIERS;
    public static final IForgeRegistry<OriginsAbilities> ABILITIES;

    private static void init() {
        OriginsRegistries.Keys.init();
        GameData.init();
        Bootstrap.bootStrap();
        Tags.init();
    }


    static {
        init();
        PASSIVES = RegistryManager.ACTIVE.getRegistry(Keys.PASSIVE_EFFECT);
        ATTRIBUTE = RegistryManager.ACTIVE.getRegistry(Keys.ATTRIBUTE);
        ATTRIBUTE_MODIFIERS = RegistryManager.ACTIVE.getRegistry(Keys.ATTRIBUTE_MODIFIERS);
        ABILITIES = RegistryManager.ACTIVE.getRegistry(Keys.ABILITIES);
    }

    public static final class Keys {
        public static final ResourceKey<Registry<PassiveEffect>> PASSIVE_EFFECT = key("passive_effect");
        public static final ResourceKey<Registry<Attribute>> ATTRIBUTE = key("attribute");
        public static final ResourceKey<Registry<AttributeModifier>> ATTRIBUTE_MODIFIERS = key("attribute_modifier");
        public static final ResourceKey<Registry<OriginsAbilities>> ABILITIES = key("abilities");

        private static <T> ResourceKey<Registry<T>> key(String name) {
            return ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace(name));
        }

        private static void init() {
        }
    }

    public static void Builder() {

    }

    public interface IFactory<A> {
        A create(OriginsRegistries<A> var1);
    }
}
