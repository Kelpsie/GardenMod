package com.kelpsie.spellgarden.blocks.jumpflower;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;

public class JumpFlowerTileEntity extends FlowerTileEntity {

    @Override
    public void handleRecievedMana() {

        for (ManaPacket mana : this.awaitingPool) {
            this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction, 2) );
        }

        awaitingPool.clear();
    }
}
