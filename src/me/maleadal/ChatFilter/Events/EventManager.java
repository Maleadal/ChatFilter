package me.maleadal.ChatFilter.Events;

import me.maleadal.ChatFilter.ChatFilter;
import me.maleadal.ChatFilter.Commands.Commands;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.List;

public class EventManager implements Listener {
    ChatFilter plugin = ChatFilter.getInstance();
    @EventHandler
    public void onChatEvent(PlayerChatEvent event){
        List<String> badWords = plugin.getConfig().getStringList("badwords");
        String[] message = event.getMessage().toLowerCase().split(" ");
        Player player = event.getPlayer();

        for(int i = 0; i < badWords.size(); i++){
            for(int j = 0; j < message.length; j++){
                if(message[j].equalsIgnoreCase(badWords.get(i)) && Commands.filterOn){
                    message[j] = new String(new char[message[j].length()]).replace("\0", "*");
                    event.setCancelled(true);
                    player.chat(String.join(" ", message));
                    player.sendMessage(plugin.getConfig().getString("ChatFilter.Messages.bad"));
                }
            }
        }

    }
}
