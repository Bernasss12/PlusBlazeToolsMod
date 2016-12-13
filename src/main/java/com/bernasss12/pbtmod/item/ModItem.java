package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class ModItem extends Item {

    public ModItem(String name){
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick( World worldIn, EntityPlayer playerIn, EnumHand hand) {
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public EnumActionResult onItemUse( EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onItemUse( playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }


}
