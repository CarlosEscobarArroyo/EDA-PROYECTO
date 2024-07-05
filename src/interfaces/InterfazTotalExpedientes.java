/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import javax.swing.table.DefaultTableModel;
import modelos.*;
import tda.*;
import controlador.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Alonso
 */
public class InterfazTotalExpedientes extends javax.swing.JFrame{
    private DefaultTableModel modeloTabla1;
    private DefaultTableModel modeloTabla2;
    private GestionDependencia objGestionDependencia; 
    private JLabel labelTexto;
    private GestionUsuario objGestionUsuarios;
    private String nombreDependencia;
    /**
     * Creates new form InterfazTotalExpedientes
     */
    public InterfazTotalExpedientes() {
        initComponents();
    }
    public InterfazTotalExpedientes(GestionDependencia objGestionDependencia, GestionUsuario objGestionUsuarios){
        initComponents();
        this.objGestionDependencia= objGestionDependencia; 
        this.objGestionUsuarios=objGestionUsuarios;
        modeloTabla1=new DefaultTableModel();
        modeloTabla1.addColumn("ID");
        modeloTabla1.addColumn("Prioridad");      
        modeloTabla1.addColumn("Documento");
        modeloTabla1.addColumn("Interesado");
        modeloTabla1.addColumn("Estado");      
        modeloTabla1.addColumn("Hora");
        modeloTabla1.addColumn("Dependencia");

        modeloTabla2=new DefaultTableModel();
        modeloTabla2.addColumn("ID");
        modeloTabla2.addColumn("Prioridad");      
        modeloTabla2.addColumn("Documento");
        modeloTabla2.addColumn("Interesado");
        modeloTabla2.addColumn("Hora de Inicio");      
        modeloTabla2.addColumn("Hora de Fin");  
        modeloTabla2.addColumn("Tiempo Total");  
        modeloTabla2.addColumn("Dependencia");
        
        txtTable3.setModel(modeloTabla1);
        txtTable4.setModel(modeloTabla2);
        
        cargarInteresados();
        cargarInteresados2();
    }
    public void cargarInteresados(){
        Cola<Expediente> expedientes = objGestionDependencia.obtenerHistorialCompleto();
            int n = expedientes.longitud();
            Cola<Expediente> temp = new Cola<>();
            for (int i = 1; i <= n; i++) {
                Expediente intere = expedientes.desencolar();
                if (intere != null) {
                    String[] fila = new String[7];
                    fila[0] = String.valueOf(intere.getNumExpediente());
                    fila[1] = String.valueOf(intere.getPrioridad2().getPrioridad());
                    fila[2] = intere.getDocumento();
                    fila[3] = String.valueOf(intere.getInteresado().getNombre());
                    fila[4] = intere.getEstado();
                    fila[5] = String.valueOf(intere.getTiempoExpediente());
                    fila[6] = String.valueOf(intere.getDependenciaActual());
                    modeloTabla1.addRow(fila);
                    temp.encolar(intere);
                } else {
                    System.err.println("Elemento nulo encontrado en la posición: " + i);
                }
            }
            while (!temp.esVacia()) {
                expedientes.encolar(temp.desencolar());
            }
    }
    
    public void cargarInteresados2(){
        Cola<Expediente> expedientes = objGestionDependencia.obtenerHistorialFinalizados();
            int n = expedientes.longitud();
            Cola<Expediente> temp = new Cola<>();
            for (int i = 1; i <= n; i++) {
                Expediente intere = expedientes.desencolar();
                if (intere != null) {
                    String[] fila = new String[8];
                    fila[0] = String.valueOf(intere.getNumExpediente());
                    fila[1] = String.valueOf(intere.getPrioridad2().getPrioridad());
                    fila[2] = intere.getDocumento();
                    fila[3] = String.valueOf(intere.getInteresado().getNombre());
                    fila[4] = String.valueOf(intere.getTiempoExpediente());
                    fila[5] = String.valueOf(intere.getHoraFinalizada());
                    LocalTime horaInicial = intere.getTiempoExpediente();
                    LocalTime horaFinal = intere.getHoraFinalizada();
                    long segundosDiferencia = horaInicial.until(horaFinal, ChronoUnit.SECONDS);
                    fila[6] = String.valueOf(segundosDiferencia);
                    fila[7] = String.valueOf(intere.getDependenciaActual());
                    modeloTabla2.addRow(fila);
                    temp.encolar(intere);
                } else {
                    System.err.println("Elemento nulo encontrado en la posición: " + i);
                }
            }
            while (!temp.esVacia()) {
                expedientes.encolar(temp.desencolar());
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTable4 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Expedientes Registrados");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Expedientes Registrados");

        txtTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(txtTable3);

        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(txtTable4);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Expedientes Finalizados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 672, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(238, 238, 238))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(222, 222, 222))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InterfazAdministrador form = new InterfazAdministrador(objGestionDependencia,objGestionUsuarios);
        form.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(InterfazTotalExpedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazTotalExpedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazTotalExpedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazTotalExpedientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazTotalExpedientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable txtTable3;
    private javax.swing.JTable txtTable4;
    // End of variables declaration//GEN-END:variables
}
