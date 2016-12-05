package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.bernasss12.pbtmod.particles.EntityFlameParticle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/**
 * Created by Bernardo on 27/11/2016.
 */
public class ModPickaxe extends ItemPickaxe {
    protected ModPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Random r = new Random();
        int i = r.nextInt(10);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (worldIn.getBlockState(pos).getBlock() == (Blocks.IRON_ORE)) {
            if (i == 5) {
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.IRON_INGOT, 1));
                dropItems(worldIn, pos, item);
                smeltAnimation(worldIn, pos);
                worldIn.playSound((double) x, (double) y, (double) z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 3.0F + r.nextFloat(), 1.0F, true);
            }
        } else if (worldIn.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
            if (i == 5) {
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.GOLD_INGOT, 1));
                dropItems(worldIn, pos, item);
                smeltAnimation(worldIn, pos);
                worldIn.playSound((double) x, (double) y, (double) z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 3.0F + r.nextFloat(), 1.0F, true);
            }
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public static void smeltAnimation(World worldIn, BlockPos pos) {
        Vec3d fireballDirection = new Vec3d(0.5, 0.5, 0.5);

        int x = pos.getX();
        int y = pos.getY() + 1;
        int z = pos.getZ();

        final double SPEED_IN_BLOCKS_PER_SECOND = 2.0;
        final double TICKS_PER_SECOND = 20;
        final double SPEED_IN_BLOCKS_PER_TICK = SPEED_IN_BLOCKS_PER_SECOND / TICKS_PER_SECOND;

        double speedX = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.xCoord;
        double speedY = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.yCoord;
        double speedZ = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.zCoord;

        EntityFlameParticle newEffect0 = new EntityFlameParticle(worldIn, x + 0, y + 0, z + 0, speedX, speedY, speedZ);
        EntityFlameParticle newEffect1 = new EntityFlameParticle(worldIn, x + 0, y + 0, z + 1, speedX, speedY, -speedZ);
        EntityFlameParticle newEffect2 = new EntityFlameParticle(worldIn, x + 0, y + 1, z + 0, speedX, -speedY, speedZ);
        EntityFlameParticle newEffect3 = new EntityFlameParticle(worldIn, x + 0, y + 1, z + 1, speedX, -speedY, -speedZ);
        EntityFlameParticle newEffect4 = new EntityFlameParticle(worldIn, x + 1, y + 0, z + 0, -speedX, speedY, speedZ);
        EntityFlameParticle newEffect5 = new EntityFlameParticle(worldIn, x + 1, y + 0, z + 1, -speedX, speedY, -speedZ);
        EntityFlameParticle newEffect6 = new EntityFlameParticle(worldIn, x + 1, y + 1, z + 0, -speedX, -speedY, speedZ);
        EntityFlameParticle newEffect7 = new EntityFlameParticle(worldIn, x + 1, y + 1, z + 1, -speedX, -speedY, -speedZ);


        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect0);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect1);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect2);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect3);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect4);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect5);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect6);
        Minecraft.getMinecraft().effectRenderer.addEffect(newEffect7);

    }

    @SideOnly(Side.SERVER)
    public static void dropItems(World worldIn, BlockPos pos, EntityItem item){
        worldIn.destroyBlock(pos, false);
        worldIn.spawnEntityInWorld(item);
    }
}
