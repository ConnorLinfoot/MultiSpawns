package com.connorlinfoot.multispawns;

import com.connorlinfoot.multispawns.Commands.AddSpawnCommand;
import com.connorlinfoot.multispawns.Commands.DelSpawnCommand;
import com.connorlinfoot.multispawns.Commands.MultiSpawnsCommand;
import com.connorlinfoot.multispawns.Commands.SpawnCommand;
import com.connorlinfoot.multispawns.Listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MultiSpawns extends JavaPlugin {
    private static Plugin plugin;
    public static boolean SNAPSHOT = false;
	public static boolean ONLYNEW = false;
    public static String Prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "MultiSpawns" + ChatColor.GRAY + "] " + ChatColor.RESET;

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
		ONLYNEW = getConfig().getBoolean("Only Teleport If New Player");
        Server server = getServer();
        ConsoleCommandSender console = server.getConsoleSender();

        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");
        console.sendMessage(ChatColor.AQUA + getDescription().getName());
        console.sendMessage(ChatColor.AQUA + "Version " + getDescription().getVersion());
        if (getDescription().getVersion().contains("SNAPSHOT")) {
            SNAPSHOT = true;
            console.sendMessage(ChatColor.RED + "You are running a snapshot build of " + getDescription().getName() + " please report bugs!");
            console.sendMessage(ChatColor.RED + "NO support will be given if running old snapshot build!");
        }
        console.sendMessage("");
        console.sendMessage(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        console.sendMessage("");

        registerCommands(console);
        registerEvents(console);
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    private void registerEvents(ConsoleCommandSender console) {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoin(), this);
        console.sendMessage(Prefix + "Events have been registered");
    }

    private void registerCommands(ConsoleCommandSender console) {
        getCommand("addspawn").setExecutor(new AddSpawnCommand());
        getCommand("delspawn").setExecutor(new DelSpawnCommand());
        getCommand("multispawns").setExecutor(new MultiSpawnsCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
        console.sendMessage(Prefix + "Commands have been registered");
    }
}
