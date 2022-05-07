package com.example.adif_lacoviedo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //Componentes del layout
    private Button btLogin,btRegister;
    private EditText etPassword,etEmail;

    //Firebase utilities
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Componets layout
        btLogin = (Button) findViewById(R.id.btLogin);
        btRegister = (Button) findViewById(R.id.btRegistro);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);

        mAuth = FirebaseAuth.getInstance();

    }


    @Override
    protected void onStart() {
        super.onStart();

        /**Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            currentUser.reload();
        }**/

        //Onclick Registro button
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        //Onclick Login Button
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etEmail.getText().toString() != null && etPassword.getText().toString() != null ){

                    mAuth.signInWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Intent intent = new Intent(MainActivity.this, WorkDayActivity.class);
                                    startActivity(intent);
                                }


                            });

                }

            }
        });



    }




    private void updateUI(FirebaseUser user) {
    }
}

