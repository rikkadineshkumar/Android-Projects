package com.manish.dinesh.projecthomeatomation.FirebaseServices;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;
import com.manish.dinesh.projecthomeatomation.R;


/**
 * Created by R Dinesh Kumar on 26-9-17.
 */

public class GetArduinoByUid {
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;
    public Arduino arduino;
    public boolean flag = false;

    public GetArduinoByUid(String uid) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRef = database.getReference().child("arduino").child(uid);
    }

    public void run() {
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arduino = dataSnapshot.getValue(Arduino.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        flag = true ;
    }

}
