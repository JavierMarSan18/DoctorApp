package com.jjms.HashImplementation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VaccinatedPatient {
    private Patient patient;
    private List<Vaccine> vaccine;

    public VaccinatedPatient(Patient patient, Vaccine vaccine) {
        this.patient = patient;
        this.vaccine = new ArrayList<>();
        this.vaccine.add(vaccine);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Vaccine> getVaccine() {
        return vaccine;
    }

    public void setVaccine(List<Vaccine> vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinatedPatient that = (VaccinatedPatient) o;
        return Objects.equals(patient, that.patient) && Objects.equals(vaccine, that.vaccine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, vaccine);
    }

}
