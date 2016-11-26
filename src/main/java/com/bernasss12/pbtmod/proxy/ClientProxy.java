package com.bernasss12.pbtmod.proxy;

import com.bernasss12.pbtmod.item.ModItem;
import com.bernasss12.pbtmod.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModItems.registerRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
