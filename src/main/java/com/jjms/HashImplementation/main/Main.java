package com.jjms.HashImplementation.main;

import com.google.gson.Gson;
import com.jjms.HashImplementation.impl.Patient;
import com.jjms.HashImplementation.impl.Vaccine;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Scanner read = new Scanner(System.in);
    static HashMap<String, Patient> patients = new HashMap<>();
    static File file = new File("src/main/resources/vacunas.txt");
    static Gson gson = new Gson();

    public static void main(String[] args) {
        initFile();
        loadPatients();
        showHashMap();
        startMenu();
    }

    private static void startMenu(){
        System.out.println("-----------------------");
        System.out.println("BIENVENIDO A DOCTOR APP");
        System.out.println("   Personas Vacunadas  ");
        System.out.println("-----------------------");
        System.out.println("1.-Agregar             ");
        System.out.println("2.-Buscar              ");
        System.out.println("3.-Salir               ");
        System.out.println("-----------------------");
        String opc = read.nextLine();

        switch (opc) {
            case "1" -> {
                addPatient();
                startMenu();
            }
            case "2" -> {
                searchPatient();
                startMenu();
            }
            default -> {
            }
        }
    }

    private static void addPatient() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = dtf.format(LocalDateTime.now());
        System.out.print("\n------"+date+"-------");
        System.out.print("\nBIENVENIDO A DOCTOR APP");
        System.out.print("\n       Registro        ");
        System.out.print("\n-----------------------");
        System.out.print("\nDPI (CUI): ");
        String cui = read.nextLine();

        if (!patients.containsKey(cui)){
            System.out.print("Vacuna: ");
            String vacuna = read.nextLine();
            Vaccine vaccine = new Vaccine(vacuna,date);
            Patient patient = new Patient(cui);
            patient.addVaccine(vaccine);
            patient.addVaccine(vaccine);

            patients.put(cui,patient);
            saveInFile();
            System.out.println("El Paciente ha sido agregado");
        }
    }

    private static void showHashMap(){
        for (String clave:patients.keySet()) {
            Patient patient = patients.get(clave);
            System.out.println("Clave: " + patient.getCui());
            for (Vaccine vaccine:patient.getVacunas()){
                System.out.println("Vacuna: "+vaccine.getVacuna()+" - Fecha: "+vaccine.getFecha());
            }
        }
    }

    private static void searchPatient() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = dtf.format(LocalDateTime.now());
        System.out.print("\n------"+date+"-------");
        System.out.print("\nBIENVENIDO A DOCTOR APP");
        System.out.print("\n       Busqueda        ");
        System.out.print("\n-----------------------");
        System.out.print("\nDPI (CUI): ");
        String cui = read.nextLine();

        if (!patients.containsKey(cui)){
            System.out.println("El paciente no existe");
            startMenu();
        }

        Patient p = patients.get(cui);
        String pCui = p.getCui();
        LinkedList<Vaccine> vaccines = p.getVacunas();
        System.out.println("Cui: "+pCui);

        for(Vaccine v: vaccines){
            System.out.println("Vacuna: "+v.getVacuna()+"- Fecha: "+v.getFecha());
        }

    }

    private static void saveInFile(){
        try{
            Gson gson = new Gson();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String key: patients.keySet()){
                String json = gson.toJson(patients.get(key));
                bw.write(json+"\n");
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void loadPatients(){
        try{
            Patient patient;
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                patient = gson.fromJson(sc.nextLine(), Patient.class);
                patients.put(patient.getCui(),patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void initFile(){
        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
