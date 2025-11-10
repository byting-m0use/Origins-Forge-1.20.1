package net.bytem0use.origins.abilities.api.effects;

import net.bytem0use.origins.abilities.ability.OriginsAbilities;
import net.bytem0use.origins.abilities.enums.AbilityCategory;
import net.bytem0use.origins.abilities.enums.PassiveType;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class PassiveEffect extends OriginsAbilities {
    private PassiveType type;
    private String name;


    private PassiveEffect(String name, AbilityCategory pCategory, MobEffectCategory Category) {
        super(name, pCategory, Category);
    }

    public PassiveEffect(String id, MobEffectCategory pCategory, PassiveType type) {
        super(pCategory, -2);
        this.name = id;
        this.type = type;

    }

    @Override
    public OriginsAbilities addAttributeModifier(Attribute pAttribute, String pUuid, double pAmount, AttributeModifier.Operation pOperation) {
        return super.addAttributeModifier(pAttribute, pUuid, pAmount, pOperation);
    }

    @Override
    public double getAttributeModifierValue(int pAmplifier, AttributeModifier pModifier) {
        return super.getAttributeModifierValue(pAmplifier, pModifier);
    }
}
