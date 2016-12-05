package com.bernasss12.pbtmod.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Bernardo on 05/12/2016.
 */

public class EntityFlameParticle extends Particle {
    private final ResourceLocation flameRL = new ResourceLocation("pbtmod:particles/flame_fx");

    public EntityFlameParticle(World world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, speedX, speedY, speedZ);

        particleMaxAge = 10;
        final float alpha = 0.99F;
        this.particleAlpha = alpha;

        motionX = speedX;
        motionY = speedY;
        motionZ = speedZ;

        //TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(flameRL.toString());
        this.setParticleTextureIndex(48);
    }
}