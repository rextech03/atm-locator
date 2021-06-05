package com.example.afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button mLogin, mRegistration;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
        public  void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null ){
            Intent intent = new Intent(AdminLoginActivity.this, AdminChat.class);
            startActivity(intent);
            finish();
            return;
        }
    }
 };

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        mLogin = (Button) findViewById(R.id.login);
        mRegistration = (Button) findViewById(R.id.registration);

        mRegistration.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final String email = mEmail.getText().toString();
                 final String password = mPassword.getText().toString();
                 mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(AdminLoginActivity.this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (!task.isSuccessful()) {
                             Toast.makeText(AdminLoginActivity.this, "Sign Up Error", Toast.LENGTH_SHORT);
                         } else {
                             String user_id = mAuth.getCurrentUser().getUid();
                             DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Admin").child(user_id);
                             current_user_db.setValue(true);
                         }
                     }
                 });
             }


         });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(AdminLoginActivity.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                 if (!task.isSuccessful()){
                     Toast.makeText(AdminLoginActivity.this, "Sign In Error", Toast.LENGTH_SHORT);
                        } else {
                     String user_id = mAuth.getCurrentUser().getUid();
                     DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Admin").child(user_id);
                     current_user_db.setValue(true);
                    }
                }
                });
            };
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}