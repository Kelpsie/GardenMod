package com.kelpsie.spellgarden.blocks.tflower;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;

public class TFlowerTileEntity extends FlowerTileEntity{

    @Override
    public void handleRecievedMana() {
        SpellGarden.logger.debug("Input flower is doing a thing!");

        if (awaitingPool.size() <= 1)
            for (ManaPacket mana : this.awaitingPool) {
                this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction+1, 1) );
                this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction-1, 1) );
            }

        awaitingPool.clear();
    }
}
