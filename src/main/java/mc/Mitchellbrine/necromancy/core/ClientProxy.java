package mc.Mitchellbrine.necromancy.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import mc.Mitchellbrine.necromancy.client.render.RenderTotem;
import mc.Mitchellbrine.necromancy.tileentity.TileEntityTotem;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenderStuff(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTotem.class,new RenderTotem());
    }


}
