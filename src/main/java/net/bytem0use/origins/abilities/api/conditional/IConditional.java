package net.bytem0use.origins.abilities.api.conditional;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.*;

public interface IConditional {

    boolean isFalling(LivingFallEvent event);

    boolean hasAbility(LivingEntity entity);

    boolean isInWater(LivingEntity entity);

    boolean canBreathe(LivingBreatheEvent event);

    LivingHurtEvent playerHurt(LivingHurtEvent event);

    LivingDrownEvent playerDrowns(LivingDrownEvent event);

    LivingDeathEvent playerDies(LivingDeathEvent event);


}
