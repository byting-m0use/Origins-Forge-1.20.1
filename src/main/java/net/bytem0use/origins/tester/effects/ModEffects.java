package net.bytem0use.origins.tester.effects;

import net.bytem0use.origins.Origins;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Origins.MODID);

    public static final RegistryObject<MobEffect> MUSCLES_EFFECT = MOB_EFFECTS.register("muscles",
            () -> new MusclesEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "f81d4fae-7dec-11d0-a765-00a0c91e6bf6",
                            4, AttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK, "bcf535c0-482a-430c-836f-2f54a8e63e2a",
                            2.5f, AttributeModifier.Operation.MULTIPLY_BASE));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
