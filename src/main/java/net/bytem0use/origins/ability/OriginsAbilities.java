package net.bytem0use.origins.ability;

import net.bytem0use.origins.enums.AbilityCategory;
import net.bytem0use.origins.enums.PassiveType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
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

    public String getId(String id) {
        return this.id;
    }

    public AbilityCategory getCategory(AbilityCategory pCategory) {
        return this.category;
    }

    public boolean hasPowerEffect() {
        return true;
    }

    public void onKeyPressed(Player player, Map<Key , Boolean> keyMap) {
    }


}
