package com.jjms.HashImplementation.impl;


import java.util.Objects;

public class Vaccine {

    private String vacuna;
    private String fecha;

    public Vaccine() {

    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(vacuna, vaccine.vacuna) && Objects.equals(fecha, vaccine.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacuna, fecha);
    }
}
