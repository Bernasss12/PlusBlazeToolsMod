package com.bernasss12.pbtmod.proxy;

import com.bernasss12.pbtmod.util.Config;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event){
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "modtut.cfg"));
        Config.checkConfig();

    }

    public void init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event){
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }
}
