package com.kelpsie.spellgarden;


import com.kelpsie.spellgarden.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SpellGarden.MODID, version = SpellGarden.VERSION, name = SpellGarden.NAME, useMetadata = true)
public class SpellGarden {
    public static final String MODID = "spellgarden";
    public static final String VERSION = "0.17.9.7";
    public static final String NAME = "Spell Garden";



    @SidedProxy(clientSide = "com.kelpsie.spellgarden.proxy.ClientProxy", serverSide = "com.kelpsie.spellgarden.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static SpellGarden instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
