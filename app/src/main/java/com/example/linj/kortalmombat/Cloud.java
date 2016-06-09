package com.example.linj.kortalmombat;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

/**
 * Created by jason on 5/21/2016.
 */
public class Cloud {
    private static Firebase ref = new Firebase("https://popping-inferno-491.firebaseio.com/");
    private static int special;
    private static int attack;
    private static int defense;
    private static int uniqueID;


    public static void fighterUpload(Fighter fighter){
        Firebase fighterStorage = ref.child(fighter.getTitle()).child(fighter.getPassword());
        fighterStorage.child("special").setValue(fighter.getSpecial());
        fighterStorage.child("attack").setValue(fighter.getAttack());
        fighterStorage.child("defense").setValue(fighter.getDefense());


    }
    public static Fighter getFighter(final String title, final String password){
        ref.addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot snapshot) {

                Fighter pulledFighter = snapshot.child(title).child(password).getValue(Fighter.class);

                int special = pulledFighter.getSpecial();
                int attack = pulledFighter.getAttack();
                int defense = pulledFighter.getDefense();


            }


            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Fighter fighter = new Fighter(special ,defense, attack , title,  password);
        return  fighter;
    }
    public static Fighter getRandom(){
        Random rand = new Random();
        int random = rand.nextInt(FighterNamesPassword.namesAndPasswords.size()-1);
        String randomNamePassword = FighterNamesPassword.namesAndPasswords.get(random);
        Fighter fighter = getFighter(randomNamePassword.substring(0, randomNamePassword.indexOf(" ")), randomNamePassword.substring(randomNamePassword.indexOf(" ")+1)
        );
        return fighter;

    }
}
