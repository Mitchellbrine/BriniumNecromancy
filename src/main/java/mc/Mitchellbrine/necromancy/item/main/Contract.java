package mc.Mitchellbrine.necromancy.item.main;

import mc.Mitchellbrine.necromancy.NecromancyMain;
import mc.Mitchellbrine.necromancy.util.ObjectRegistry;
import mc.Mitchellbrine.necromancy.util.References;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class Contract extends Item {

    private int progress = 0;

    public Contract() {
        this.setMaxStackSize(1);
        this.setUnlocalizedName("contract");
        this.setTextureName(References.RESOURCEPREFIX + this.getUnlocalizedName().substring(5));
        this.setCreativeTab(NecromancyMain.getCreativeTab());
        ObjectRegistry.registerObject(this);
    }

/*    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (stack.stackTagCompound == null) {
            if (progress == 0) {
                if (!world.isRemote) {
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[UNKNOWN] Do you really want to become a necromancer?"));
                    progress++;
                }
            } else if (progress == 1) {
                stack.stackTagCompound = new NBTTagCompound();
                stack.stackTagCompound.setString("binded", player.getCommandSenderName());
                if (!world.isRemote) {
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "[UNKNOWN] It is done..."));
                    world.playSoundAtEntity(player, "ambient.weather.thunder", 1.0F, 1.0F);
                    player.getEntityData().setBoolean("isNecromancer",true);
                    player.addChatMessage(new ChatComponentText("You are now a necromancer. What will you use your power for?"));
                    progress = 0;
                }
                return true;
            }
        }
        return false;
    }*/

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lore, boolean par4)
    {
        if (stack.stackTagCompound != null)
        {
            String owner = stack.stackTagCompound.getString("binded");
            if (owner != null && owner != "") {
                lore.add("This contract of necromancy is signed by " + owner);
            }
        }
    }

}
