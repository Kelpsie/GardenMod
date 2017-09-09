package com.kelpsie.spellgarden.proxy;

import com.kelpsie.spellgarden.ManaParticle;
import com.kelpsie.spellgarden.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels();
    }

    @Override
    public void generateManaParticle(World world, BlockPos from, boolean parRed, boolean parGreen, boolean parBlue, int movX, int movZ, int distance) {
        double motionX =  movX*.2; //theEntity.worldObj.rand.nextGaussian() * 0.02D;
        double motionY =  0D; //theEntity.worldObj.rand.nextGaussian() * 0.02D;
        double motionZ =  movZ*.2; //theEntity.worldObj.rand.nextGaussian() * 0.02D;

        double parX = from.getX() + .5D;
        double parY = from.getY() + 1.5D;
        double parZ = from.getZ() + .5D;

        Particle particleMysterious = new ManaParticle(
                world,
                parX,
                parY,
                parZ,
                motionX,
                motionY,
                motionZ,
                parRed, parGreen, parBlue);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);


    }

}
