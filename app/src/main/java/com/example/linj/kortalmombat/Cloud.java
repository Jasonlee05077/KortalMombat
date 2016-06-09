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
    public static int attack;
    public static int special;
    public static int defense;
    public static int uniqueID;


    public static void fighterUpload(Fighter fighter){
        Firebase fighterStorage = ref.child(fighter.getTitle()).child(fighter.getPassword());
        fighterStorage.child("special").setValue(fighter.getSpecial());
        fighterStorage.child("attack").setValue(fighter.getAttack());
        fighterStorage.child("defense").setValue(fighter.getDefense());




    }
    public static void getYourStats(final String title, final String password){

        ref.addValueEventListener(new ValueEventListener() {


            public void onDataChange(DataSnapshot snapshot) {

                YourFighter.special = (snapshot.child(title).child(password).child("special").getValue(Integer.TYPE).intValue());
                YourFighter.defense=(snapshot.child(title).child(password).child("defense").getValue(Integer.TYPE).intValue());
                YourFighter.attack = (snapshot.child(title).child(password).child("attack").getValue(Integer.TYPE).intValue());
            }


            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    public static void getTheirStats(final String title, final String password){

        ref.addValueEventListener(new ValueEventListener() {


            public void onDataChange(DataSnapshot snapshot) {

                ComputerFighter.special = (snapshot.child(title).child(password).child("special").getValue(Integer.TYPE).intValue());
                ComputerFighter.defense=(snapshot.child(title).child(password).child("defense").getValue(Integer.TYPE).intValue());
                ComputerFighter.attack = (snapshot.child(title).child(password).child("attack").getValue(Integer.TYPE).intValue());
                ComputerFighter.defensechance= (snapshot.child(title).child(password).child("block").getValue(Integer.TYPE).intValue());
                ComputerFighter.attackchance = (snapshot.child(title).child(password).child("punch").getValue(Integer.TYPE).intValue());
                ComputerFighter.specialchance = (snapshot.child(title).child(password).child("kick").getValue(Integer.TYPE).intValue());
        }


            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    public static void uploadChances(int block, int punch , int kick, String title, String password){
        Firebase fighterStorage = ref.child(title).child(password);
        fighterStorage.child("block").setValue(block);
        fighterStorage.child("punch").setValue(punch);
        fighterStorage.child("kick").setValue(kick);
    }

}
