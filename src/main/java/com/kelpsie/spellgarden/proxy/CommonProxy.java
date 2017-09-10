package com.kelpsie.spellgarden.proxy;

import com.kelpsie.spellgarden.Config;
import com.kelpsie.spellgarden.ModBlocks;
import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;
import com.kelpsie.spellgarden.blocks.backflower.BackFlower;
import com.kelpsie.spellgarden.blocks.backflower.BackFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.inputflower.InputFlower;
import com.kelpsie.spellgarden.blocks.inputflower.InputFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.jumpflower.JumpFlower;
import com.kelpsie.spellgarden.blocks.jumpflower.JumpFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.leftflower.LeftFlower;
import com.kelpsie.spellgarden.blocks.leftflower.LeftFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.rightflower.RightFlower;
import com.kelpsie.spellgarden.blocks.rightflower.RightFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.tflower.TFlower;
import com.kelpsie.spellgarden.blocks.tflower.TFlowerTileEntity;
import com.kelpsie.spellgarden.blocks.throughflower.ThroughFlower;
import com.kelpsie.spellgarden.blocks.throughflower.ThroughFlowerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "spellgarden.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(new InputFlower());
        GameRegistry.registerTileEntity(InputFlowerTileEntity.class, SpellGarden.MODID + "_inputflower");

        event.getRegistry().register(new TFlower());
        GameRegistry.registerTileEntity(TFlowerTileEntity.class, SpellGarden.MODID + "_tflower");

        event.getRegistry().register(new ThroughFlower());
        GameRegistry.registerTileEntity(ThroughFlowerTileEntity.class, SpellGarden.MODID + "_throughflower");

        event.getRegistry().register(new LeftFlower());
        GameRegistry.registerTileEntity(LeftFlowerTileEntity.class, SpellGarden.MODID + "_leftflower");

        event.getRegistry().register(new RightFlower());
        GameRegistry.registerTileEntity(RightFlowerTileEntity.class, SpellGarden.MODID + "_rightflower");

        event.getRegistry().register(new JumpFlower());
        GameRegistry.registerTileEntity(JumpFlowerTileEntity.class, SpellGarden.MODID + "_jumpflower");

        event.getRegistry().register(new BackFlower());
        GameRegistry.registerTileEntity(BackFlowerTileEntity.class, SpellGarden.MODID + "_backflower");



    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.inputFlower).setRegistryName(ModBlocks.inputFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.tFlower).setRegistryName(ModBlocks.tFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.throughFlower).setRegistryName(ModBlocks.throughFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.leftFlower).setRegistryName(ModBlocks.leftFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.rightFlower).setRegistryName(ModBlocks.rightFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.jumpFlower).setRegistryName(ModBlocks.jumpFlower.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.backFlower).setRegistryName(ModBlocks.backFlower.getRegistryName()));

    }

    public void generateManaParticle(World world, BlockPos from, boolean parRed, boolean parGreen, boolean parBlue, int movX, int movZ, int distance) { }
}