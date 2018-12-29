package com.manish.dinesh.projecthomeatomation.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.manish.dinesh.projecthomeatomation.R;
import com.manish.dinesh.projecthomeatomation.RestServices.HttpRequestUserLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBackButton, mLoginButton, mGoogleLoginButton, mFacebookLoginButton ;
    private EditText editText_mail, editText_pwd;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getting instance of irebase Auth
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait!");
        progressDialog.setMessage("Verifying your details..");

        dialog = new Dialog(this);
        dialog.setTitle("Login Falied !");
        dialog.setCancelable(true);

        mBackButton = (Button) findViewById(R.id.button_Back);
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mGoogleLoginButton = (Button) findViewById(R.id.btn_google_login);
        mFacebookLoginButton = (Button) findViewById(R.id.btn_faceboo_login);
        editText_mail = (EditText) findViewById(R.id.editText_email);
        editText_pwd = (EditText) findViewById(R.id.editText_password);

        mBackButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mGoogleLoginButton.setOnClickListener(this);
        mFacebookLoginButton.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
       // FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    @Override
    public void onClick(View view) {
        if( view.getId() == R.id.button_Back) {
            finish();
        }else if(view.getId() == R.id.btn_login) {
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(editText_mail.getText().toString(), editText_pwd.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                i.putExtra("user_id",""+user.getUid().toString());
                                progressDialog.dismiss();
                                startActivity(i);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                dialog.show();
                                //updateUI(null);
                            }
                            // ...
                        }
                    });
        }
    }
}
