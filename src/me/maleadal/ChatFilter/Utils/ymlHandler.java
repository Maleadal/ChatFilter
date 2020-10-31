package me.maleadal.ChatFilter.Utils;

import me.maleadal.ChatFilter.ChatFilter;

public class ymlHandler {
    public static void init(){
        ChatFilter.getInstance().saveDefaultConfig();
    }

}
