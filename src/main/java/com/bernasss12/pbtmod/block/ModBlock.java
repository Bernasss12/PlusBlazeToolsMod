package com.bernasss12.pbtmod.block;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;

/**
 * Created by Bernardo on 30/11/2016.
 */
public class ModBlock extends Block
{
    protected String name;

    public ModBlock(Material material, String unlocalizedName, String textureName) {
        super(material);

        this.name = textureName;

        setUnlocalizedName(unlocalizedName);
        setRegistryName(name);
    }

    public void registerItemModel(ItemBlock itemBlock) {
        PlusBlazeToolsMain.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    @Override
    public ModBlock setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public ModBlock setLightOpacity(int opacity) {
        super.setLightOpacity(opacity);
        return this;
    }

    @Override
    public ModBlock setLightLevel(float value) {
        super.setLightLevel(value);
        return this;
    }

    @Override
    public ModBlock setResistance(float resistance) {
        super.setResistance(resistance);
        return this;
    }

}
