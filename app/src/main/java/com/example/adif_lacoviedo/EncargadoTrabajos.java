package com.example.adif_lacoviedo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EncargadoTrabajos extends AppCompatActivity {

    private Spinner spHorarios;
    private EditText etNumeroEt,etNumeroCtc,etNombreCtc,etLugarTrabajo,etEmpresa;
    private Button btGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encargado_trabajos);

        //Spinner
        spHorarios = (Spinner) findViewById(R.id.spHorario);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EncargadoTrabajos.this,
                R.array.horarios, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spHorarios.setAdapter(adapter);

        //Edit Texts declaration
        etNumeroEt = (EditText) findViewById(R.id.etNumeroET);
        etNumeroCtc = (EditText) findViewById(R.id.etNumeroCTC);
        etNombreCtc = (EditText) findViewById(R.id.etNombreRc);
        etLugarTrabajo = (EditText) findViewById(R.id.etLugarTrabajo);
        etEmpresa = (EditText) findViewById(R.id.etEmpresa);

        //Button declaration
        btGuardar = (Button) findViewById(R.id.btCorteTension);

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Button Onclick
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cast edit texts
                if(spHorarios.getSelectedItem().toString() != null && etNumeroEt.getText().toString() !=null
                    && etNumeroCtc.getText().toString() != null && etNombreCtc.getText().toString() != null
                        && etLugarTrabajo.getText().toString() != null && etEmpresa.getText().toString() != null){

                    //Start bundle
                    Bundle extras = new Bundle();

                    //Come back WorkDayActivity and send information
                    Intent intent = new Intent(EncargadoTrabajos.this, WorkDayActivity.class);

                    extras.putString("Horario", spHorarios.getSelectedItem().toString());
                    extras.putString("NumTelefonemaEt", etNumeroEt.getText().toString() );
                    extras.putString("NumTelefonemaCtc", etNumeroCtc.getText().toString());
                    extras.putString("NombreCtc", etNombreCtc.getText().toString());
                    extras.putString("LugarTrabajo", etLugarTrabajo.getText().toString());
                    extras.putString("Empresa", etEmpresa.getText().toString());
                    extras.putBoolean("EncargadoTrabajos", true);

                    //put extras in intent
                    intent.putExtras(extras);
                    //start activity
                    startActivity(intent);
                }else{
                    Toast.makeText(EncargadoTrabajos.this, "Datos incompletos",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}