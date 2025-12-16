package tech.nexus.utils;

import org.bukkit.inventory.ItemStack;
import java.util.Arrays;

public class RecipeUtils {
    
    public static boolean hasMaterials(ItemStack[] inventory, ItemStack[] recipe) {
        return Arrays.equals(inventory, recipe);
    }
    
    public static ItemStack[] createRecipe(ItemStack... items) {
        return items;
    }
}
