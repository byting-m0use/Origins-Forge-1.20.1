package net.bytem0use.origins.abilities.ability;

import net.bytem0use.origins.abilities.ability.trait.NoFallDamage;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes extends RangedAttribute {

    public ModAttributes(String pDescriptionId, double pDefaultValue, double pMin, double pMax) {
        super(pDescriptionId, pDefaultValue, pMin, pMax);
    }

    public static final DeferredRegister<Attribute> ATTRIBUTE;

    public static final RegistryObject<Attribute> NO_FALL_DAMAGE;

    static {
        ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, "origins");

        NO_FALL_DAMAGE = ATTRIBUTE.register("no_fall_damage", () -> new NoFallDamage("no_fall_damage", 5));
    }

    public static void registerAttributes(IEventBus eventBus) {
        ATTRIBUTE.register(eventBus);
    }
}
