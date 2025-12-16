package tech.nexus;

import org.bukkit.plugin.java.JavaPlugin;

public class NexusTech extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("§c⚡ NEXUS-TECH §fenabled!");
        getLogger().info("§7Industrial Expansion v1.0.0");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("NEXUS-TECH shutting down...");
    }
}
