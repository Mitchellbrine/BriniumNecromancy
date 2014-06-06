package mc.Mitchellbrine.necromancy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mc.Mitchellbrine.necromancy.block.ModBlocks;
import mc.Mitchellbrine.necromancy.core.ClientProxy;
import mc.Mitchellbrine.necromancy.core.CommonProxy;
import mc.Mitchellbrine.necromancy.core.handler.CraftingHandler;
import mc.Mitchellbrine.necromancy.event.ConstructingEvent;
import mc.Mitchellbrine.necromancy.event.ContractEvent;
import mc.Mitchellbrine.necromancy.item.ModItems;
import mc.Mitchellbrine.necromancy.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = References.MODID,name = References.MODNAME,version = References.VERSION)
public class NecromancyMain {

    @Mod.Instance
    public static NecromancyMain INSTANCE;

    @SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.COMMONPROXY)
    public static CommonProxy proxy;

    private static CreativeTabs necromancyTab = new NecromancyTab();

    public static CreativeTabs getCreativeTab() {
        return necromancyTab;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenderStuff();

        ModBlocks.init();
        ModItems.init();
        CraftingHandler.init();

        MinecraftForge.EVENT_BUS.register(new ConstructingEvent());
        FMLCommonHandler.instance().bus().register(new ContractEvent());

    }
}
