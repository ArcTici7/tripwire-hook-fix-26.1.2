package com.yanat.restorer;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TripwireHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class TripwireListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onTripwireBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        
        // Filter for Tripwire Hooks
        if (block.getType() == Material.TRIPWIRE_HOOK) {
            TripwireHook hookData = (TripwireHook) block.getBlockData();
            
            // Re-injecting the dupe: if it was 'attached' when broken, force a second drop
            if (hookData.isAttached()) {
                block.getWorld().dropItemNaturally(
                    block.getLocation(), 
                    new ItemStack(Material.TRIPWIRE_HOOK, 1)
                );
            }
        }
    }
}
