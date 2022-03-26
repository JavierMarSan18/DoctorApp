/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jjms.HashImplementation.gui;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jjms.HashImplementation.impl.Patient;
import com.jjms.HashImplementation.impl.Vaccine;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoseJavier
 */
public class DoctorApp extends javax.swing.JFrame {

    /**
     * Creates new form DoctorApp
     */
    public DoctorApp() {
        initComponents();
        loadPatients();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCui = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        cbVacuna = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegistros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DoctorApp");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jLabel1.setText("DPI (CUI):");

        txtCui.setName("txtCui"); // NOI18N

        jLabel2.setText("Fecha:");

        txtFecha.setName("txtFecha"); // NOI18N

        cbVacuna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Covid Dosis 1", "Covid Dosis 2", "Covid Dosis 3" }));

        jLabel3.setText("Vacuna:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tbRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CUI", "Vacuna", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRegistros.setEnabled(false);
        jScrollPane1.setViewportView(tbRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCui, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(cuiIsValid() && vaccineIsValid() && dateIsValid()){

            String cui = txtCui.getText();
           
            Patient patient = new Patient();
            Vaccine vaccine = new Vaccine();
            
            vaccine.setVacuna(cbVacuna.getSelectedItem().toString());
            vaccine.setFecha(txtFecha.getText());
            
            if(!patients.containsKey(cui)){
                patient.setCui(cui);
                patient.addVaccine(vaccine);         
                patients.put(patient.getCui(), patient);
            }else{
                patient = patients.get(cui);
                patient.addVaccine(vaccine);
                patients.put(cui, patient);
            }
            loadTable();
            saveInFile();
            clean();
            
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadTable();
    }//GEN-LAST:event_btnBuscarActionPerformed
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {/////////METODO MAIN
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DoctorApp().setVisible(true);
        });
    }
    
    private void loadTable(){
        String cui = txtCui.getText();
        if((cuiIsValid()) && cuiExist(cui)){
            
            Patient patient = patients.get(cui);
            LinkedList<Vaccine> vaccines = patient.getVacunas();
            
            DefaultTableModel model = new DefaultTableModel();
           
            model.addColumn("CUI");
            model.addColumn("Vacuna");
            model.addColumn("Fecha");
            
            for(Vaccine v:vaccines){
                model.addRow(new Object[]{cui,v.getVacuna(),v.getFecha()});
            }
            tbRegistros.setModel(model);
        }
    }
    
    
    private void clean(){
        txtCui.setText("");
        cbVacuna.setSelectedIndex(0);
        txtFecha.setText("");
    }
    
    private boolean cuiExist(String cui){
        if(!patients.containsKey(cui)){
            JOptionPane.showMessageDialog(null, "La persona no existe en el registro.");
            return false;
        }
        return true;
    }
    
    private static void loadPatients(){
        try{
            Gson gson = new Gson();
            Patient patient;
            Scanner sc = new Scanner(file);
            System.out.println("Cosa");
            while(sc.hasNextLine()){
                patient = gson.fromJson(sc.nextLine(), Patient.class);
                patients.put(patient.getCui(),patient);
            }
        }catch (JsonSyntaxException | FileNotFoundException e){}
    }
    
    private void saveInFile(){
        try{
            Gson gson = new Gson();
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for (String key: patients.keySet()){
                    String json = gson.toJson(patients.get(key));
                    bw.write(json+"\n");
                }
            }
        }catch (IOException e){}
    }
    
    private boolean cuiIsValid(){
        String cui = txtCui.getText();
        if(cui.length()!=13){
            JOptionPane.showMessageDialog(null, "El CUI ingresado es inválido.");
            return false;
        }
        return true;
    }
    
    private boolean vaccineIsValid(){
        if(cbVacuna.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Aún no se ha seleccionado una vacuna.");
            return false;
        }
        return true;
    }
    
    private boolean dateIsValid(){
        String date = txtFecha.getText();
        if(date.length()!=10){
            JOptionPane.showMessageDialog(null, "La FECHA ingresada es inválida.");
            return false;
        }
        return true;
    }

    
    static HashMap<String, Patient> patients = new HashMap<>();
    static File file = new File("src/main/resources/userData/vacunas.txt");
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbVacuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRegistros;
    private javax.swing.JTextField txtCui;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}