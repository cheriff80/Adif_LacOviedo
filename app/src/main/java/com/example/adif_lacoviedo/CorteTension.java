package com.example.adif_lacoviedo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CorteTension extends AppCompatActivity {

    private EditText etCtHoraInicio,etCtHoraFin,etCtLugar,etCtTrabajo;
    private Button btCorteTension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corte_tension);

        etCtHoraInicio = (EditText) findViewById(R.id.etCtHoraInicio);
        etCtHoraFin = (EditText) findViewById(R.id.etCtHoraFin);
        etCtLugar = (EditText) findViewById(R.id.etCtLugar);
        etCtTrabajo = (EditText) findViewById(R.id.etCtTrabajo);
        btCorteTension = (Button) findViewById(R.id.btCorteTension);


    }

    @Override
    protected void onStart() {
        super.onStart();

        btCorteTension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cast edit texts
                if(etCtHoraInicio.getText().toString() !=null && etCtHoraFin.getText().toString() != null
                        && etCtLugar.getText().toString() != null && etCtTrabajo.getText().toString() != null){

                    //Start bundle
                    Bundle extras = new Bundle();

                    //Come back WorkDayActivity and send information
                    Intent intent = new Intent(CorteTension.this, WorkDayActivity.class);

                    extras.putString("HoraInicio", etCtHoraInicio.getText().toString() );
                    extras.putString("HoraFin", etCtHoraFin.getText().toString());
                    extras.putString("Lugar", etCtLugar.getText().toString());
                    extras.putString("Trabajo", etCtTrabajo.getText().toString());
                    extras.putBoolean("CorteTension", true);

                    //put extras in intent
                    intent.putExtras(extras);
                    //start activity
                    startActivity(intent);
                }else{
                    Toast.makeText(CorteTension.this, "Datos incompletos",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}