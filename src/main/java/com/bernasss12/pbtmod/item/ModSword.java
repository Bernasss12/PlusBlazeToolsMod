package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Bernardo on 26/11/2016.
 */

public class ModSword extends ItemSword {

    //private final float attackDamage;
    //private final float attackSpeed;
    private final int damageFS;

    public ModSword(ToolMaterial material, String name, int dmg, float atkSpeed) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
        //this.attackDamage = 6.0F + material.getDamageVsEntity();
        //this.attackSpeed = atkSpeed;
        this.damageFS = dmg;
    }

    /** Work like a flint and steel but only on obsidian and netherrack. */
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (worldIn.getBlockState(pos).getBlock() == Blocks.OBSIDIAN || worldIn.getBlockState(pos).getBlock() == Blocks.NETHERRACK) {
            pos = pos.up();
            if (worldIn.getBlockState(pos).getBlock() == Blocks.AIR){
                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
                playerIn.getActiveItemStack().damageItem(this.damageFS, playerIn);
                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.FAIL;
            }

        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

    /**
    @Override
    /** Tryng to modify oniginal ItemSwords's attackSpeed modifier. NOT WORKING *//**

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 0.1D, 0));
        }

        return multimap;
    }
    */

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        target.setFire(8);
        return super.hitEntity(stack, target, attacker);
    }
}
