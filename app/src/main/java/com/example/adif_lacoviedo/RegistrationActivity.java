package com.example.adif_lacoviedo;

import static android.content.ContentValues.TAG;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RegistrationActivity extends AppCompatActivity {

    //Employer
    private Empleado empleado;
    private HashSet<Dia> listaDias;

    //Layout components
    private EditText nombreApellidos,matricula,email,password;
    private Button registrar;

    //Firebase utilities
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nombreApellidos = (EditText) findViewById(R.id.etNombre);
        matricula =(EditText) findViewById(R.id.etMatricula);
        email = (EditText) findViewById(R.id.etRegisterEmail);
        password =(EditText) findViewById(R.id.etPasswordRegister);
        registrar = (Button) findViewById(R.id.btRegister);


        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }

        //Press Resgistrar button
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Edit Texts
                if(matricula.getText().toString() != null && nombreApellidos.getText().toString() !=null
                        && email.getText().toString() != null && password.getText().toString() != null){



                    //Create user Firebase Authentication
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        Toast.makeText(RegistrationActivity.this, "Registro Completado",Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);

                                        listaDias = new HashSet<>();

                                        empleado = new Empleado(nombreApellidos.getText().toString(),matricula.getText().toString(),
                                                email.getText().toString(),listaDias);

                                        // Add empleado to FirebaseFirestore
                                        firebaseFirestore.collection("empleado").document(matricula.getText().toString()).set(empleado)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Log.d("BASEDATOS", "createUserFirestoreCompleted");
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d("BASEDATOS", "Error writing user",e);
                                            }
                                        });

                                        //Return Main Activity
                                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegistrationActivity.this, "Ya existe usuario o Datos erróneos",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });
                }
            }
        });

    }

    private void updateUI(FirebaseUser user) {

    }


}