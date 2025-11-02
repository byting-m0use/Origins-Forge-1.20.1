package net.bytem0use.origins.api.effects;

import net.bytem0use.origins.ability.PassiveEffect;
import net.bytem0use.origins.ability.TraitModifier;
import net.bytem0use.origins.ability.trait.NoFallDamage;
import net.bytem0use.origins.api.OriginsRegistries;
import net.bytem0use.origins.enums.PassiveType;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Traits extends TraitModifier{
    public Traits(String pName, double pAmount, Operation pOperation) {
        super(pName, pAmount, pOperation);
    }

    public static final DeferredRegister<TraitModifier> TRAIT;

    public static final RegistryObject<TraitModifier> NO_FALL_DAMAGE;

    static {
        TRAIT = DeferredRegister.create(OriginsRegistries.TRAIT, "origins");

        NO_FALL_DAMAGE = TRAIT.register("no_fall_damage", () -> new NoFallDamage("no_fall_damage", 0, Operation.ADDITION));
    }
}
