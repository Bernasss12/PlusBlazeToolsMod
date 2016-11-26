package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Bernasss12 on 11/26/2016.
 */

public class ModItems {

    /** Creating variables to all items. */
    public static ModItem blazedIron;

    public static void preInit(){
        blazedIron = new ModItem("blazed_iron");

        registerItems();
    }

    public static void registerItems(){
        GameRegistry.register(blazedIron, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_iron"));
    }

    public static void registerRenderer(){
        registerRenders(blazedIron);
    }

    public static void registerRenders(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(PlusBlazeToolsMain.MODID + ":" + item.getUnlocalizedName().substring(5)));
    }
}
