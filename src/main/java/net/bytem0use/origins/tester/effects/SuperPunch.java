package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.abilities.ability.AssignableAbility;
import net.bytem0use.origins.abilities.api.conditional.IConditional;
import net.bytem0use.origins.abilities.enums.AbilityCategory;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SuperPunch extends AssignableAbility implements IConditional {

    public SuperPunch(String name, AbilityCategory pCategory, MobEffectCategory Category) {
        super(name, pCategory, Category);
    }

    @Override
    public boolean hasAbility(LivingEntity entity) {
        return super.hasAbility(entity);
    }
}
