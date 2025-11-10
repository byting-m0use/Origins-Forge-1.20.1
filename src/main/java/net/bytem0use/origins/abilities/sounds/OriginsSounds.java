package net.bytem0use.origins.abilities.sounds;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

public class OriginsSounds {

    public static SoundSource getProperSource(LivingEntity entity) {
        return entity instanceof Player ? SoundSource.PLAYERS : (entity instanceof Mob ? SoundSource.HOSTILE : SoundSource.MASTER);
    }

    public static void playSoundAtEntity(LivingEntity entity, SoundEvent sound, float volume, float pitch) {
        if (sound != null) {
            entity.getCommandSenderWorld().playSound(null, new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ()), sound, getProperSource(entity), volume, pitch);
        }

    }
}
