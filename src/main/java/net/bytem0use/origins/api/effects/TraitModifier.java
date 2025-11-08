package net.bytem0use.origins.api.effects;

import net.bytem0use.origins.api.interfaces.Modifiers;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class TraitModifier extends AttributeModifier implements Modifiers {
    private String attributeID;

    public TraitModifier(String pName, double pAmount, Operation pOperation) {
        super(pName, pAmount, pOperation);
    }

    @Override
    public void addAttributeModifier() {
    }

    @Override
    public boolean applyModifier() {
        return false;
    }

    @Override
    public void getModifierValues() {
    }
}
