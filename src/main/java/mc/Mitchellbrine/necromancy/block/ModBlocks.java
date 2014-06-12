package mc.Mitchellbrine.necromancy.block;

import mc.Mitchellbrine.necromancy.tileentity.TileEntityTotem;
import mc.Mitchellbrine.necromancy.util.ObjectRegistry;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block alter;
    public static Block totem;

    public static void init() {
        alter = new Alter();
        totem = new SacrificialTotem();

        ObjectRegistry.registerObject(new TileEntityTotem());

    }
}
