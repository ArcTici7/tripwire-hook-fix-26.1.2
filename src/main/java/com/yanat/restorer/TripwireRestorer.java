package com.yanat.restorer;

import org.bukkit.plugin.java.JavaPlugin;

public class TripwireRestorer extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register the event listener so the server starts watching for tripwires
        getServer().getPluginManager().registerEvents(new TripwireListener(), this);
        getLogger().info("TripwireRestorer enabled. Legacy dupe logic injected.");
    }
}
