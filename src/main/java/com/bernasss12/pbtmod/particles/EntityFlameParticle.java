package com.bernasss12.pbtmod.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Bernardo on 05/12/2016.
 */

public class EntityFlameParticle extends Particle {
    private final ResourceLocation flameRL = new ResourceLocation("pbtmod:entity/flame_fx");
    private int CURRENT_AGE;

    public EntityFlameParticle(World world, double x, double y, double z, double speedX, double speedY, double speedZ, int ticks) {
        super(world, x, y, z, speedX, speedY, speedZ);

        //this.setAge(ticks);

        particleMaxAge = ticks;
        final float alpha = 0.99F;
        this.particleAlpha = alpha;

        motionX = speedX;
        motionY = speedY;
        motionZ = speedZ;

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(flameRL.toString());
        setParticleTexture(sprite);
    }



    @Override
    public int getFXLayer()
    {
        return 1;
    }

    @Override
    public int getBrightnessForRender(float partialTick)
    {
        final int FULL_BRIGHTNESS_VALUE = 0xf000f0;
        return FULL_BRIGHTNESS_VALUE;
    }

    public void onUpdate()
    {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;

        this.CURRENT_AGE++;

        move(motionX, motionY, motionZ);

        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }

    public void setAge(int age){
        if(CURRENT_AGE >= age){
            this.setExpired();
        }
    }

    @Override
    public void renderParticle(VertexBuffer vertexBuffer, Entity entity, float partialTick,
                               float edgeLRdirectionX, float edgeUDdirectionY, float edgeLRdirectionZ,
                               float edgeUDdirectionX, float edgeUDdirectionZ)
    {
        double minU = this.particleTexture.getMinU();
        double maxU = this.particleTexture.getMaxU();
        double minV = this.particleTexture.getMinV();
        double maxV = this.particleTexture.getMaxV();

        double scale = 0.1F * this.particleScale;  // vanilla scaling factor
        final double scaleLR = scale;
        final double scaleUD = scale;
        double x = this.prevPosX + (this.posX - this.prevPosX) * partialTick - interpPosX;
        double y = this.prevPosY + (this.posY - this.prevPosY) * partialTick - interpPosY;
        double z = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTick - interpPosZ;

        int combinedBrightness = this.getBrightnessForRender(partialTick);
        int skyLightTimes16 = combinedBrightness >> 16 & 65535;
        int blockLightTimes16 = combinedBrightness & 65535;

        vertexBuffer.pos(x - edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
                y - edgeUDdirectionY * scaleUD,
                z - edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
                .tex(maxU, maxV)
                .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(x - edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
                y + edgeUDdirectionY * scaleUD,
                z - edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
                .tex(maxU, minV)
                .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(x + edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
                y + edgeUDdirectionY * scaleUD,
                z + edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
                .tex(minU, minV)
                .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(x + edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
                y - edgeUDdirectionY * scaleUD,
                z + edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
                .tex(minU, maxV)
                .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();

    }
}