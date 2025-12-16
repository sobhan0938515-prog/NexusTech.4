package tech.nexus.machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class AutoCrafter extends AContainer implements EnergyNetComponent {
    
    private static final int[] INPUT_SLOTS = {10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25};
    private static final int[] OUTPUT_SLOTS = {31, 32, 33, 40, 41, 42};
    private static final int STATUS_SLOT = 49;
    
    public AutoCrafter(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }
    
    @Override
    public void preRegister() {
        new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                drawBackground();
                constructMenu(this);
            }
            
            @Override
            public void newInstance(BlockMenu menu, Block b) {
                updateStatus(menu, "§a§lREADY");
            }
            
            @Override
            public boolean canOpen(Block b, org.bukkit.entity.Player p) {
                return p.hasPermission("nexustech.use");
            }
        };
    }
    
    private void drawBackground() {
        for (int i = 0; i < 54; i++) {
            if (i < 9 || i > 44 || i % 9 == 0 || i % 9 == 8) {
                BlockMenuPreset.getPreset(getId()).addItem(i, 
                    new CustomItemStack(Material.RED_STAINED_GLASS_PANE, " "),
                    (p, s, item, action) -> false);
            }
        }
    }
    
    private void constructMenu(BlockMenuPreset preset) {
        for (int slot : INPUT_SLOTS) {
            preset.addItem(slot, new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, "§9Input Slot"),
                (player, i, item, action) -> true);
        }
        
        for (int slot : OUTPUT_SLOTS) {
            preset.addItem(slot, new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "§aOutput Slot"),
                (player, i, item, action) -> true);
        }
        
        preset.addItem(4, new CustomItemStack(Material.CRAFTING_TABLE,
            "§c§lAUTO-CRAFTER MK.II",
            "§7Automatically crafts items",
            "",
            "§f⚡ Power: §c" + getEnergyConsumption() + " J/t",
            "§f⚡ Capacity: §c" + getCapacity() + " J",
            "§fSpeed: §c" + (21 - getSpeed()) + " ticks",
            "",
            "§7Place ingredients in blue slots"
        ), (player, slot, item, action) -> false);
    }
    
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }
    
    @Override
    public int getEnergyConsumption() {
        return 512;
    }
    
    @Override
    public int getSpeed() {
        return 1;
    }
    
    @Override
    public int getCapacity() {
        return 16384;
    }
    
    @Override
    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);
        if (menu == null) return;
        
        if (getCharge(b.getLocation()) < getEnergyConsumption()) {
            return;
        }
        
        MachineRecipe recipe = findCraftableRecipe(menu);
        if (recipe != null && menu.fits(recipe.getOutput()[0], OUTPUT_SLOTS)) {
            removeCharge(b.getLocation(), getEnergyConsumption());
            
            for (ItemStack input : recipe.getInput()) {
                if (input != null) {
                    menu.consumeItem(input);
                }
            }
            
            menu.pushItem(recipe.getOutput()[0].clone(), OUTPUT_SLOTS);
        }
    }
    
    private MachineRecipe findCraftableRecipe(BlockMenu menu) {
        for (SlimefunItem item : Slimefun.getRegistry().getAllSlimefunItems()) {
            if (item != null && item.getRecipe() != null && item.getRecipe().length > 0) {
                ItemStack[] inputs = item.getRecipe();
                if (hasIngredients(menu, inputs)) {
                    return new MachineRecipe(getSpeed() * 20, inputs, new ItemStack[]{item.getItem()});
                }
            }
        }
        return null;
    }
    
    private boolean hasIngredients(BlockMenu menu, ItemStack[] required) {
        Map<Material, Integer> needed = new HashMap<>();
        for (ItemStack req : required) {
            if (req != null) {
                needed.put(req.getType(), needed.getOrDefault(req.getType(), 0) + req.getAmount());
            }
        }
        
        Map<Material, Integer> available = new HashMap<>();
        for (int slot : INPUT_SLOTS) {
            ItemStack item = menu.getItemInSlot(slot);
            if (item != null) {
                available.put(item.getType(), available.getOrDefault(item.getType(), 0) + item.getAmount());
            }
        }
        
        for (Map.Entry<Material, Integer> entry : needed.entrySet()) {
            if (available.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public String getMachineIdentifier() {
        return "AUTO_CRAFTER_MK2";
    }
    
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }
              }
