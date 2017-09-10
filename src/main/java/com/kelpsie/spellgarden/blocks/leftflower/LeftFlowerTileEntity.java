package com.kelpsie.spellgarden.blocks.leftflower;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;

public class LeftFlowerTileEntity extends FlowerTileEntity {
    @Override
    public void handleRecievedMana() {

        for (ManaPacket mana : this.awaitingPool) {
            this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction-1, 1) );
        }

        awaitingPool.clear();
    }
}
