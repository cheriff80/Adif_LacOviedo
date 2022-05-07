package com.example.adif_lacoviedo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class WorkDayActivity extends AppCompatActivity {

    private EditText etDate;
    private Switch swEncargadoTrabajos,swCorteTension,swConduccion;
    private TextView tvEtHorario,tvEtTelefonemaEt,tvEtTelefonemaCtc,tvNombreCtc,tvEtTrabajo,tvEtEmpresa;
    private TextView tvCtHoraInicio,tvCtHoraFin,tvCtLugar,tvCtTrabajo;

    private Dia claseDia;
    private int mes,dia,anio;

    private DatePickerDialog picker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_day);

        //Class Day
        claseDia = new Dia();

        etDate = (EditText) findViewById(R.id.etFecha);
        swEncargadoTrabajos = (Switch) findViewById(R.id.swEt);
        swCorteTension = (Switch) findViewById(R.id.swCorteTension);
        swConduccion = (Switch) findViewById(R.id.swConduccion);

        //Text views Encargado Trabajos
        tvEtHorario = (TextView) findViewById(R.id.tvEtHorario);
        tvEtTelefonemaEt = (TextView) findViewById(R.id.tvEtTlfEt);
        tvEtTelefonemaCtc = (TextView) findViewById(R.id.tvEtTlfCtc);
        tvNombreCtc = (TextView) findViewById(R.id.tvEtNombreCtc);
        tvEtTrabajo  =(TextView) findViewById(R.id.tvEtTrabajo);
        tvEtEmpresa = (TextView) findViewById(R.id.tvEtEmpresa);
        //Text Views for Corte de Tensión
        tvCtHoraInicio = (TextView) findViewById(R.id.tvCtHoraInicio);
        tvCtHoraFin = (TextView) findViewById(R.id.tvCtHoraFin);
        tvCtLugar = (TextView) findViewById(R.id.tvCtLugar);
        tvCtTrabajo = (TextView) findViewById(R.id.tvCtTrabajo);

        //cast bundle
        Bundle b = this.getIntent().getExtras();
        if (b != null){
            //If comes from activity EncargadoTrabajos
            if(b.getBoolean("EncargadoTrabajos")){

                //Change text views
                swEncargadoTrabajos.setChecked(true);
                tvEtHorario.setText(b.getString("Horario"));
                tvEtTelefonemaEt.setText(b.getString("NumTelefonemaEt"));
                tvEtTelefonemaCtc.setText(b.getString("NumTelefonemaCtc"));
                tvNombreCtc.setText(b.getString("NombreCtc"));
                tvEtTrabajo.setText(b.getString("LugarTrabajo"));
                tvEtEmpresa.setText(b.getString("Empresa"));
                //Class day
                claseDia.setHorario(b.getString("Horario"));
                claseDia.setNtlfEmpleado(b.getString("NumTelefonemaEt"));
                claseDia.setNtlfCtc(b.getString("NumTelefonemaCtc"));
                claseDia.setNombreCtc(b.getString("NombreCtc"));
                claseDia.setLugar(b.getString("LugarTrabajo"));
                claseDia.setEmpresa(b.getString("Empresa"));
                claseDia.setEncargadoTrabajos(true);
            }
            if(b.getBoolean("CorteTension")){

                swCorteTension.setChecked(true);
                tvCtHoraInicio.setText(b.getString("HoraInicio"));
                tvCtHoraFin.setText(b.getString("HoraFin"));
                tvCtLugar.setText(b.getString("Lugar"));
                tvCtTrabajo.setText(b.getString("Trabajo"));
                //Class Day
                claseDia.setHoraInic(b.getString("HoraInicio"));
                claseDia.setHoraFin(b.getString("HoraFin"));
                claseDia.setLugar(b.getString("Lugar"));
                claseDia.setTrabajo(b.getString("Trabajo"));
                claseDia.setCorteTension(true);


            }

        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        //Edit text Select date
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**DialogFragment newFragment = new DatePickerDialog();
                newFragment.show(getSupportFragmentManager(), "datePicker");*/

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // date picker dialog
                picker = new DatePickerDialog(WorkDayActivity.this, new android.app.DatePickerDialog.OnDateSetListener()
                         {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                claseDia.setFechaDia(dayOfMonth);
                                claseDia.setFechaMes(monthOfYear);
                                claseDia.setFechaAnio(year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        //Switch Encargado de trabajos
        swEncargadoTrabajos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Intent intent = new Intent(WorkDayActivity.this, EncargadoTrabajos.class);
                startActivity(intent);
            }
        });

        //Switch Corte Tension
        swCorteTension.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent intent = new Intent(WorkDayActivity.this, CorteTension.class);
                startActivity(intent);
            }
        });

        //Switch conduccion
        swConduccion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                claseDia.setConduccion(true);
            }
        });





    }

}