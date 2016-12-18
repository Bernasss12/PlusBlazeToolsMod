package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.bernasss12.pbtmod.particles.EntityFlameParticle;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.awt.*;

/**
 * Created by Bernardo on 27/11/2016.
 */
public class ModPickaxe extends ItemPickaxe {
    private Minecraft mc;
    private EntityFlameParticle ent;

    protected ModPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase playerIn) {
       if (FurnaceRecipes.instance().getSmeltingResult(new ItemStack(worldIn.getBlockState(pos).getBlock())) != ItemStack.EMPTY){
           double x = pos.getX() + 0.5;
           double y = pos.getY() + 0.5;
           double z = pos.getZ() + 0.5;

           playerIn.getActiveItemStack().damageItem(1, playerIn);

           if(!worldIn.isRemote){
               worldIn.setBlockToAir(pos);;
               ItemStack drop = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(worldIn.getBlockState(pos).getBlock()));
               EntityItem item = new EntityItem(worldIn, x, y, z, drop);
               worldIn.spawnEntity(item);
           }
       }
    /**
        if (!worldIn.isRemote){
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            if (worldIn.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
                //Blocks.IRON_ORE
                float exp = FurnaceRecipes.instance().getSmeltingExperience(new ItemStack(Items.IRON_INGOT));
                playerIn.sendMessage(new TextComponentString(Float.toString(exp)));
                worldIn.destroyBlock(pos, false);
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.IRON_INGOT, 1));
                worldIn.spawnEntity(item);
                return true;


            }else if (worldIn.getBlockState(pos).getBlock() == Blocks.GOLD_ORE){
                worldIn.destroyBlock(pos, false);
                float exp = FurnaceRecipes.instance().getSmeltingExperience(new ItemStack(Items.GOLD_INGOT));
                playerIn.sendMessage(new TextComponentString(Float.toString(exp)));
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.GOLD_INGOT, 1));
                worldIn.spawnEntity(item);
                playerIn.getActiveItemStack().damageItem(3, playerIn);
                return true;
            }
        }

        if (worldIn.isRemote) {
            final double ZER = 0.1;
            final double ONE = 0.9;

            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            final double SPEED_IN_BLOCKS_PER_SECOND = 3;
            final double TICKS_PER_SECOND = 20;
            final double SPEED_IN_BLOCKS_PER_TICK = SPEED_IN_BLOCKS_PER_SECOND / TICKS_PER_SECOND;
            final double VECTOR_SIZE = (ONE - ZER)/2;
            final int AGE = (int)((VECTOR_SIZE*2)/SPEED_IN_BLOCKS_PER_TICK) + 2;



            Vec3d fireballDirection = new Vec3d(0 + VECTOR_SIZE, 0 + VECTOR_SIZE, 0 + VECTOR_SIZE);

            double speedX = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.xCoord;
            double speedY = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.yCoord;
            double speedZ = SPEED_IN_BLOCKS_PER_TICK * fireballDirection.zCoord;

            EntityFlameParticle newEffect0 = new EntityFlameParticle(worldIn, x + ZER, y + ZER, z + ZER, speedX, speedY, speedZ, AGE);
            EntityFlameParticle newEffect1 = new EntityFlameParticle(worldIn, x + ZER, y + ZER, z + ONE, speedX, speedY, -speedZ, AGE);
            EntityFlameParticle newEffect2 = new EntityFlameParticle(worldIn, x + ZER, y + ONE, z + ZER, speedX, -speedY, speedZ, AGE);
            EntityFlameParticle newEffect3 = new EntityFlameParticle(worldIn, x + ZER, y + ONE, z + ONE, speedX, -speedY, -speedZ, AGE);
            EntityFlameParticle newEffect4 = new EntityFlameParticle(worldIn, x + ONE, y + ZER, z + ZER, -speedX, speedY, speedZ, AGE);
            EntityFlameParticle newEffect5 = new EntityFlameParticle(worldIn, x + ONE, y + ZER, z + ONE, -speedX, speedY, -speedZ, AGE);
            EntityFlameParticle newEffect6 = new EntityFlameParticle(worldIn, x + ONE, y + ONE, z + ZER, -speedX, -speedY, speedZ, AGE);
            EntityFlameParticle newEffect7 = new EntityFlameParticle(worldIn, x + ONE, y + ONE, z + ONE, -speedX, -speedY, -speedZ, AGE);


            mc.getMinecraft().effectRenderer.addEffect(newEffect0);
            mc.getMinecraft().effectRenderer.addEffect(newEffect1);
            mc.getMinecraft().effectRenderer.addEffect(newEffect2);
            mc.getMinecraft().effectRenderer.addEffect(newEffect3);
            mc.getMinecraft().effectRenderer.addEffect(newEffect4);
            mc.getMinecraft().effectRenderer.addEffect(newEffect5);
            mc.getMinecraft().effectRenderer.addEffect(newEffect6);
            mc.getMinecraft().effectRenderer.addEffect(newEffect7);

            double x1 = x + 0.5;
            double y1 = y + 0.5;
            double z1 = z + 0.5;

            worldIn.playSound(x1, y1, z1, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 0.5F, 1.0f, true);
        }
    */

        return true;
    }
}
