package com.example.linj.kortalmombat;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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
        fighterStorage.child("uniqueID").setValue(fighter.getUniqueID());

    }
    public static Fighter getFighter(final String title, final String password){
        ref.addValueEventListener(new ValueEventListener() {

            public void onDataChange(DataSnapshot snapshot) {

               special = (int) snapshot.child(title).child(password).child("special").getValue();
                attack = (int) snapshot.child(title).child(password).child("attack").getValue();
                defense = (int) snapshot.child(title).child(password).child("defense").getValue();
               uniqueID = (int) snapshot.child(title).child(password).child("uniqueID").getValue();

            }


            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Fighter fighter = new Fighter(special ,defense, attack , title, uniqueID, password);
        return  fighter;
    }
}