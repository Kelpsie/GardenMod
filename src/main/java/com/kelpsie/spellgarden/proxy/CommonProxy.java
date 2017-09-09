package com.kelpsie.spellgarden.proxy;

import com.kelpsie.spellgarden.Config;
import com.kelpsie.spellgarden.ModBlocks;
import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;
import com.kelpsie.spellgarden.blocks.inputflower.InputFlower;
import com.kelpsie.spellgarden.blocks.inputflower.InputFlowerTileEntity;
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
        //GameRegistry.registerTileEntity(FlowerTileEntity.class, SpellGarden.MODID + "_inputflower");
        GameRegistry.registerTileEntity(InputFlowerTileEntity.class, SpellGarden.MODID + "_inputflower");

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.inputFlower).setRegistryName(ModBlocks.inputFlower.getRegistryName()));

    }

    public void generateManaParticle(World world, BlockPos from, boolean parRed, boolean parGreen, boolean parBlue, int movX, int movZ, int distance) { }
}