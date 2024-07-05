/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import javax.swing.table.DefaultTableModel;
import modelos.*;
import tda.*;
import controlador.*;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author brina
 */
public class InterfazAdministrador extends javax.swing.JFrame {
    private GestionDependencia objGestionDependencia;
    private DefaultTableModel modeloTabla1;
    private GestionPersonal objGestionUsuarios;
    private Administrador admin;
    public InterfazAdministrador() {
        initComponents();      
    }
    public InterfazAdministrador(GestionDependencia objGestionDependencia, GestionPersonal objGestionUsuarios) {        
        initComponents();
        CerrarVentanas();
        MostrarHora();
        
        txtPresentacion.setText("Hola, "+"Mi estimado");
        
        this.objGestionDependencia= objGestionDependencia;
        this.objGestionUsuarios=objGestionUsuarios;
        modeloTabla1 = new DefaultTableModel();
        modeloTabla1.addColumn("Nombre");
        modeloTabla1.addColumn("Encargado");
      
        //tabla1.setModel(modeloTabla1);
        tabla2.setModel(modeloTabla1);
        this.cargarInteresados();
    }
    public void MostrarHora(){            
        Timer timer = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            txthora.setText("Hora: "+formattedDateTime);
        }
        });
        timer.start();
    }
    
    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    private void cargarInteresados() {
        Lista<Dependencia> dependencia = objGestionDependencia.getDependencias();
        int n = dependencia.longitud();

        for (int i = 1; i <= n ; i++) {
            Dependencia intere = dependencia.iesimo(i);
            if (intere != null) {
                String[] fila = new String[4];
                fila[0] = intere.getNombre();
                fila[1] = intere.getEncargado();
                modeloTabla1.addRow(fila);
            } else {
                System.err.println("Elemento nulo encontrado en la posición: " + i);
            }
        }
    }
    private void CerrarVentanas(){
        IniciarSesión iniciarSesion = new IniciarSesión();
        InterfazCrearDependencia crearDependencia = new InterfazCrearDependencia();
        InterfazCrearExpediente crearExpediente = new InterfazCrearExpediente();
        InterfazDependencia dependencia = new InterfazDependencia();
        InterfazModificadorExpediente modificarExpediente = new InterfazModificadorExpediente();
        InterfazMoverExpediente moverExpediente = new InterfazMoverExpediente();
        InterfazVerDatosExpediente verDatosExpediente = new InterfazVerDatosExpediente();
        if (iniciarSesion != null && iniciarSesion.isVisible()) {
            iniciarSesion.setVisible(false);
        }
        if (crearDependencia != null && crearDependencia.isVisible()) {
            crearDependencia.setVisible(false);
        }
        if (crearExpediente != null && crearExpediente.isVisible()) {
            crearExpediente.setVisible(false);
        }
        if (dependencia != null && dependencia.isVisible()) {
            dependencia.setVisible(false);
        }
        if (modificarExpediente != null && modificarExpediente.isVisible()) {
            modificarExpediente.setVisible(false);
        }
        if (moverExpediente != null && moverExpediente.isVisible()) {
            moverExpediente.setVisible(false);
        }
        if (verDatosExpediente != null && verDatosExpediente.isVisible()) {
            verDatosExpediente.setVisible(false);
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

        jPanel2 = new javax.swing.JPanel();
        txtPresentacion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        Expedientes = new javax.swing.JButton();
        txthora = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        setForeground(new java.awt.Color(255, 153, 0));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPresentacion.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        txtPresentacion.setForeground(new java.awt.Color(51, 51, 51));
        txtPresentacion.setText("NombreAdmin");
        jPanel2.add(txtPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Dependencias Disponibles");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("UBICAR DEPENDENCIA");
        jButton1.setAutoscrolls(true);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 143, 200, 30));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla2.setGridColor(new java.awt.Color(204, 204, 204));
        tabla2.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(tabla2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 480, 120));

        jButton6.setBackground(new java.awt.Color(255, 51, 0));
        jButton6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Crear Expediente");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 30));

        Expedientes.setBackground(new java.awt.Color(255, 51, 0));
        Expedientes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Expedientes.setForeground(new java.awt.Color(255, 255, 255));
        Expedientes.setText("Ver Expedientes");
        Expedientes.setBorderPainted(false);
        Expedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpedientesActionPerformed(evt);
            }
        });
        jPanel2.add(Expedientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 150, 30));

        txthora.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txthora.setForeground(new java.awt.Color(0, 0, 0));
        txthora.setText("Hora");
        jPanel2.add(txthora, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 51, 0));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Crear Dependecia");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RECURSOS/InterfazAdministradorFONDO.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InterfazCrearDependencia interfazCreardependencia=new InterfazCrearDependencia(objGestionDependencia, objGestionUsuarios);
        interfazCreardependencia.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        InterfazCrearExpediente form = new InterfazCrearExpediente(objGestionDependencia, objGestionUsuarios);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index= this.tabla2.getSelectedRow();

        if(index!=-1){
            String nombreDependencia = (String) tabla2.getValueAt(index, 0);
            InterfazDependencia interfazdepen= new InterfazDependencia(objGestionDependencia,objGestionUsuarios,nombreDependencia);
            interfazdepen.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Seleccione una fila primero.");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpedientesActionPerformed
        InterfazTotalExpedientes form = new InterfazTotalExpedientes(objGestionDependencia,objGestionUsuarios);
        form.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpedientesActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Expedientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla2;
    private javax.swing.JLabel txtPresentacion;
    private javax.swing.JLabel txthora;
    // End of variables declaration//GEN-END:variables
}
