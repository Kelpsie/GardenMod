package com.kelpsie.spellgarden;


import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleBlockDust;
import net.minecraft.client.particle.ParticleSmokeNormal;
import net.minecraft.world.World;

public class ManaParticle extends Particle
{
    public ManaParticle(World parWorld,
                                      double parX, double parY, double parZ,
                                      double parMotionX, double parMotionY, double parMotionZ, boolean parRed, boolean parGreen, boolean parBlue)
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setParticleTextureIndex(0);
        particleScale = 2.0F;
        //setRBGColorF(parRed, parGreen, parBlue);
        if (parRed) particleRed = 1;
        else particleRed = -1;
        if (parGreen) particleGreen = 1;
        else particleGreen = -1;
        if (parBlue) particleBlue = 1;
        else particleBlue = -1;
        particleScale = 5f;
        motionX = parMotionX;
        motionY = parMotionY;
        motionZ = parMotionZ;
        particleGravity = 1f;
        //setSize(50f, 50f);
        setMaxAge(4);
    }
}
