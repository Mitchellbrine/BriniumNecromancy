package mc.Mitchellbrine.necromancy.entity.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class NecromancyPlayer implements IExtendedEntityProperties{

    public final static String EXT_PROP_NAME = "NecromancyProperty";

    private final EntityPlayer player;


    private boolean isNecromancer;


    public NecromancyPlayer(EntityPlayer player) {
        this.player = player;
    }


    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties(NecromancyPlayer.EXT_PROP_NAME, new NecromancyPlayer(player));
    }


    public static final NecromancyPlayer get(EntityPlayer player) {
        return (NecromancyPlayer) player.getExtendedProperties(EXT_PROP_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();

        properties.setBoolean("isNecromancer",isNecromancer);
        compound.setTag(EXT_PROP_NAME, properties);
    }

    // Load whatever data you saved
    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        this.isNecromancer = properties.getBoolean("isNecromancer");
    }

    @Override
    public void init(Entity entity, World world) {

    }

}
