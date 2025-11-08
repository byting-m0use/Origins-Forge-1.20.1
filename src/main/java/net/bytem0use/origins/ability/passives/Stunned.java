package net.bytem0use.origins.ability.passives;

import net.bytem0use.origins.api.effects.PassiveEffect;
import net.bytem0use.origins.enums.PassiveType;
import net.minecraft.world.effect.MobEffectCategory;

public class Stunned extends PassiveEffect {

    public Stunned(String id, MobEffectCategory pCategory, PassiveType type) {
        super(id, pCategory, type);
    }

    @Override
    public boolean shouldRenderIcon() {
        return true;
    }
}
