package com.connorlinfoot.multispawns.Commands;

import com.connorlinfoot.multispawns.MultiSpawns;
import com.connorlinfoot.multispawns.Listeners.PlayerJoin;
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
        if (!sender.hasPermission("multispawn.spawn")) {
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "You do not have the permissions to run this command");
            return false;
        }

        if( !(sender instanceof Player) ){
            sender.sendMessage(MultiSpawns.Prefix + ChatColor.RED + "Command must be ran as a player");
            return false;
        }

        Player player = (Player) sender;
		PlayerJoin.randomSpawn(player);
		player.sendMessage(MultiSpawns.Prefix + ChatColor.GREEN + "You have been teleported to a random spawn");
        

        return true;
    }

}
