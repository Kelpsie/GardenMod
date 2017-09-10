package com.kelpsie.spellgarden.blocks;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.SpellGarden;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import scala.Console;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FlowerTileEntity extends TileEntity implements ITickable {

    private int counter = 0;

    public ArrayList<ManaPacket> awaitingPool = new ArrayList<ManaPacket>();
    public ArrayList<ManaPacket> sendingPool = new ArrayList<ManaPacket>();

    public int decrement() {
        counter--;
        markDirty();
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }

    public void recieveMana(ManaPacket m) {
        awaitingPool.add(new ManaPacket(
                m.Red, m.Green, m.Blue, m.Ticks-1, m.Direction, m.Distance
        ));
    }

    @Override
    public void update() {
        if ((getWorld().getTotalWorldTime()+1) % 5 == 0) {
            handleRecievedMana();
        }
        if (getWorld().getTotalWorldTime() % 5 == 0)
            sendMana();

    }

    public void handleRecievedMana() { }

    public void sendMana() {
        BlockPos pos = getPos();

        for (ManaPacket mana : sendingPool) {
            if (mana.Ticks < 1) continue;
            BlockPos to = pos.up();
            int x = 0;
            int z = 0;
            mana.Direction = Math.floorMod(mana.Direction, 4);
            switch (mana.Direction) {
                case 0: to = pos.north(mana.Distance);
                        x = 0; z = -1;
                        break;
                case 1: to = pos.east(mana.Distance);
                    x = 1; z = 0;
                    break;
                case 2: to = pos.south(mana.Distance);
                    x = 0; z = 1;
                    break;
                case 3: to = pos.west(mana.Distance);
                    x = -1; z = 0;
                    break;
            }
            if (  getWorld().getBlockState(to).getBlock() instanceof  Flower ) {
                SpellGarden.proxy.generateManaParticle(world, pos.up(), mana.Red, mana.Green, mana.Blue, x, z, 1);
                FlowerTileEntity f = (FlowerTileEntity)getWorld().getTileEntity(to);
                f.recieveMana(mana);
            }
        }

        sendingPool.clear();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }

}
