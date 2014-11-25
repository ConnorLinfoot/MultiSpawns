package com.connorlinfoot.multispawns.Commands;

import com.connorlinfoot.multispawns.MultiSpawns;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class AddSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if( !(sender instanceof Player) ){
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "Command must be ran as a player");
            return false;
        }

        if( args.length != 1 ){
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "/addspawn <name>");
            return false;
        }

        Player player = (Player) sender;
        Location location = player.getLocation();
        FileConfiguration config = MultiSpawns.getPlugin().getConfig();
        String name = args[0];

        config.set("Spawns." + name + ".X",location.getBlockX());
        config.set("Spawns." + name + ".Y",location.getBlockY());
        config.set("Spawns." + name + ".Z",location.getBlockZ());
        config.set("Spawns." + name + ".World", location.getWorld().getName());
        MultiSpawns.getPlugin().saveConfig();
        sender.sendMessage(MultiSpawns.Prefix + ChatColor.GREEN + "The spawn " + name + " was added");

        return true;
    }

}
