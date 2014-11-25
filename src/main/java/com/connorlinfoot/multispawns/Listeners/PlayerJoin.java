package com.connorlinfoot.multispawns.Listeners;

import com.connorlinfoot.multispawns.MultiSpawns;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        randomSpawn(event.getPlayer());
    }

    private static void randomSpawn(Player player) {
        player.sendMessage(MultiSpawns.getPlugin().getConfig().get("Spawns").toString());
    }

}
