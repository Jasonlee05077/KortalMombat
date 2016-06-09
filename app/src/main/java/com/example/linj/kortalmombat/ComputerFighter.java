package com.example.linj.kortalmombat;

/**
 * Created by jason on 5/23/2016.
 */
public class ComputerFighter {
    private static Fighter fighter = new Fighter(0,0,0,"random","nothing");

    public static Fighter getFighter() {
        return fighter;
    }

    public static void assignAtt(int value){
        fighter.setAttack(value);
    }
    public static void assignDef(int value){
        fighter.setAttack(value);
    }
    public static void assignSpec(int value){
        fighter.setAttack(value);
    }
    public static void assignTitle(String name){
        fighter.setTitle(name);
    }
    public static void assignPassword(String password){
        fighter.setPassword(password);
    }

    public static void setFighter(Fighter fighter) {
        ComputerFighter.fighter = fighter;
    }

    public static void attackPlusOne(){
        fighter.gainAttackByOne();
    }
    public static void defensePlusOne(){
        fighter.gainDefenseByOne();
    }
    public static void specialPlusOne(){
        fighter.gainSpecialByOne();
    }



}
