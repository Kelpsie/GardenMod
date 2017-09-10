package com.kelpsie.spellgarden.blocks.jumpflower;

import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.Flower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class JumpFlower extends Flower {
    public JumpFlower() {
        super(Material.PLANTS);
        setUnlocalizedName(SpellGarden.MODID + ".jumpflower");
        setRegistryName("jumpflower");
    }


    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new JumpFlowerTileEntity();
    }

    private JumpFlowerTileEntity getTE(World world, BlockPos pos) {
        return (JumpFlowerTileEntity) world.getTileEntity(pos);
    }
}
