package net.bytem0use.origins.ability.trait;

import net.bytem0use.origins.ability.PassiveEffect;
import net.bytem0use.origins.ability.TraitModifier;
import net.bytem0use.origins.enums.PassiveType;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber
public class NoFallDamage extends TraitModifier {

    public NoFallDamage(String pName, double pAmount, Operation pOperation) {
        super(pName, pAmount, pOperation);
    }

    @SubscribeEvent
    public static void onEntityFall(LivingFallEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity());
        }

    }

    public static void execute(Entity entity) {
        execute((Event)null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity != null) {
            if (entity.getPersistentData().getBoolean("nofalldamage")) {
                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                }

                entity.fallDistance = 0.0F;
                entity.getPersistentData().putBoolean("nofalldamage", false);
            }

        }
    }
}
