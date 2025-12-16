package tech.nexus.core.categories;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import tech.nexus.NexusTech;

public class Categories {
    
    public static ItemGroup NEXUS_CORE;
    public static ItemGroup NEXUS_MACHINES;
    public static ItemGroup NEXUS_GENERATORS;
    public static ItemGroup NEXUS_COMPONENTS;
    
    public static void setup(NexusTech plugin) {
        NEXUS_CORE = new ItemGroup(
            new NamespacedKey(plugin, "nexus_core"),
            new CustomItemStack(Material.REDSTONE_BLOCK, 
                "§c§lNEXUS-TECH", 
                "§7Industrial Technology Expansion")
        );
        
        NEXUS_MACHINES = new ItemGroup(
            new NamespacedKey(plugin, "nexus_machines"),
            new CustomItemStack(Material.CRAFTING_TABLE,
                "§c§lNEXUS MACHINES",
                "§7Advanced Industrial Machines")
        );
        
        NEXUS_GENERATORS = new ItemGroup(
            new NamespacedKey(plugin, "nexus_generators"),
            new CustomItemStack(Material.REDSTONE_TORCH,
                "§c§lNEXUS ENERGY",
                "§7Power Generation & Distribution")
        );
        
        NEXUS_COMPONENTS = new ItemGroup(
            new NamespacedKey(plugin, "nexus_components"),
            new CustomItemStack(Material.DIAMOND,
                "§c§lNEXUS COMPONENTS",
                "§7Advanced Materials & Parts")
        );
    }
}
