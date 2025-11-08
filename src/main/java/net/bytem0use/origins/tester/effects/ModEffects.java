package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.Origins;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Origins.MODID);

    public static final RegistryObject<MobEffect> MUSCLES_EFFECT = MOB_EFFECTS.register("muscles",
            () -> new MusclesEffect(MobEffectCategory.NEUTRAL, 0x36ebab));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
