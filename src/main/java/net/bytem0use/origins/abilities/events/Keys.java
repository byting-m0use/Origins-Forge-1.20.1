package net.bytem0use.origins.abilities.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Keys extends PlayerEvent {

    public Keys(Player player) {
        super(player);
    }

    @SubscribeEvent
    public static void onKeyPressed(InputEvent.Key key) {
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent clientTick) {
    }
}
