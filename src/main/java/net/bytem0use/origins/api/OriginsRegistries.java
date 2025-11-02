package net.bytem0use.origins.api;

import net.bytem0use.origins.ability.PassiveEffect;
import net.bytem0use.origins.ability.TraitModifier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Bootstrap;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.*;

public class OriginsRegistries {
    public static final IForgeRegistry<PassiveEffect> PASSIVES;
    public static final IForgeRegistry<TraitModifier> TRAIT;

    private static void init() {
        OriginsRegistries.Keys.init();
        GameData.init();
        Bootstrap.bootStrap();
        Tags.init();
    }

    static {
        init();
        PASSIVES = RegistryManager.ACTIVE.getRegistry(Keys.PASSIVE_EFFECT);
        TRAIT = RegistryManager.ACTIVE.getRegistry(Keys.TRAIT);
    }

    public static final class Keys {
        public static final ResourceKey<Registry<PassiveEffect>> PASSIVE_EFFECT = key("passive_effect");
        public static final ResourceKey<Registry<TraitModifier>> TRAIT = key("trait");

        private static <T> ResourceKey<Registry<T>> key(String name) {
            return ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace(name));
        }

        private static void init() {
        }
    }
}
