package com.example.linj.kortalmombat;

/**
 * Created by leej2 on 5/19/2016.
 */
public class Fighter {
    private int special;
    private int defense;
    private int hp = 500 + defense *30;
    private int attack;
    private String title = "";

    private String password;
    private int block_chance = 33;
    private int attack_chance = 33;
    private int special_chance = 33;



    public Fighter(int special, int defense, int attack, String title, String password) {
        this.special = special;
        this.attack = attack;
        this.defense = defense;
        this.title = title;

        this.password = password;
    }
    public Fighter(int special, int defense, int attack) {
        this.special = special;
        this.attack = attack;
        this.defense = defense;

    }


    public int getSpecial() {
        return special;
    }

    public int getAttack() {
        return attack;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public void gainAttackByOne(){
        attack++;
    }
    public void gainDefenseByOne(){
        defense++;
    }
    public void gainSpecialByOne(){
        special++;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}





