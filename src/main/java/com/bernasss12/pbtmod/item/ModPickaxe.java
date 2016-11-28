package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;

/**
 * Created by Bernardo on 27/11/2016.
 */
public class ModPickaxe extends ItemPickaxe {
    protected ModPickaxe(ToolMaterial material, String name) {
        super(material);
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }
    /**
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!worldIn.isRemote) {
            if (worldIn.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                worldIn.destroyBlock(pos, false);
                EntityItem item = new EntityItem(worldIn, x, y, z, new ItemStack(Items.IRON_INGOT, 1));
                worldIn.spawnEntityInWorld(item);
                worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, 5));
                return true;
            }
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
    */
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!worldIn.isRemote) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                ItemStack block = new ItemStack(worldIn.getBlockState(pos).getBlock(), 1);
                int exp = (int)FurnaceRecipes.instance().getSmeltingExperience(block);
                ItemStack result = FurnaceRecipes.instance().getSmeltingResult(block);
                //worldIn.destroyBlock(pos, false);
                EntityItem item = new EntityItem(worldIn, x, y, z, result);
                worldIn.spawnEntityInWorld(item);
                for(int i = 0; i < exp; i++) {
                    worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, 1));
                }
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

}
