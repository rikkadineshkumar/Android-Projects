package com.manish.dinesh.projecthomeatomation.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manish.dinesh.projecthomeatomation.FirebaseServices.AddDeviceByUid;
import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;
import com.manish.dinesh.projecthomeatomation.R;
import com.manish.dinesh.projecthomeatomation.RestServices.HttpRequestAddDevice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by R Dinesh Kumar on 26-9-17.
 */

public class AddDeviceDialog extends Dialog {

    public Device device = new Device();
    String uid;
    Arduino arduino;
    boolean flag = false;

    public AddDeviceDialog(@NonNull Context context , String uid) {
        super(context);
        this.uid = uid;
    }

    public void showDialog(final Activity activity){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.add_device_dialog_layout);

        final EditText edittext = dialog.findViewById(R.id.device_name_dialog);
        //final EditText editText_deviceDetail = dialog.findViewById(R.id.device_detail_dialog);
        final TextView spinnerItem = findViewById(R.id.spinner_item_textview);
        final Spinner spinner = dialog.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(activity,R.array.device_types,R.layout.text_view_layout);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                device.setDetails(spinner.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinnerItem.setBackgroundColor(Color.RED);
            }
        });

        Button dialogAddButton = dialog.findViewById(R.id.add_device_button_dialog);
        dialogAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG.setAction("Action", null).show();*//*
                device.setName(edittext.getText().toString());
                device.setOnORoff(false);
                if(device.getDetails().equals("Ceiling Fan")){
                    device.setExtraData("0");
                }
                /*HttpRequestAddDevice httpRequestPostPost = new HttpRequestAddDevice();
                httpRequestPostPost.device = device;
                httpRequestPostPost.execute();*/

                /*AddDeviceByUid addDeviceByUid = new AddDeviceByUid(device,uid);
                addDeviceByUid.run();
                while(!addDeviceByUid.flag);*/

                final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("arduino").child(uid);
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Arduino arduino = dataSnapshot.getValue(Arduino.class);

                        List<Device> devices = Collections.emptyList();
                        ArrayList<Device> deviceArrayList = new ArrayList<>(arduino.getDevices());
                        //devices = arduino.getDevices();if(deviceArrayList.size()== -1){
                        device.setDid(deviceArrayList.size());
                        Toast.makeText(activity, "device array list size is ="+deviceArrayList.size(), Toast.LENGTH_LONG).show();
                        deviceArrayList.add(device);
                        devices = deviceArrayList;

                        arduino.setDevices(devices);

                        dbRef.setValue(arduino);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //while(!httpRequestPostPost.request_status);
                dialog.dismiss();
            }
        });

        Button dialogCancelButton = dialog.findViewById(R.id.cancel_add_device_button_dialog);
        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
