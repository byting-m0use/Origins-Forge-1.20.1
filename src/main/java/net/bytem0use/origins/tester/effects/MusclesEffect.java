package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.ability.AssignableAbility;
import net.bytem0use.origins.ability.Attributes;
import net.bytem0use.origins.ability.OriginsAbilities;
import net.bytem0use.origins.api.AbilityRegistry;
import net.bytem0use.origins.api.OriginsRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public class MusclesEffect extends MobEffect {

    protected MusclesEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
    public void onUpdate(Player player, ModEffects effects) {
        if (player.hasEffect(MusclesEffect.this)); {
            this.onUpdate(player, effects);
            AbilityRegistry.addAttributeModifier(player, (AttributeModifier)Attributes.STRENGTH.get(), 13);
        }

    }

    public void onApplied(Player player, ModEffects effects) {
        if (player.hasEffect(MusclesEffect.this)) {
            AbilityRegistry.addAssignableAbility(player, (AssignableAbility)AbilityRegistry.SUPER_PUNCH.get(), 1);
        }

    }


}
