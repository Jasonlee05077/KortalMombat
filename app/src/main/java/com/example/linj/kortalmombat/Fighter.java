package com.example.linj.kortalmombat;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by leej2 on 5/19/2016.
 */
public class Fighter {
    private int special;
    private int defense;
    private int hp = defense *33;
    private int attack;
    private String title = "";
    private int uniqueID;
    private String password;
    private int block_chance = 33;
    private int attack_chance = 33;
    private int special_chance = 34;



    public Fighter(int special, int defense, int attack, String title, int uniqueID, String password) {
        this.special = special;
        this.attack = attack;
        this.defense = defense;
        this.title = title;
        this.uniqueID = uniqueID;
        this.password = password;
    }

    public int getSpecial() {
        return special;
    }

    public int getAttack() {
        return attack;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public int getDefense() {
        return defense;
    }

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public int getBlock_chance() {
            return block_chance;
        }

    public int getAttack_chance() {
            return attack_chance;
        }

    public int getSpecial_chance() {
            return special_chance;
        }

    public void Punch () {
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.icon, null);
        String uri = "@drawable/myresource";  // where myresource (without the extension) is the file


    }
}




