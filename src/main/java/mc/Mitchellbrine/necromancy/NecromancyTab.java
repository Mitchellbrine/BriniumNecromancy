package mc.Mitchellbrine.necromancy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mc.Mitchellbrine.necromancy.item.ModItems;
import mc.Mitchellbrine.necromancy.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NecromancyTab extends CreativeTabs{

    public NecromancyTab() {
        super(CreativeTabs.getNextID(),"bNecromancy");
        this.setBackgroundImageName("bItems.png");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getTabIconItem() {
        return ModItems.necromancerContract;
    }
}
