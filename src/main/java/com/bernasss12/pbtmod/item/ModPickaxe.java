package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

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

    /*@Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        Random r = new Random();
        int i = r.nextInt(10);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if(!worldIn.isRemote) {
            if (worldIn.getBlockState(pos).getBlock() == (Blocks.IRON_ORE)) {
                if (i == 5) {
                    EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.IRON_INGOT, 1));
                    worldIn.destroyBlock(pos, false);
                    worldIn.spawnEntityInWorld(item);
                    for(int j = 0; j > 5; j++) {
                        worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + ((double) i * 0.1D), (double) y + ((double) i * 0.1D), (double) z + ((double) i * 0.1D), 0.01D, 0.01D, 0.01D);
                    }
                    worldIn.playSound((double) x, (double) y, (double) z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 3.0F + r.nextFloat(), 1.0F, true);
                }
            } else if (worldIn.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
                if (i == 5) {
                    EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.GOLD_INGOT, 1));
                    worldIn.spawnEntityInWorld(item);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + ((double) i * 0.1D), (double) y + ((double) i * 0.1D), (double) z + ((double) i * 0.1D), 0.01D, 0.01D, 0.01D);
                    worldIn.playSound((double) x, (double) y, (double) z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 1.0F + r.nextFloat(), 1.0F, true);
                }
            }
        }
        return true;
    }*/

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Random r = new Random();
        int i = r.nextInt(10);
        double d = r.nextDouble();
        int x = pos.getX();
        int y = pos.getY() + 1;
        int z = pos.getZ();
        double speed = 0.04D;
        worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 0.0D, (double) y + 0.0D, (double) z + 0.0D , MathHelper.sin(0.5F), speed, speed);
        worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 0.0D, (double) y + 0.0D, (double) z + 1.0D , speed*(10/20), speed*(10/20), -speed*(10/20));
        
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 1.0D, (double) y + 0.0D, (double) z + 0.0D , -speed, speed, speed);
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 1.0D, (double) y + 0.0D, (double) z + 1.0D , -speed, speed, -speed);
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 0.0D, (double) y + 1.0D, (double) z + 0.0D , speed, -speed, speed);
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 0.0D, (double) y + 1.0D, (double) z + 1.0D , speed, -speed, -speed);
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 1.0D, (double) y + 1.0D, (double) z + 0.0D , -speed, -speed, speed);
        //worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D , -speed, -speed, -speed);
        return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
