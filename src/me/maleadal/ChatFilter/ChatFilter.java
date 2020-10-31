package me.maleadal.ChatFilter;

import me.maleadal.ChatFilter.Commands.Commands;
import me.maleadal.ChatFilter.Events.EventManager;
import me.maleadal.ChatFilter.Utils.ymlHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFilter extends JavaPlugin{
    private static ChatFilter plugin;

    @Override
    public void onEnable(){
        plugin = this;
        Commands command = new Commands();
        EventManager event = new EventManager();
        ymlHandler.init();
        getCommand("filter").setExecutor(command);
        getServer().getPluginManager().registerEvents(event, this);
        getServer().getConsoleSender().sendMessage("[ChatFilter]: Enabled");
    }
    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage("[ChatFilter]: Disabled");
    }

    public static ChatFilter getInstance(){
        return plugin;
    }



}
