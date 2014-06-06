package mc.Mitchellbrine.necromancy.util;

import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.necromancy.tileentity.TileEntityBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class ObjectRegistry {

    public static void registerObject(Object par1) {
        if (par1 instanceof Item) {
                GameRegistry.registerItem((Item) par1, ((Item) par1).getUnlocalizedName().substring(5));

        }
        else if (par1 instanceof Block) {
                GameRegistry.registerBlock((Block) par1, ((Block) par1).getUnlocalizedName().substring(5));
        }
        else if (par1 instanceof TileEntityBase) {
            TileEntityBase te = (TileEntityBase)par1;
                if (te.getTeBlock() != null) {
                    GameRegistry.registerTileEntity(te.getClass(), te.getTeBlock().getUnlocalizedName().substring(5));
                }
                else {
                    GameRegistry.registerTileEntity(te.getClass(), "null");
                }
        }
    }

}
