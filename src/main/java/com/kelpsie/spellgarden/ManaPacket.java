package com.kelpsie.spellgarden;

public class ManaPacket {
    public boolean Red;
    public boolean Green;
    public boolean Blue;
    public int Direction;
    public int Distance = 1;
    public int Ticks;

    public ManaPacket(boolean Red, boolean Green, boolean Blue, int Ticks, int Direction) {
        this.Red = Red;
        this.Green = Green;
        this.Blue = Blue;
        this.Direction = Direction;
        this.Ticks = Ticks;
    }

    public ManaPacket(boolean Red, boolean Green, boolean Blue, int Ticks, int Direction, int Distance) {
        this(Red, Green, Blue, Ticks, Direction);
        this.Distance = Distance;
    }
}
