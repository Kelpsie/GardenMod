package com.kelpsie.spellgarden;

import com.kelpsie.spellgarden.blocks.inputflower.InputFlower;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("spellgarden:inputflower")
    public static InputFlower inputFlower;



    @SideOnly(Side.CLIENT)
    public static void initModels() {
        inputFlower.initModel();
    }
}
