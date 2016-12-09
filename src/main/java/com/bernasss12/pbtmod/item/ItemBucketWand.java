package com.bernasss12.pbtmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

/**
 * Created by Bernardo on 08/12/2016.
 */
public class ItemBucketWand extends ItemTool{
    public ItemBucketWand(float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
        setMaxDamage(16);
        isDamageable(false);

    }

    @Override
    public Item setMaxStackSize(int maxStackSize) {
        return super.setMaxStackSize(maxStackSize);
    }

    @Override
    public Item setMaxDamage(int maxDamageIn) {
        return super.setMaxDamage(maxDamageIn);
    }

    @Override
    public boolean isDamageable() {
        return super.isDamageable();
    }
}
