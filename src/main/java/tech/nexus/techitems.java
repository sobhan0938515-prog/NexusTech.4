package tech.nexus.core.items.stacks;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

public class TechItems {
    
    // Core Components
    public static final SlimefunItemStack NEXUS_CORE = new SlimefunItemStack(
        "NEXUS_CORE",
        Material.REDSTONE_BLOCK,
        "§c§lNexus Core",
        "§7The heart of NEXUS-TECH"
    );
    
    public static final SlimefunItemStack QUANTUM_CHIP = new SlimefunItemStack(
        "QUANTUM_CHIP",
        Material.PRISMARINE_CRYSTALS,
        "§b§lQuantum Chip",
        "§7Advanced processing unit"
    );
    
    public static final SlimefunItemStack NANO_MESH = new SlimefunItemStack(
        "NANO_MESH",
        Material.STRING,
        "§f§lNano Mesh",
        "§7Molecular reinforcement fabric"
    );
    
    // Machines
    public static final SlimefunItemStack AUTO_CRAFTER = new SlimefunItemStack(
        "AUTO_CRAFTER_MK2",
        Material.CRAFTING_TABLE,
        "§c§lAuto-Crafter MK.II",
        "§7Automatically crafts Slimefun items"
    );
    
    // Materials
    public static final SlimefunItemStack REFINED_IRON = new SlimefunItemStack(
        "REFINED_IRON",
        Material.IRON_INGOT,
        "§f§lRefined Iron",
        "§799.99% pure iron"
    );
    
    public static final SlimefunItemStack CARBON_NANOTUBE = new SlimefunItemStack(
        "CARBON_NANOTUBE",
        Material.BLACK_DYE,
        "§8§lCarbon Nanotube",
        "§7Molecular carbon structure"
    );
    
    // Energy
    public static final SlimefunItemStack SUPERCONDUCTOR = new SlimefunItemStack(
        "SUPERCONDUCTOR",
        Material.LIGHT_BLUE_DYE,
        "§b§lSuperconductor",
        "§7Zero-resistance energy transfer"
    );
    
    public static final SlimefunItemStack ENERGY_CRYSTAL = new SlimefunItemStack(
        "ENERGY_CRYSTAL",
        Material.AMETHYST_SHARD,
        "§d§lEnergy Crystal",
        "§7Stores vast amounts of energy"
    );
}
