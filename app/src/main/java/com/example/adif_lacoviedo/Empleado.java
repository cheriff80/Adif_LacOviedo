package com.example.adif_lacoviedo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashSet;
import java.util.Set;

public class Empleado {

    private String nombreApellidos,matricula,email;
    private HashSet<Dia> listaDias;

    public Empleado() {
    }

    public Empleado(String nombreApellidos, String matricula, String email, HashSet<Dia> listaDias) {
        this.nombreApellidos = nombreApellidos;
        this.matricula = matricula;
        this.email = email;
        this.listaDias = listaDias;

    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
