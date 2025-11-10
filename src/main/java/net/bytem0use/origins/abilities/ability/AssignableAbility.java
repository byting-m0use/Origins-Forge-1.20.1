package net.bytem0use.origins.abilities.ability;

import net.bytem0use.origins.abilities.api.conditional.IConditional;
import net.bytem0use.origins.abilities.enums.AbilityCategory;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.network.PacketDistributor;

import java.util.Map;

public class AssignableAbility extends OriginsAbilities implements IConditional {
    public AssignableAbility(String name, AbilityCategory pCategory, MobEffectCategory Category) {
        super(name, pCategory, Category);
    }

    @Override
    public OriginsAbilities addAttributeModifier(Attribute pAttribute, String pUuid, double pAmount, AttributeModifier.Operation pOperation) {
        return super.addAttributeModifier(pAttribute, pUuid, pAmount, pOperation);
    }

    public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int amplifier) {
        super.removeAttributeModifiers(entity, map, amplifier);
        PacketDistributor.TRACKING_ENTITY.with(() -> entity).send(new ClientboundRemoveMobEffectPacket(entity.getId(), this));
    }

    public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int amplifier) {
        super.addAttributeModifiers(entity, map, amplifier);
        PacketDistributor.TRACKING_ENTITY.with(() -> entity).send(new ClientboundUpdateMobEffectPacket(entity.getId(), new MobEffectInstance(this, 32767, amplifier, false, false, false)));
    }

    public boolean getType() {
        return true;
    }

    public static void gettingKeySet(LivingEntity entity) {

    }

    public static void gettingTick(LivingEntity entity) {

    }

    public static void prevTick(LivingEntity entity, int tick, boolean sync) {

    }

    public static void cooldown(LivingEntity entity, int duration, boolean sync) {

    }

    public static void damage(LivingEntity entity, float damage, boolean sync) {

    }

    public static void range(LivingEntity entity, double range, boolean sync) {

    }

    public static void distance(LivingEntity entity) {
        
    }

    public static void attack(LivingEntity entity) {

    }

    public static void spawnParticles(LivingEntity entity) {

    }

    public void onKeyInput(Player player, Map<Integer, Boolean> map, boolean forceActivation) {

    }

    public void onActivate(Player var1, Map<Integer, Boolean> var2) {

    }

    public boolean onActivateEntity(LivingEntity entity) {
        return false;
    }

    public SoundEvent getCastSound(LivingEntity entity) {
        return null;
    }

    public SoundEvent getLoopSound(LivingEntity entity) {
        return null;
    }

    public boolean canPlayLoopSound(LivingEntity entity) {
        return true;
    }

    public SoundEvent getEndSound(LivingEntity entity) {
        return null;
    }

    public HitResult getHitResult(LivingEntity entity) {

        return null;
    }

    @Override
    public boolean isFalling(LivingFallEvent event) {
        return false;
    }

    @Override
    public boolean hasAbility(LivingEntity entity) {
        return false;
    }

    @Override
    public boolean isInWater(LivingEntity entity) {
        return false;
    }

    @Override
    public boolean canBreathe(LivingBreatheEvent event) {
        return false;
    }

    @Override
    public LivingHurtEvent playerHurt(LivingHurtEvent event) {
        return null;
    }

    @Override
    public LivingDrownEvent playerDrowns(LivingDrownEvent event) {
        return null;
    }

    @Override
    public LivingDeathEvent playerDies(LivingDeathEvent event) {
        return null;
    }

    public void setCurrentTick(LivingEntity entity, int i, boolean b) {
    }

    public void setMaxTicks(LivingEntity entity, int duration, boolean b) {
    }

    public void resetTicks(LivingEntity entity, boolean b) {
    }

    public boolean isActive(LivingEntity entity) {
        return true;
    }

    public void updateState(LivingEntity entity) {

    }

    public float getCastSoundVolume(LivingEntity entity) {
        return getCastSoundVolume(entity);
    }

    public float getCastSoundPitch(LivingEntity entity) {
        return getCastSoundPitch(entity);
    }
}
