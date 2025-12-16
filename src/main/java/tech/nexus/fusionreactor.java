package tech.nexus.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FusionReactor extends AGenerator implements EnergyNetComponent {
    
    public FusionReactor(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
    
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.MAGMA_BLOCK);
    }
    
    @Override
    public ItemStack getFuelIcon() {
        return new ItemStack(Material.NETHER_STAR);
    }
    
    @Override
    protected void registerDefaultFuelTypes() {
        registerFuel(new MachineFuel(2000, new ItemStack(Material.NETHER_STAR)));
    }
    
    @Override
    public int getEnergyProduction() {
        return 32768;
    }
    
    @Override
    public int getCapacity() {
        return 1000000;
    }
    
    @Override
    public String getMachineIdentifier() {
        return "FUSION_REACTOR";
    }
    
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.GENERATOR;
    }
}
