package com.bernasss12.pbtmod.block;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Bernardo on 06/12/2016.
 */
public class ModBlocks {

    /** Creating variable to every block. */
    public static ModBlock blazedIronBlock;
    public static ModBlock blazedGoldBlock;
    public static ModBlock blazedDiamondBlock;
    public static ModBlock blazedEmeraldBlock;

    public static void preInit(){

        /** Registering every block. */
        blazedIronBlock = register(new ModBlock(Material.IRON, "blazedIronBlock").setCreativeTab(PlusBlazeToolsMain.tabGeneral).setLightLevel(3.75F));
        blazedGoldBlock = register(new ModBlock(Material.IRON, "blazedGoldBlock").setCreativeTab(PlusBlazeToolsMain.tabGeneral).setLightLevel(7.5F));
        blazedDiamondBlock = register(new ModBlock(Material.IRON, "blazedDiamondBlock").setCreativeTab(PlusBlazeToolsMain.tabGeneral).setLightLevel(11.25F));
        blazedEmeraldBlock = register(new ModBlock(Material.IRON, "blazedEmeraldBlock").setCreativeTab(PlusBlazeToolsMain.tabGeneral).setLightLevel(15F));

    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof ModBlock) {
            ((ModBlock)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }

}
