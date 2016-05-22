package com.example.linj.kortalmombat;

/**
 * Created by leej2 on 5/19/2016.
 */
public class Fighter {
    private int special;
    private int defense;
    private int hp = defense *30;
    private int attack;
    private String title = "";
    private int uniqueID;
    private String password;
    private int block_chance;
    private int attack_chance;
    private int special_chance;

    public int getDefense() {
        return defense;
    }

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

    }




