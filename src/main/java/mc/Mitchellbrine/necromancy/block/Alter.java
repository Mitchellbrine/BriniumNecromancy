package mc.Mitchellbrine.necromancy.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mc.Mitchellbrine.necromancy.NecromancyMain;
import mc.Mitchellbrine.necromancy.item.ModItems;
import mc.Mitchellbrine.necromancy.tileentity.TileEntityAlter;
import mc.Mitchellbrine.necromancy.util.ObjectRegistry;
import mc.Mitchellbrine.necromancy.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class Alter extends BlockContainer {

    private IIcon topIcon;
    private IIcon bottomIcon;

    public Alter() {
        super(Material.rock);
        this.setBlockName("alter");
        this.setBlockTextureName(References.RESOURCEPREFIX + this.getUnlocalizedName().substring(5));
        this.setCreativeTab(NecromancyMain.getCreativeTab());
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        ObjectRegistry.registerObject(this);
        ObjectRegistry.registerObject(new TileEntityAlter());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityAlter();
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return new TileEntityAlter();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_" + "side");
        this.topIcon = p_149651_1_.registerIcon(this.getTextureName() + "_" + "top");
        this.bottomIcon = p_149651_1_.registerIcon(this.getTextureName() + "_" + "bottom");
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 0 ? this.bottomIcon : (p_149691_1_ == 1 ? this.topIcon : this.blockIcon);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        TileEntityAlter te = (TileEntityAlter) world.getTileEntity(x,y,z);
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == ModItems.necromancerContract) {
            player.getEntityData().setBoolean("isNecromancer", true);
            if (!world.isRemote) {
                if (te != null && te.getPower() >= 100) {
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[UNKNOWN] It is done..."));
                    player.worldObj.playSoundAtEntity(player, "ambient.weather.thunder", 1.0F, 1.0F);
                    player.addChatMessage(new ChatComponentText("You are now a necromancer. What will you use your power for?"));
                    te.removePower(100);
                }
            }
            player.getCurrentEquippedItem().stackSize--;
        }
        else if (player.getCurrentEquippedItem() == null) {
            if (te != null) {
                if (!player.isSneaking()) {
                    if (te.getPower() <= (te.getMaxPower() - 20)) {
                        if (!world.isRemote) {
                            player.attackEntityFrom(DamageSource.magic, 2.0F);
                            te.addPower(20);
                        }
                    }
                }
                else {
                    if (!world.isRemote) {
                        player.addChatMessage(new ChatComponentText("Power: " + te.getPower()));
                    }
                }
            }
        }
            return true;
    }

}
