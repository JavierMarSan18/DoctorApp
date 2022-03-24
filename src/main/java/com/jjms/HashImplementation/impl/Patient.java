package com.jjms.HashImplementation.impl;

import java.util.LinkedList;
import java.util.Objects;

public class Patient {
    private String cui;
    private LinkedList<Vaccine> vaccines;

    public Patient(String cui) {
        this.cui = cui;
        this.vaccines = new LinkedList<>();
    }

    public void addVaccine(Vaccine v){
        vaccines.add(v);
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public LinkedList<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(LinkedList<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(cui, patient.cui) && Objects.equals(vaccines, patient.vaccines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cui, vaccines);
    }
}
