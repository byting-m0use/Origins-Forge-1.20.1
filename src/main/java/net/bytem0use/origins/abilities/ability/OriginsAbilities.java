package net.bytem0use.origins.abilities.ability;

import net.bytem0use.origins.abilities.enums.AbilityCategory;
import net.bytem0use.origins.abilities.helpers.AbilityHelper;
import net.bytem0use.origins.abilities.helpers.IAbilityCapability;
import net.bytem0use.origins.abilities.sounds.OriginsSounds;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

import java.security.Key;
import java.util.Map;

public class OriginsAbilities extends MobEffect {
    private String id;
    private AbilityCategory category;

    protected OriginsAbilities(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public OriginsAbilities(String name, AbilityCategory pCategory, MobEffectCategory Category) {
        super(Category, -2);
        this.id = name;
        this.category = pCategory;
    }

    public double getAttributeModifierValues(int amplifier, AttributeModifier modifier) {
        return (double)amplifier;
    }

    public boolean shouldRenderIcon(){
        return false;
    }

    public OriginsAbilities addAttributeModifier(Attribute pAttribute, String pUuid, double pAmount, AttributeModifier.Operation pOperation){
        super.addAttributeModifier(pAttribute, pUuid, pAmount, pOperation);
        return this;
    }

    public static String getId(String id) {
        return id;
    }

    public AbilityCategory getCategory(AbilityCategory pCategory) {
        return this.category;
    }

    public boolean hasPowerEffect() {
        return true;
    }

    public void onKeyPressed(Player player, Map<Key , Boolean> keyMap) {
    }

    public static void setAbility(LivingEntity entity, MobEffect effect, int duration, float damage, int cooldown, float range) {
        if (effect instanceof AssignableAbility ability) {
            if (!entity.level().isClientSide) {
                ability.damage(entity, damage, false);
                ability.range(entity, range, false);
                ability.updateState(entity);
                if (ability.getType()) {
                    if (ability.isActive(entity)) {
                        ability.resetTicks(entity, true);
                    } else {
                        ability.cooldown(entity, cooldown, false);
                        ability.setCurrentTick(entity, 0, false);
                        ability.setMaxTicks(entity, duration, false);
                        OriginsSounds.playSoundAtEntity(entity, ability.getCastSound(entity), ability.getCastSoundVolume(entity), ability.getCastSoundPitch(entity));
                    }
                } else if (ability.getType()) {
                    ability.cooldown(entity, cooldown, false);
                    ability.setCurrentTick(entity, 0, false);
                    ability.setMaxTicks(entity, duration, false);
                    OriginsSounds.playSoundAtEntity(entity, ability.getCastSound(entity), ability.getCastSoundVolume(entity), ability.getCastSoundPitch(entity));
                }

                entity.getCapability(AbilityHelper.CAPABILITY).ifPresent(IAbilityCapability::syncToAll);
            }
        }

    }


}
