package com.yanat.restorer;

import org.bukkit.plugin.java.JavaPlugin;

public class TripwireRestorer extends JavaPlugin {
    @Override
    public void onEnable() {
        // Passing 'this' so the listener can use the Scheduler
        getServer().getPluginManager().registerEvents(new TripwireListener(this), this);
        getLogger().info("TripwireRestorer v1.1 (Delay-Bypass) active.");
    }
}
