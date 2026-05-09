package com.yanat.restorer;

import org.bukkit.plugin.java.JavaPlugin;

public class TripwireRestorer extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TripwireListener(), this);
        getLogger().info("TripwireRestorer enabled. Legacy dupe logic is now active.");
    }
}
