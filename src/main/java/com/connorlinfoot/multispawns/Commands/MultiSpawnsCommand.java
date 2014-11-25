package com.connorlinfoot.multispawns.Commands;

import com.connorlinfoot.multispawns.MultiSpawns;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MultiSpawnsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.AQUA + "MultiSpawns Help");
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.GREEN + "/addspawn <name> - Add a spawn");
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.GREEN + "/delspawn <name> - Delete a spawn");
            return true;
        }
        sender.sendMessage(MultiSpawns.Prefix + ChatColor.AQUA + "\"" + MultiSpawns.getPlugin().getDescription().getName() + "\" - Version: " + MultiSpawns.getPlugin().getDescription().getVersion());
        return true;
    }

}
