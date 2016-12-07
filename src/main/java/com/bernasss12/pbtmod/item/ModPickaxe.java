package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.bernasss12.pbtmod.particles.EntityFlameParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Created by Bernardo on 27/11/2016.
 */
public class ModPickaxe extends ItemPickaxe {
    protected ModPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }

    private boolean success;

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();

            if (worldIn.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
                worldIn.destroyBlock(pos, false);
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.IRON_INGOT, 1));
                worldIn.spawnEntityInWorld(item);
                stack.damageItem(2, playerIn);
                worldIn.playSound(x, y, z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 1.0F, 1.0f, true);
                success = true;
                return EnumActionResult.SUCCESS;


            }else if (worldIn.getBlockState(pos).getBlock() == Blocks.GOLD_ORE){
                worldIn.destroyBlock(pos, false);
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.GOLD_INGOT, 1));
                worldIn.spawnEntityInWorld(item);
                stack.damageItem(3, playerIn);
                worldIn.playSound(x, y, z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 1.0F, 1.0f, true);
                success = true;
                return EnumActionResult.SUCCESS;
            }
            else {
                return EnumActionResult.FAIL;
            }

        }


        if (success){
        if (worldIn.isRemote) {
            Vec3d fireballDirection = new Vec3d(0.5, 0.5, 0.5);

            int x = pos.getX();
            int y = pos.getY();
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

            worldIn.playSound(x, y, z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 1.0F, 1.0f, true);
            success = false;
            }
         }
        return EnumActionResult.PASS;
    }
}
