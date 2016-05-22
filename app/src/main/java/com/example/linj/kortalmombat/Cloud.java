package com.example.linj.kortalmombat;

import com.firebase.client.Firebase;

/**
 * Created by jason on 5/21/2016.
 */
public class Cloud {
    private static Firebase ref = new Firebase("https://popping-inferno-491.firebaseio.com/");


    public void fighterUpload(Fighter fighter){
        Firebase fighterStorage = ref.child(fighter.getTitle()).child(fighter.getPassword());
        fighterStorage.setValue(fighter);
    }
    public Fighter getFighter(String a, String b){
        return ref.child(a).child(b);
    }
}
