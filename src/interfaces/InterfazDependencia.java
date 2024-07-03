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
import javax.swing.JLabel;

/**
 *
 * @author L34227
 */
public class InterfazDependencia extends javax.swing.JFrame {
    private DefaultTableModel modeloTabla1;
    private GestionDependencia objGestionDependencia; 
    private JLabel labelTexto;
    private GestionUsuario objGestionUsuarios;
    private String nombreDependencia;
    public InterfazDependencia() {
        initComponents();
    }
    public InterfazDependencia(GestionDependencia objGestionDependencia, GestionUsuario objGestionUsuarios, String nombreDependencia) {
        initComponents();
        this.objGestionDependencia= objGestionDependencia; 
        this.objGestionUsuarios=objGestionUsuarios;
        this.nombreDependencia=nombreDependencia;
        modeloTabla1=new DefaultTableModel();
        modeloTabla1.addColumn("ID");
        modeloTabla1.addColumn("Prioridad");      
        modeloTabla1.addColumn("Documento");
        modeloTabla1.addColumn("Interesado");
        modeloTabla1.addColumn("Hora");      
        //tabla1.setModel(modeloTabla1);
        table3.setModel(modeloTabla1);
        cargarInteresados(nombreDependencia);
    }   
    
    private void cargarInteresados(String nombreDependencia) {
        Dependencia dependenciaSeleccionada = null;
        for (int i = 1; i <= objGestionDependencia.getDependencias().longitud(); i++) {
            Dependencia dep = objGestionDependencia.getDependencias().iesimo(i);
            if (dep.getNombre().equals(nombreDependencia)) {
                dependenciaSeleccionada = dep;
                break;
            }
        }
    

        if (dependenciaSeleccionada != null) {
            Cola<Expediente> expedientes = dependenciaSeleccionada.getColaExpedientes();
            int n = expedientes.longitud();
            Cola<Expediente> temp = new Cola<>();
            txtNombreDependencia.setText(nombreDependencia);
            for (int i = 1; i <= n; i++) {
                Expediente intere = expedientes.desencolar();
                if (intere != null) {
                    String[] fila = new String[5];
                    fila[0] = String.valueOf(intere.getNumExpediente());
                    fila[1] = String.valueOf(intere.getPrioridad2().getPrioridad());
                    fila[2] = intere.getDocumento();
                    fila[3] = String.valueOf(intere.getInteresado().getNombre());
                    fila[4] = String.valueOf(intere.getTiempoExpediente());
                    modeloTabla1.addRow(fila);
                    temp.encolar(intere);
                } else {
                    System.err.println("Elemento nulo encontrado en la posición: " + i);
                }
            }
            while (!temp.esVacia()) {
                expedientes.encolar(temp.desencolar());
            }
        } else {
            System.out.println("Dependencia no encontrada");
        }
    }
    
    public Cola<Expediente> OrdenarColaPorTipo(Cola<Expediente> expedientes, String nombreDependencia){
        Dependencia dependenciaActual = null;
        for (int i = 1; i <= objGestionDependencia.getDependencias().longitud(); i++) {
            Dependencia dep = objGestionDependencia.getDependencias().iesimo(i);
            if (dep.getNombre().equals(nombreDependencia)) {
                dependenciaActual = dep;
                break;
            }
        }
        if (dependenciaActual != null) {
        Cola<Expediente> colarecopilada = dependenciaActual.getColaExpedientes();
        
            String tipoOrden = (String)jPrioridadOLlegada.getSelectedItem();
            if("Prioridad".equals(tipoOrden)) {
                return dependenciaActual.bubblesortPrioridad(dependenciaActual, colarecopilada);

            } 
            else if ("Orden de llegada".equals(tipoOrden)) {
                return dependenciaActual.bubblesortOrdenDeLlegada(dependenciaActual, colarecopilada);
            } 
        }

        return expedientes;
    }
    private void actualizarTabla(Cola<Expediente> colaOrdenada) {
        modeloTabla1.setRowCount(0); // Limpiar la tabla
        Cola<Expediente> temp = new Cola<>();
        while (!colaOrdenada.esVacia()) {
            Expediente intere = colaOrdenada.desencolar();
            if (intere != null) {
                String[] fila = new String[5];
                fila[0] = String.valueOf(intere.getNumExpediente());
                fila[1] = String.valueOf(intere.getPrioridad2().getPrioridad());
                fila[2] = intere.getDocumento();
                fila[3] = String.valueOf(intere.getInteresado().getNombre());
                fila[4] = String.valueOf(intere.getTiempoExpediente());
                modeloTabla1.addRow(fila);
                temp.encolar(intere);
            } else {
                System.err.println("Elemento nulo encontrado en la posición.");
            }
        }
        while (!temp.esVacia()) {
            colaOrdenada.encolar(temp.desencolar());
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

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        txtNombreDependencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPrioridadOLlegada = new javax.swing.JComboBox<>();
        OrdenarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table3);

        txtNombreDependencia.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreDependencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreDependencia.setText("DUSAR");

        jLabel2.setText("Expedientes");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("SELECCIONA UN EXPEDIENTE PARA");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ver datos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Menú");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPrioridadOLlegada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad", "Orden de llegada" }));
        jPrioridadOLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrioridadOLlegadaActionPerformed(evt);
            }
        });

        OrdenarBtn.setText("Ordenar");
        OrdenarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar por:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombreDependencia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPrioridadOLlegada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OrdenarBtn)
                                .addGap(126, 126, 126))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5))))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDependencia)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(OrdenarBtn)
                    .addComponent(jPrioridadOLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int index= this.table3.getSelectedRow();
        
        if(index!=-1){
            String dependencia = (String) txtNombreDependencia.getText();
            int id= Integer.parseInt((String) table3.getValueAt(index, 0));
            InterfazMoverExpediente swap=new InterfazMoverExpediente(id, dependencia, objGestionDependencia, objGestionUsuarios);
            swap.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"Seleccione una fila primero.");
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InterfazAdministrador form = new InterfazAdministrador(objGestionDependencia,objGestionUsuarios);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = this.table3.getSelectedRow();

        if (index != -1) {
            int id = Integer.parseInt(table3.getValueAt(index, 0).toString());
            String nombre = table3.getValueAt(index, 3).toString(); // Asegúrate de que estás obteniendo el nombre de la columna correcta
            InterfazModificadorExpediente interfazModificar = new InterfazModificadorExpediente(id, nombre, nombreDependencia, objGestionDependencia, objGestionUsuarios);
            interfazModificar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila primero.");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPrioridadOLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrioridadOLlegadaActionPerformed
        
    }//GEN-LAST:event_jPrioridadOLlegadaActionPerformed

    private void OrdenarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarBtnActionPerformed
        Cola<Expediente> colaOrdenada = OrdenarColaPorTipo(null, nombreDependencia);
        actualizarTabla(colaOrdenada);
    }//GEN-LAST:event_OrdenarBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int index = this.table3.getSelectedRow();

        if (index != -1) {
            int id = Integer.parseInt(table3.getValueAt(index, 0).toString());
            Expediente expediente=objGestionDependencia.getDependencias().buscarPorNombre(nombreDependencia).removerExpediente(id);
            InterfazVerDatosExpediente form = new InterfazVerDatosExpediente(objGestionDependencia,objGestionUsuarios,expediente);
            form.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila primero.");
        }       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazDependencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazDependencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazDependencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazDependencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazDependencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OrdenarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jPrioridadOLlegada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table3;
    private javax.swing.JLabel txtNombreDependencia;
    // End of variables declaration//GEN-END:variables
}
