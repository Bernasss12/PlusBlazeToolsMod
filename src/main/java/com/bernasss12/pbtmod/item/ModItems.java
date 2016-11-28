package com.bernasss12.pbtmod.item;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Bernasss12 on 11/26/2016.
 */

public class ModItems {

    /** Creating variables to all items. */
    /** Items */
    public static ModItem blazedIron;
    public static ModItem blazedGold;
    public static ModItem blazedDiamond;
    public static ModItem blazedEmerald;

    /** Weapons */
    public static ModSword bironSword;
    public static ModSword bgoldSword;
    public static ModSword bdiamondSword;

    /** Tools */
    public static ModPickaxe bironPickaxe;
    public static ModPickaxe bgoldPickaxe;
    public static ModPickaxe bdiamondPickaxe;


    public static void preInit(){

        /** Initalizing all items. */

        /** Weapons */
        blazedIron = new ModItem("blazed_iron");
        blazedGold = new ModItem("blazed_gold");
        blazedDiamond = new ModItem("blazed_diamond");
        blazedEmerald = new ModItem("blazed_emerald");

        /** Weapons */
        bironSword = new ModSword(EnumHelper.addToolMaterial("blazedIronMaterial", 3, 500, 7.0F, 4.0F, 0), "blazed_iron_sword", 2, -1.0F);
        bgoldSword = new ModSword(EnumHelper.addToolMaterial("blazedGoldMaterial", 3, 100, 15.0F, 2.0F, 0), "blazed_gold_sword", 2, 0.0F);
        bdiamondSword = new ModSword(EnumHelper.addToolMaterial("blazedDiamondMaterial", 3, 3000, 10.0F, 6.0F, 0), "blazed_diamond_sword", 3, 1.0F);


        /** Tools */
        bironPickaxe = new ModPickaxe(EnumHelper.addToolMaterial("blazedIronMaterial", 3, 500, 7.0F,4.0F,0), "blazed_iron_pickaxe");
        bgoldPickaxe = new ModPickaxe(EnumHelper.addToolMaterial("blazedGoldMaterial", 3, 100, 15.0F, 2.0F, 0), "blazed_gold_pickaxe");
        bdiamondPickaxe = new ModPickaxe(EnumHelper.addToolMaterial("blazedDiamondMaterial", 3, 3000, 10.0F, 6.0F, 0), "blazed_diamond_pickaxe");

        /** Running the registry constructor. */
        registerItems();
    }

    public static void registerRenderer(){

        /** Registering item renders. */
        /** Items */
        registerRenders(blazedIron);
        registerRenders(blazedGold);
        registerRenders(blazedDiamond);
        registerRenders(blazedEmerald);

        /** Weapons */
        registerRenders(bironSword);
        registerRenders(bgoldSword);
        registerRenders(bdiamondSword);

        /** Tools */
        registerRenders(bironPickaxe);
        registerRenders(bgoldPickaxe);
        registerRenders(bdiamondPickaxe);

    }

    public static void registerItems(){

        /** Registering the items. */

        /** Items */
        GameRegistry.register(blazedIron, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_iron"));
        GameRegistry.register(blazedGold, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_gold"));
        GameRegistry.register(blazedDiamond, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_diamond"));
        GameRegistry.register(blazedEmerald, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_emerald"));

        /** Weapons */
        GameRegistry.register(bironSword, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_iron_sword"));
        GameRegistry.register(bgoldSword, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_gold_sword"));
        GameRegistry.register(bdiamondSword, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_diamond_sword"));

        /** Tools */
        GameRegistry.register(bironPickaxe, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_iron_pickaxe"));
        GameRegistry.register(bgoldPickaxe, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_gold_pickaxe"));
        GameRegistry.register(bdiamondPickaxe, new ResourceLocation(PlusBlazeToolsMain.MODID, "blazed_diamond_pickaxe"));

    }

    public static void registerRenders(Item item){

        /** Model registry constructor for easy use. */
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(PlusBlazeToolsMain.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }
}
