package mc.Mitchellbrine.necromancy.tileentity;

import mc.Mitchellbrine.necromancy.block.ModBlocks;
import mc.Mitchellbrine.necromancy.util.ObjectRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAlter extends TileEntityBase {

    private boolean complete = false;
    private String alterType;
    private int power;
    private int maxPower = 1000;

    public TileEntityAlter() {
        super(ModBlocks.alter);
        alterType = "";
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("power",this.power);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt != null) {
            if (nbt.hasKey("power")) {
                this.power = nbt.getInteger("power");
            }
            else {
                this.power = 0;
            }
        }
        else {
            nbt = new NBTTagCompound();
        }
    }

    @Override
    public void updateEntity() {
        if (worldObj.getBlock(xCoord,yCoord-1,zCoord) == Blocks.obsidian && worldObj.getBlock(xCoord + 1,yCoord-1,zCoord) == Blocks.obsidian && worldObj.getBlock(xCoord - 1,yCoord-1,zCoord) == Blocks.obsidian && worldObj.getBlock(xCoord,yCoord-1,zCoord + 1) == Blocks.obsidian && worldObj.getBlock(xCoord,yCoord-1,zCoord - 1) == Blocks.obsidian && worldObj.getBlock(xCoord + 1,yCoord-1,zCoord + 1) == Blocks.obsidian && worldObj.getBlock(xCoord + 1,yCoord-1,zCoord - 1) == Blocks.obsidian && worldObj.getBlock(xCoord - 1,yCoord-1,zCoord + 1) == Blocks.obsidian && worldObj.getBlock(xCoord - 1,yCoord-1,zCoord - 1) == Blocks.obsidian) {
            complete = true;
        }
        else {
            complete = false;
        }
    }

    public boolean getStatus() {
        return this.complete;
    }

    public int addPower(int power) {
        if ((this.power + power) >= this.maxPower) {
            this.power = maxPower;
        }
        else {
            this.power += power;
        }
        return this.power;
    }

    public int removePower(int power) {
        if ((this.power - power) <= 0) {
            this.power = 0;
        }
        else {
            this.power -= power;
        }
        return this.power;
    }

    public int setPower(int power) {
        if (this.power >= this.maxPower) {
            this.power = this.maxPower;
        }
        else {
            this.power = power;
        }
        return this.power;
    }

    public int getPower() {
        return this.power;
    }

    public int getMaxPower() {
        return this.maxPower;
    }


}
