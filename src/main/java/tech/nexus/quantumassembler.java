package tech.nexus.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class QuantumAssembler extends AContainer implements EnergyNetComponent {
    
    public QuantumAssembler(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
    
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.ENDER_EYE);
    }
    
    @Override
    public int getEnergyConsumption() {
        return 4096;
    }
    
    @Override
    public int getSpeed() {
        return 1;
    }
    
    @Override
    public int getCapacity() {
        return 131072;
    }
    
    @Override
    public String getMachineIdentifier() {
        return "QUANTUM_ASSEMBLER";
    }
    
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }
}
