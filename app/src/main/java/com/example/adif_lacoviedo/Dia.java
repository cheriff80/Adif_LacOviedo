package com.example.adif_lacoviedo;

import java.util.Date;

public class Dia {

    private int fechaDia,fechaMes,fechaAnio;
    private String horario,ntlfEmpleado,ntlfCtc,empresa,horaInic,horaFin,lugar,trabajo
            , observaciones,nombreCtc;
    private boolean encargadoTrabajos,corteTension,conduccion;

    public Dia() {
    }

    public boolean isEncargadoTrabajos() {
        return encargadoTrabajos;
    }

    public void setEncargadoTrabajos(boolean encargadoTrabajos) {
        this.encargadoTrabajos = encargadoTrabajos;
    }

    public boolean isCorteTension() {
        return corteTension;
    }

    public void setCorteTension(boolean corteTension) {
        this.corteTension = corteTension;
    }

    public boolean isConduccion() {
        return conduccion;
    }

    public void setConduccion(boolean conduccion) {
        this.conduccion = conduccion;
    }

    public int getFechaDia() {
        return fechaDia;
    }

    public String getNombreCtc() {
        return nombreCtc;
    }

    public void setNombreCtc(String nombreCtc) {
        this.nombreCtc = nombreCtc;
    }

    public void setFechaDia(int fechaDia) {
        this.fechaDia = fechaDia;
    }

    public int getFechaMes() {
        return fechaMes;
    }

    public void setFechaMes(int fechaMes) {
        this.fechaMes = fechaMes;
    }

    public int getFechaAnio() {
        return fechaAnio;
    }

    public void setFechaAnio(int fechaAnio) {
        this.fechaAnio = fechaAnio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNtlfEmpleado() {
        return ntlfEmpleado;
    }

    public void setNtlfEmpleado(String ntlfEmpleado) {
        this.ntlfEmpleado = ntlfEmpleado;
    }

    public String getNtlfCtc() {
        return ntlfCtc;
    }

    public void setNtlfCtc(String ntlfCtc) {
        this.ntlfCtc = ntlfCtc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getHoraInic() {
        return horaInic;
    }

    public void setHoraInic(String horaInic) {
        this.horaInic = horaInic;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
