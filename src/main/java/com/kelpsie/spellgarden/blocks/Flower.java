package com.kelpsie.spellgarden.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Flower extends Block implements ITileEntityProvider {

    public Flower(Material mat) {
        super(mat);
    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new FlowerTileEntity();
    }


}
