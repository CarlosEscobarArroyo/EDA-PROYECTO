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
        System.out.println(nombreDependencia);
        
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
        botonModificar = new javax.swing.JButton();
        botonMover = new javax.swing.JButton();
        botonVerDatos = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPrioridadOLlegada = new javax.swing.JComboBox<>();
        OrdenarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonFinalizar = new javax.swing.JButton();
        botonHistorial = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 480, 110));

        txtNombreDependencia.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreDependencia.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        txtNombreDependencia.setForeground(new java.awt.Color(243, 57, 11));
        txtNombreDependencia.setText("DUSAR");
        jPanel1.add(txtNombreDependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 65, -1, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setText("Expedientes:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("SELECCIONA UN EXPEDIENTE PARA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 293, 31));

        botonModificar.setBackground(new java.awt.Color(255, 51, 0));
        botonModificar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        botonModificar.setForeground(new java.awt.Color(255, 255, 255));
        botonModificar.setText("Modificar");
        botonModificar.setBorderPainted(false);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        botonMover.setBackground(new java.awt.Color(255, 51, 0));
        botonMover.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        botonMover.setForeground(new java.awt.Color(255, 255, 255));
        botonMover.setText("Mover");
        botonMover.setBorderPainted(false);
        botonMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMoverActionPerformed(evt);
            }
        });
        jPanel1.add(botonMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 113, -1));

        botonVerDatos.setBackground(new java.awt.Color(255, 51, 0));
        botonVerDatos.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        botonVerDatos.setForeground(new java.awt.Color(255, 255, 255));
        botonVerDatos.setText("Ver datos");
        botonVerDatos.setBorderPainted(false);
        botonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDatosActionPerformed(evt);
            }
        });
        jPanel1.add(botonVerDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 110, -1));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton5.setText("Menú");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jPrioridadOLlegada.setBackground(new java.awt.Color(204, 204, 204));
        jPrioridadOLlegada.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jPrioridadOLlegada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad", "Orden de llegada" }));
        jPrioridadOLlegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrioridadOLlegadaActionPerformed(evt);
            }
        });
        jPanel1.add(jPrioridadOLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 140, -1));

        OrdenarBtn.setBackground(new java.awt.Color(204, 204, 204));
        OrdenarBtn.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        OrdenarBtn.setText("Ordenar");
        OrdenarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(OrdenarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 100, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel1.setText("Ordenar por:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RECURSOS/InterfazDependencia.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonFinalizar.setBackground(new java.awt.Color(255, 51, 0));
        botonFinalizar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        botonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        botonFinalizar.setText("Finalizar");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        botonHistorial.setText("historial");
        botonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(botonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMoverActionPerformed
        
        int index= this.table3.getSelectedRow();
        
        if(index!=-1){
            String dependencia = (String) txtNombreDependencia.getText();
            int id= Integer.parseInt((String) table3.getValueAt(index, 0));
            System.out.println("la dependencia es: " + nombreDependencia);
            InterfazMoverExpediente swap = new InterfazMoverExpediente(id, nombreDependencia, objGestionDependencia, objGestionUsuarios);
            System.out.println(dependencia);
            swap.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"Seleccione una fila primero.");
        }        
    }//GEN-LAST:event_botonMoverActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InterfazAdministrador form = new InterfazAdministrador(objGestionDependencia,objGestionUsuarios);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
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
        
        
    }//GEN-LAST:event_botonModificarActionPerformed

    private void jPrioridadOLlegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrioridadOLlegadaActionPerformed
        
    }//GEN-LAST:event_jPrioridadOLlegadaActionPerformed

    private void OrdenarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarBtnActionPerformed
        Cola<Expediente> colaOrdenada = OrdenarColaPorTipo(null, nombreDependencia);
        actualizarTabla(colaOrdenada);
    }//GEN-LAST:event_OrdenarBtnActionPerformed

    private void botonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDatosActionPerformed
        int index = this.table3.getSelectedRow();

        if (index != -1) {
            int id = Integer.parseInt(table3.getValueAt(index, 0).toString());
            Expediente expediente=objGestionDependencia.getDependencias().buscarPorNombre(nombreDependencia).removerExpediente(id);
            InterfazVerDatosExpediente form = new InterfazVerDatosExpediente(nombreDependencia, objGestionDependencia,objGestionUsuarios,expediente);
            form.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila primero.");
        }       
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVerDatosActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        // TODO add your handling code here:
        int index = this.table3.getSelectedRow();

        if (index != -1) {
            int id = Integer.parseInt(table3.getValueAt(index, 0).toString());
            Dependencia dependenciaSeleccionada = null;
                for (int i = 1; i <= objGestionDependencia.getDependencias().longitud(); i++) {
                    Dependencia dep = objGestionDependencia.getDependencias().iesimo(i);
                    if (dep.getNombre().equals(this.nombreDependencia)) {
                        dependenciaSeleccionada = dep;
                        break;
                }
            }
            Expediente expediente= dependenciaSeleccionada.removerExpediente(id);
            dependenciaSeleccionada.agregarExpedienteFinalizado(expediente);
            actualizarTabla(dependenciaSeleccionada.getColaExpedientes());            
                    
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila primero.");
        } 
    }//GEN-LAST:event_botonFinalizarActionPerformed

    private void botonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHistorialActionPerformed
        // TODO add your handling code here:

        InterfazFinalizarExpediente form = new InterfazFinalizarExpediente(objGestionDependencia, objGestionUsuarios, nombreDependencia);
        form.setVisible(true);
               
        
    }//GEN-LAST:event_botonHistorialActionPerformed

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
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JButton botonHistorial;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonMover;
    private javax.swing.JButton botonVerDatos;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jPrioridadOLlegada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table3;
    private javax.swing.JLabel txtNombreDependencia;
    // End of variables declaration//GEN-END:variables
}
