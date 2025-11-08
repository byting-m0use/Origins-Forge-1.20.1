package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.ability.AssignableAbility;
import net.bytem0use.origins.api.OriginsRegistries;
import net.bytem0use.origins.api.conditional.IConditional;
import net.bytem0use.origins.enums.AbilityCategory;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.*;

import java.util.Map;

public class SuperPunch extends AssignableAbility implements IConditional {

    public SuperPunch(String name, AbilityCategory pCategory, MobEffectCategory Category) {
        super(name, pCategory, Category);
    }

    @Override
    public boolean hasAbility(LivingEntity entity) {
        return super.hasAbility(entity);
    }

    static {
    }
}
