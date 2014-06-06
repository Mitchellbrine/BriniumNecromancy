package mc.Mitchellbrine.necromancy.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mc.Mitchellbrine.necromancy.entity.player.NecromancyPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class ConstructingEvent {

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event)
    {
        if (event.entity instanceof EntityPlayer && NecromancyPlayer.get((EntityPlayer) event.entity) == null)
            NecromancyPlayer.register((EntityPlayer) event.entity);

        if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(NecromancyPlayer.EXT_PROP_NAME) == null)
            event.entity.registerExtendedProperties(NecromancyPlayer.EXT_PROP_NAME, new NecromancyPlayer((EntityPlayer) event.entity));
    }

}
