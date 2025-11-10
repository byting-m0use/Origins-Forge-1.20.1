package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.abilities.ability.AssignableAbility;
import net.bytem0use.origins.abilities.api.AbilityRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;

public class MusclesEffect extends MobEffect {

    protected MusclesEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

    public void onApplied(Player player, ModEffects effects) {
        if (player.hasEffect(MusclesEffect.this)) {
            AbilityRegistry.addAssignableAbility(player, (AssignableAbility)AbilityRegistry.SUPER_PUNCH.get(), 1);
        }

    }


}
