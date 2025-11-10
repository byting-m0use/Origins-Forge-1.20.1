package net.bytem0use.origins.abilities.ability.passives;

import net.bytem0use.origins.abilities.api.effects.PassiveEffect;
import net.bytem0use.origins.abilities.enums.PassiveType;
import net.minecraft.world.effect.MobEffectCategory;

public class Frozen extends PassiveEffect {

    public Frozen(String id, MobEffectCategory pCategory, PassiveType type) {
        super(id, pCategory, type);
    }

    @Override
    public boolean shouldRenderIcon() {
        return true;
    }
}
