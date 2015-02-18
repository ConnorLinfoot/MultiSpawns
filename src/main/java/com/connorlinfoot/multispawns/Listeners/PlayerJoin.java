package com.connorlinfoot.multispawns.Listeners;

import com.connorlinfoot.multispawns.MultiSpawns;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
		if (MultiSpawns.ONLYNEW) {
			if (!MultiSpawns.getPlugin().getConfig().isSet("Players." + event.getPlayer().getUniqueId().toString()) {
				randomSpawn(event.getPlayer());
				MultiSpawns.getPlugin().getConfig().set("Players." + event.getPlayer().getUniqueId().toString(), true );
				MultiSpawns.getPlugin().saveConfig();
			}
		} else {
			randomSpawn(event.getPlayer());
		}
    }

    public static void randomSpawn(Player player) {
        FileConfiguration config = MultiSpawns.getPlugin().getConfig();
        if (config.getConfigurationSection("Spawns") == null) return;
        int size = config.getConfigurationSection("Spawns").getKeys(false).size();
        if (size == 0) return;
        int ii = randInt(0, size - 1);
        int i = 0;
        for (String key : config.getConfigurationSection("Spawns").getKeys(false)) {
            if (i == ii) {
                int lX = config.getInt("Spawns." + key + ".X");
                int lY = config.getInt("Spawns." + key + ".Y");
                int lZ = config.getInt("Spawns." + key + ".Z");
                String lWorld = config.getString("Spawns." + key + ".World");

                Location location;
                location = player.getLocation();
                location.setX(lX);
                location.setY(lY);
                location.setZ(lZ);
                if (Bukkit.getWorld(lWorld) != null) {
                    location.setWorld(Bukkit.getWorld(lWorld));
                }
                player.teleport(location);
                break;
            }
            i++;
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
