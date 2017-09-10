package com.kelpsie.spellgarden;

import com.kelpsie.spellgarden.blocks.backflower.BackFlower;
import com.kelpsie.spellgarden.blocks.inputflower.InputFlower;
import com.kelpsie.spellgarden.blocks.jumpflower.JumpFlower;
import com.kelpsie.spellgarden.blocks.leftflower.LeftFlower;
import com.kelpsie.spellgarden.blocks.rightflower.RightFlower;
import com.kelpsie.spellgarden.blocks.tflower.TFlower;
import com.kelpsie.spellgarden.blocks.throughflower.ThroughFlower;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("spellgarden:inputflower")
    public static InputFlower inputFlower;

    @GameRegistry.ObjectHolder("spellgarden:tflower")
    public static TFlower tFlower;

    @GameRegistry.ObjectHolder("spellgarden:throughflower")
    public static ThroughFlower throughFlower;

    @GameRegistry.ObjectHolder("spellgarden:leftflower")
    public static LeftFlower leftFlower;

    @GameRegistry.ObjectHolder("spellgarden:rightflower")
    public static RightFlower rightFlower;

    @GameRegistry.ObjectHolder("spellgarden:jumpflower")
    public static JumpFlower jumpFlower;

    @GameRegistry.ObjectHolder("spellgarden:backflower")
    public static BackFlower backFlower;



    @SideOnly(Side.CLIENT)
    public static void initModels() {
        inputFlower.initModel();
        tFlower.initModel();
        throughFlower.initModel();
        leftFlower.initModel();
        rightFlower.initModel();
        jumpFlower.initModel();
        backFlower.initModel();
    }
}
