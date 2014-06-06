package mc.Mitchellbrine.necromancy.core.handler;

import mc.Mitchellbrine.necromancy.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class CraftingHandler {

    public static void init() {
        CraftingManager.getInstance().addShapelessRecipe(new ItemStack(ModItems.necromancerContract,1), ModItems.necromancerContract, Items.feather);
    }


}
