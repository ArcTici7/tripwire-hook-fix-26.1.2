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
        
        if (block.getType() == Material.TRIPWIRE_HOOK) {
            TripwireHook hookData = (TripwireHook) block.getBlockData();
            
            // Checks if the hook was attached to a block when broken
            if (hookData.isAttached()) {
                // Spawns the duplicate hook entity directly at the block location
                block.getWorld().dropItemNaturally(
                    block.getLocation(), 
                    new ItemStack(Material.TRIPWIRE_HOOK, 1)
                );
            }
        }
    }
}
