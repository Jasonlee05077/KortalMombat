package com.example.linj.kortalmombat;

/**
 * Created by leej2 on 5/19/2016.
 */
public class Fighter {
    private int special;
    private int defense;
    private int attack;
    private String title = "";
    private int uniqueID;
    private String password;

    public Fighter(int special, int defense, int attack, String title, int uniqueID, String password){
        this.special= special;
        this.attack = attack;
        this.defense = defense;
        this.title = title;
        this.uniqueID = uniqueID;
        this.password = password;

    }



}
