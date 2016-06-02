package com.example.linj.kortalmombat;

/**
 * Created by jason on 5/23/2016.
 */
public class ComputerFighter {
    private static Fighter fighter;

    public static Fighter getFighter() {
        return fighter;
    }

    public static void setFighter(Fighter fighter) {
        ComputerFighter.fighter = fighter;
    }



}
