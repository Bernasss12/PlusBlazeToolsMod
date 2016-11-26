package com.bernasss12.pbtmod.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class CreativeTabGeneral extends CreativeTabs{
    public CreativeTabGeneral(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.DIAMOND;
    }
}
