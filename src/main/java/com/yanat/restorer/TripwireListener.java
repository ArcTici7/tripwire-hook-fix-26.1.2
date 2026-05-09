package com.yanat.restorer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TripwireHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TripwireListener implements Listener {

    private final JavaPlugin plugin;

    public TripwireListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onTripwireBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        
        if (block.getType() == Material.TRIPWIRE_HOOK) {
            TripwireHook hookData = (TripwireHook) block.getBlockData();
            
            // Only trigger if it's the "attached" state used in duping
            if (hookData.isAttached()) {
                // We use a 1-tick delay to bypass Paper's anti-dupe cancellation
                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    block.getWorld().dropItemNaturally(
                        block.getLocation(), 
                        new ItemStack(Material.TRIPWIRE_HOOK, 1)
                    );
                }, 1L); // 1L = 1 Tick delay
            }
        }
    }
}
