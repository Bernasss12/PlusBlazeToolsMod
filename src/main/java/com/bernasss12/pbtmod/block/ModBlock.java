package com.bernasss12.pbtmod.block;

import com.bernasss12.pbtmod.PlusBlazeToolsMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public int getMetaFromState(IBlockState state)
    {
        return (state.getValue(FACING)).getHorizontalIndex();
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
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
