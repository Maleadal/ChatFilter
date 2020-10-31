package me.maleadal.ChatFilter.Commands;

import me.maleadal.ChatFilter.ChatFilter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public static boolean filterOn = false;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("filter")){
                if(args.length > 0){
                    if(args[0].equalsIgnoreCase("on")){
                        if(filterOn){
                            player.sendMessage(ChatFilter.getInstance().getConfig().getString("ChatFilter.Messages.Commands.FailFilterOn"));
                            return true;
                        }else {
                            player.sendMessage(ChatFilter.getInstance().getConfig().getString("ChatFilter.Messages.Commands.FilterOn"));
                            filterOn = true;
                        }
                    }else if(args[0].equalsIgnoreCase("off")){
                        if(!filterOn){
                            player.sendMessage(ChatFilter.getInstance().getConfig().getString("ChatFilter.Messages.Commands.FailFilterOff"));
                            return true;
                        }else{
                            player.sendMessage(ChatFilter.getInstance().getConfig().getString("ChatFilter.Messages.Commands.FilterOff"));
                            filterOn = false;
                        }

                    }
                }else{
                    player.sendMessage(ChatFilter.getInstance().getConfig().getString("ChatFilter.Messages.Commands.Usage"));
                }
            }
        }
        return true;
    }
}
