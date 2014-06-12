package mc.Mitchellbrine.necromancy.block;

import cpw.mods.fml.common.registry.GameRegistry;
import mc.Mitchellbrine.necromancy.NecromancyMain;
import mc.Mitchellbrine.necromancy.tileentity.TileEntityTotem;
import mc.Mitchellbrine.necromancy.util.ObjectRegistry;
import mc.Mitchellbrine.necromancy.util.References;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SacrificialTotem extends BlockContainer{

    public SacrificialTotem() {
        super(Material.rock);
        this.setBlockName("totem");
        this.setBlockTextureName(References.RESOURCEPREFIX + this.getUnlocalizedName().substring(5));
        this.setCreativeTab(NecromancyMain.getCreativeTab());
        ObjectRegistry.registerObject(this);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityTotem();
    }

    @Override
    public TileEntity createTileEntity(World var1, int var2) {
        return new TileEntityTotem();
    }
}
