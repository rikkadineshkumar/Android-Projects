package com.manish.dinesh.projecthomeatomation.Fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manish.dinesh.projecthomeatomation.Adapters.DeviceAdapter;
import com.manish.dinesh.projecthomeatomation.Dialogs.AddDeviceDialog;
import com.manish.dinesh.projecthomeatomation.FirebaseServices.GetArduinoByUid;
import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;
import com.manish.dinesh.projecthomeatomation.R;
import com.manish.dinesh.projecthomeatomation.RestServices.HttpRequestArduino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by R Dinesh Kumar on 5-10-17.
 */

public class consoleFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private DeviceAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String uid;
    private Dialog dialog;

    public consoleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        uid = this.getArguments().getString("uid");
        return inflater.inflate(R.layout.fragment_console, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_Console_fragment);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        dialog = new Dialog(view.getContext());
        dialog.setTitle("Failed to connect!");
        dialog.setCancelable(true);

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                AddDeviceDialog addDeviceDialog = new AddDeviceDialog(view.getContext(),uid);
                addDeviceDialog.showDialog(getActivity());
            }
        });

        /*HttpRequestArduino httpRequestArduino = new HttpRequestArduino();
        httpRequestArduino.uid = uid;
        httpRequestArduino.execute();
        while (!httpRequestArduino.request_status);
        Arduino arduino = httpRequestArduino.arduino;*/



        /*ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Retrieving device status\n    from server   ..");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();*/

        /*GetArduinoByUid getArduinoByUid = new GetArduinoByUid(uid);
        getArduinoByUid.run();
        while(!getArduinoByUid.flag);
        Toast.makeText(getContext(), ""+getArduinoByUid.arduino.toString(), Toast.LENGTH_SHORT).show();
        //List<Device> listDevice = getArduinoByUid.arduino.getDevices();
        List<Device> listDevice2 = Collections.emptyList() ;
        //Device d = new Device(1, "led", false, 0, 1,"extra det", "detail");
        //listDevice2.add(d);*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference().child("arduino").child(uid);
        final List<Device> deviceList = Collections.emptyList();

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Arduino arduino = dataSnapshot.getValue(Arduino.class);
                //ArrayList<Device> deviceArrayList = new ArrayList<>();
                if(arduino.getDevices().isEmpty()){
                    mAdapter = new DeviceAdapter(getContext(),deviceList,uid);
                    mRecyclerView.setAdapter(mAdapter);
                }else{
                    mAdapter = new DeviceAdapter(getContext(),arduino.getDevices(),uid);
                    mRecyclerView.setAdapter(mAdapter);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                mAdapter = new DeviceAdapter(getContext(),deviceList,uid);
                mRecyclerView.setAdapter(mAdapter);
                Toast.makeText(getContext(), "Failed to connect the server.", Toast.LENGTH_SHORT).show();
                dialog.show();
            }
        });



        //progressDialog.dismiss();
    }

}
