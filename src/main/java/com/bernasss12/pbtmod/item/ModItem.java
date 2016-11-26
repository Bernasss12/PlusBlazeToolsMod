package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.item.Item;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class ModItem extends Item {

    public ModItem(String name){
        setUnlocalizedName(name);
        setCreativeTab(PlusBlazeToolsMain.tabGeneral);
    }
}
