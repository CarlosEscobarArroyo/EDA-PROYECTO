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
    private GestionPersonal objGestionUsuarios;
    private String nombreDependencia;
    /**
     * Creates new form InterfazTotalExpedientes
     */
    public InterfazTotalExpedientes() {
        initComponents();
    }
    public InterfazTotalExpedientes(GestionDependencia objGestionDependencia, GestionPersonal objGestionUsuarios){
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Expedientes Registrados");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText(" Expedientes Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 310, 80));

        txtTable3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 660, 150));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 580, -1, -1));

        txtTable4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 386, 660, 150));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText(" Expedientes Finalizados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 300, 70));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ESTADO ACTUAL DE EXPEDIENTES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 24, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RECURSOS/InterfazTotalExpedientesFONDO.png"))); // NOI18N
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable txtTable3;
    private javax.swing.JTable txtTable4;
    // End of variables declaration//GEN-END:variables
}
