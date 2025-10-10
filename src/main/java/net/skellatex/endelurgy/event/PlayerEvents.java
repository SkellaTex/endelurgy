package net.skellatex.endelurgy.event;

import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skellatex.endelurgy.Endelurgy;
import net.skellatex.endelurgy.misc.ETags;
import net.skellatex.endelurgy.misc.NoxrockCloud;

@Mod.EventBusSubscriber(modid = Endelurgy.MOD_ID)
public class PlayerEvents {

    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        if (event.getState().is(ETags.Blocks.CREATES_NOXROCK_CLOUD)) {
            NoxrockCloud.create(event.getPos(), event.getPlayer().level(), 5F, 0.02F, 140);
        }
    }

}