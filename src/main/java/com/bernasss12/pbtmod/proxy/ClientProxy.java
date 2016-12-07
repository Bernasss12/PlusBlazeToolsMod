package com.bernasss12.pbtmod.proxy;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import com.bernasss12.pbtmod.item.ModItem;
import com.bernasss12.pbtmod.item.ModItems;
import com.bernasss12.pbtmod.particles.TextureStitcher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Bernasss12 on 11/26/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
      MinecraftForge.EVENT_BUS.register(new TextureStitcher());

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModItems.registerRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(PlusBlazeToolsMain.MODID + ":" + id, "inventory"));
    }
}
