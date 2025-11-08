package net.bytem0use.origins.ability.trait;

import net.bytem0use.origins.api.effects.TraitModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class Strength extends AttributeModifier {

    public Strength(String pName, double pAmount, Operation pOperation) {
        super(pName, pAmount, pOperation);
    }
}
