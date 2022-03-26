package com.jjms.HashImplementation.impl;

import java.util.LinkedList;
import java.util.Objects;

public class Patient {
    private String cui;
    private LinkedList<Vaccine> vacunas;

    public Patient() {
        this.vacunas = new LinkedList<>();
    }

    public void addVaccine(Vaccine v){
        vacunas.add(v);
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public LinkedList<Vaccine> getVacunas() {
        return vacunas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(cui, patient.cui) && Objects.equals(vacunas, patient.vacunas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cui, vacunas);
    }
}
