package com.kelpsie.spellgarden.blocks.throughflower;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;

public class ThroughFlowerTileEntity extends FlowerTileEntity {

    @Override
    public void handleRecievedMana() {

        for (ManaPacket mana : this.awaitingPool) {
            this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction, 1) );
        }

        awaitingPool.clear();
    }
}
