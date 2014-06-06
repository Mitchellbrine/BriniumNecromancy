package mc.Mitchellbrine.necromancy.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBase extends TileEntity {

    private Block teBlock;

    public TileEntityBase(Block teBlock) {
        this.teBlock = teBlock;
    }

    public Block getTeBlock() {
        return this.teBlock;
    }

    public TileEntityBase setTeBlock(Block teBlock) {
        this.teBlock = teBlock;
        return this;
    }


}
