package com.connorlinfoot.multispawns.Commands;

import com.connorlinfoot.multispawns.MultiSpawns;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class DelSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "/delspawn <name>");
            return false;
        }

        String name = args[0];
        FileConfiguration config = MultiSpawns.getPlugin().getConfig();
        if (!config.isSet("Spawns." + name)) {
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "The spawn point " + name + " does not exist");
            return false;
        }

        config.set("Spawns." + name, null);
        sender.sendMessage(MultiSpawns.Prefix + ChatColor.GREEN + "The spawn point " + name + " was removed");
        return true;
    }

}
