package net.bytem0use.origins.abilities.ability;

import net.bytem0use.origins.abilities.ability.trait.NoFallDamage;
import net.bytem0use.origins.abilities.ability.trait.Strength;
import net.bytem0use.origins.abilities.api.OriginsRegistries;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Attributes extends Attribute {
    protected Attributes(String pDescriptionId, double pDefaultValue) {
        super(pDescriptionId, pDefaultValue);
    }

    public static final DeferredRegister<Attribute> ATTRIBUTE;
    public static final DeferredRegister<AttributeModifier> ATTRIBUTE_MOD;

    public static final RegistryObject<Attribute> NO_FALL_DAMAGE;
    public static final RegistryObject<AttributeModifier> STRENGTH;

    static {
        ATTRIBUTE = DeferredRegister.create(OriginsRegistries.ATTRIBUTE, "origins");
        ATTRIBUTE_MOD = DeferredRegister.create(OriginsRegistries.ATTRIBUTE_MODIFIERS, "origins");

        NO_FALL_DAMAGE = ATTRIBUTE.register("no_fall_damage", () -> new NoFallDamage("no_fall_damage", 5));
        STRENGTH = ATTRIBUTE_MOD.register("strength", () -> new Strength("strength", 5, AttributeModifier.Operation.ADDITION));
    }

    public static void registerAttributes(IEventBus eventBus) {
        ATTRIBUTE.register(eventBus);
    }
}
