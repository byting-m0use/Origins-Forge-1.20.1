package net.bytem0use.origins.abilities.api;

import net.bytem0use.origins.abilities.ability.AssignableAbility;
import net.bytem0use.origins.abilities.ability.OriginsAbilities;
import net.bytem0use.origins.abilities.enums.AbilityCategory;
import net.bytem0use.origins.tester.effects.SuperPunch;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AbilityRegistry {
    public static final DeferredRegister<OriginsAbilities> ORIGINS_ABILITIES;

    public static final RegistryObject<SuperPunch> SUPER_PUNCH;

    public static void registerAbilities(IEventBus eventBus) {
        ORIGINS_ABILITIES.register(eventBus);
    }

    public static void addAttributeModifier(LivingEntity entity, AttributeModifier attribute, int amplifier) {

    }

    public static void addAssignableAbility(LivingEntity entity, AssignableAbility ability, int key) {
    }

    static{
        ORIGINS_ABILITIES = DeferredRegister.create(OriginsRegistries.ABILITIES, "origins");

        SUPER_PUNCH = ORIGINS_ABILITIES.register("super_punch", () -> new SuperPunch("super_punch", AbilityCategory.COMBO, MobEffectCategory.BENEFICIAL));
    }
}
