package com.bernasss12.pbtmod;

/**
 * Created by Bernasss12 on 11/26/2016.
 */

import com.bernasss12.pbtmod.item.ModItems;
import com.bernasss12.pbtmod.proxy.CommonProxy;
import com.bernasss12.pbtmod.tab.CreativeTabGeneral;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = PlusBlazeToolsMain.MODID, version = PlusBlazeToolsMain.VERSION, name = PlusBlazeToolsMain.NAME)
public class PlusBlazeToolsMain
{
    public static final String MODID = "pbtmod";
    public static final String VERSION = "0.1";
    public static final String NAME = "+Blaze Tools Mod";

    @SidedProxy(clientSide = "com.bernasss12.pbtmod.proxy.ClientProxy", serverSide = "com.bernasss12.pbtmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static PlusBlazeToolsMain instance;

    public static CreativeTabGeneral tabGeneral;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        tabGeneral = new CreativeTabGeneral(CreativeTabs.getNextID(), "tab_general");

        ModItems.preInit();

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
