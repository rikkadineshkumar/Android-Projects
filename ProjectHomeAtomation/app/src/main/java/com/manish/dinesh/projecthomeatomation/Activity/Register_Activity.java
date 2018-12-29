 package com.manish.dinesh.projecthomeatomation.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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
import com.manish.dinesh.projecthomeatomation.Models.Arduino;
import com.manish.dinesh.projecthomeatomation.Models.Device;
import com.manish.dinesh.projecthomeatomation.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 public class Register_Activity extends AppCompatActivity implements View.OnClickListener {

     private Button mReegisterButton, mBackButton;
     private TextView mMailTextView, mPassowrdTextView, mRePassowrdTextView;
     private FirebaseAuth mAuth;
     private DatabaseReference dbRef;
     private ProgressDialog mProgressDialog;
     private Dialog mDialog, mDialog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Registering User Details");
        mProgressDialog.setTitle("Please wait ..!");

        mDialog = new Dialog(this);
        mDialog.setTitle("Registration sucess!");
        mDialog.setCancelable(true);

        mDialog2 = new Dialog(this);
        mDialog2.setTitle("Registration Failed!");
        mDialog2.setCancelable(true);

        mBackButton = (Button) findViewById(R.id.btn_back_2);
        mReegisterButton = (Button) findViewById(R.id.button_register);

        mMailTextView = (TextView) findViewById(R.id.editText_mail_2);
        mPassowrdTextView = (TextView) findViewById(R.id.editText_password_2);
        mRePassowrdTextView = (TextView) findViewById(R.id.editText_repassword);

        mBackButton.setOnClickListener(this);
        mReegisterButton.setOnClickListener(this);
    }

     @Override
     public void onClick(View view) {
         if(view.getId() == R.id.btn_back_2){
             finish();
         }else if(view.getId() == R.id.button_register){
             mProgressDialog.show();
             if(mPassowrdTextView.getText().toString().equals(mRePassowrdTextView.getText().toString())) {
                 mAuth.createUserWithEmailAndPassword(mMailTextView.getText().toString(), mPassowrdTextView.getText().toString())
                         .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()) {
                                     // Sign in success, update UI with the signed-in user's information
                                     //Log.d(TAG, "createUserWithEmail:success");
                                     dbRef.child("arduino_count").addListenerForSingleValueEvent(new ValueEventListener() {
                                         @Override
                                         public void onDataChange(DataSnapshot dataSnapshot) {
                                             FirebaseUser user = mAuth.getCurrentUser();
                                             //ArrayList<Device> deviceArrayList = new ArrayList<>();
                                             //Device d = new Device(1, "led", false, 0, 1,"extra det", "detail");
                                             //deviceArrayList.add(d);
                                             //List<Device> devices = deviceArrayList;
                                             //List<Device> devices = new ArrayList<Device>(Arrays.asList())
                                             //devices.add(d);
                                             Arduino a = new Arduino((Integer.parseInt(dataSnapshot.getValue().toString())+1),Collections.<Device>emptyList());
                                             dbRef.child("arduino_count").setValue(Integer.parseInt(dataSnapshot.getValue().toString())+1);
                                             dbRef.child("arduino").child(user.getUid()).setValue(a);
                                             mProgressDialog.dismiss();
                                             mDialog.show();
                                         }
                                         @Override
                                         public void onCancelled(DatabaseError databaseError) {
                                             Toast.makeText(Register_Activity.this, "Registration canceled by User", Toast.LENGTH_SHORT).show();
                                         }
                                     });
                                     //updateUI(user);
                                 }else{
                                     // If sign in fails, display a message to the user.
                                     //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                     Toast.makeText(getApplicationContext(),"Authentication failed.",Toast.LENGTH_SHORT).show();
                                     mProgressDialog.dismiss();
                                     mDialog2.show();
                                     //updateUI(null);
                                 }
                             }
                         });
             }
             else{
                 mRePassowrdTextView.setError("ReEntered password don't matching");
             }
         }
     }
 }
