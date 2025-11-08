package net.bytem0use.origins.ability.trait;

import net.bytem0use.origins.api.effects.TraitModifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber
public class NoFallDamage extends Attribute {

    public NoFallDamage(String pDescriptionId, double pDefaultValue) {
        super(pDescriptionId, pDefaultValue);
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
