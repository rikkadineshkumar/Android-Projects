package com.manish.dinesh.projecthomeatomation.FirebaseServices;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;

import java.util.List;

/**
 * Created by R Dinesh Kumar on 6-1-18.
 */

public class AddDeviceByUid {
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;
    public Device device;
    private Arduino arduino;
    public boolean flag = false;

    public AddDeviceByUid(Device device, String uid) {
        this.device = device;
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("arduino").child(uid);
    }

    public void run(){
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arduino = dataSnapshot.getValue(Arduino.class);
                List<Device> devices = arduino.getDevices();
                device.setDid(devices.size()+1);
                devices.add(device);
                arduino.setDevices(devices);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        dbRef.setValue(arduino);
        flag = true ;
    }
}
