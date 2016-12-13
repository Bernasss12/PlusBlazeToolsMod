package com.bernasss12.pbtmod.tab;

import com.bernasss12.pbtmod.item.ModItem;
import com.bernasss12.pbtmod.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class CreativeTabGeneral extends CreativeTabs{
    public CreativeTabGeneral(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        ItemStack item = new ItemStack(ModItems.blazedDiamond);
        return item;
    }
}
