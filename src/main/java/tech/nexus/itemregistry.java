package tech.nexus.core.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import tech.nexus.NexusTech;
import tech.nexus.core.items.stacks.TechItems;
import tech.nexus.machines.AutoCrafter;

public class ItemRegistry {
    
    public static void registerItems(NexusTech plugin) {
        ItemGroup nexusGroup = plugin.getNexusCategory();
        
        // Auto-Crafter
        new AutoCrafter(nexusGroup, TechItems.AUTO_CRAFTER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.CRAFTING_TABLE), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.CRAFTING_TABLE),
                SlimefunItems.CARBONADO, new ItemStack(Material.REDSTONE_BLOCK), SlimefunItems.CARBONADO,
                SlimefunItems.HEATED_PRESSURE_CHAMBER, SlimefunItems.CIRCUIT_BOARD, SlimefunItems.HEATED_PRESSURE_CHAMBER
            }).register(plugin);
        
        // Core Components
        new SlimefunItem(nexusGroup, TechItems.NEXUS_CORE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.CARBONADO, SlimefunItems.ENERGIZED_CAPACITOR, SlimefunItems.CARBONADO,
                SlimefunItems.PLASTIC_SHEET, new ItemStack(Material.NETHER_STAR), SlimefunItems.PLASTIC_SHEET,
                SlimefunItems.STEEL_PLATE, SlimefunItems.CIRCUIT_BOARD, SlimefunItems.STEEL_PLATE
            }).register(plugin);
        
        // Quantum Chip
        new SlimefunItem(nexusGroup, TechItems.QUANTUM_CHIP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.SILICON, SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.SILICON,
                SlimefunItems.GOLD_24K, new ItemStack(Material.ENDER_EYE), SlimefunItems.GOLD_24K,
                SlimefunItems.URANIUM, SlimefunItems.CIRCUIT_BOARD, SlimefunItems.URANIUM
            }).register(plugin);
        
        // Nano Mesh
        new SlimefunItem(nexusGroup, TechItems.NANO_MESH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.CARBON, SlimefunItems.CARBON, SlimefunItems.CARBON,
                SlimefunItems.PLASTIC_SHEET, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.PLASTIC_SHEET,
                SlimefunItems.CARBON, SlimefunItems.CARBON, SlimefunItems.CARBON
            }).register(plugin);
        
        // Refined Iron
        new SlimefunItem(nexusGroup, TechItems.REFINED_IRON,
            RecipeType.SMELTERY,
            new ItemStack[]{
                new ItemStack(Material.IRON_INGOT, 4),
                new ItemStack(Material.COAL, 2)
            }).register(plugin);
    }
}
