package com.minegusta.serverjoinmessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onJoin(PlayerJoinEvent e)
    {
        e.setJoinMessage(ChatColor.valueOf(this.getConfig().getString("name-color", "GRAY")) + e.getPlayer().getName() + " " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("join-message", "joined the game.")));
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onLeave(PlayerQuitEvent e)
    {
        e.setQuitMessage(ChatColor.valueOf(this.getConfig().getString("name-color", "GRAY")) + e.getPlayer().getName() +" " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("leave-message", "left the game.")));
    }
}
