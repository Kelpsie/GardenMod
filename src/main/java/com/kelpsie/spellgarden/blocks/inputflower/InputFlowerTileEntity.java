package com.kelpsie.spellgarden.blocks.inputflower;

import com.kelpsie.spellgarden.ManaPacket;
import com.kelpsie.spellgarden.SpellGarden;
import com.kelpsie.spellgarden.blocks.FlowerTileEntity;

public class InputFlowerTileEntity extends FlowerTileEntity {

    @Override
    public void handleRecievedMana() {
        SpellGarden.logger.debug("Input flower is doing a thing!");

        for (ManaPacket mana : this.awaitingPool) {
            this.sendingPool.add(new ManaPacket (mana.Red, mana.Green, mana.Blue, mana.Ticks, mana.Direction, mana.Distance) );
        }

        awaitingPool.clear();
    }
}