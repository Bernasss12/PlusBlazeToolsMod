package com.bernasss12.pbtmod.particles;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Bernasss12 on 12/5/2016.
 */
public class TextureStitcher
{
    @SubscribeEvent
    public void stitcherEventPre(TextureStitchEvent.Pre event) {
        ResourceLocation flameRL = new ResourceLocation("pbtmod:entity/flame_fx");
        event.getMap().registerSprite(flameRL);
    }
}
