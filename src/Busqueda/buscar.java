/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busqueda;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Marco Calderón
 */
public class buscar extends javax.swing.JInternalFrame {

    /**
     * Creates new form filtar
     */
    public buscar() {
        initComponents();
        JDFecha.setVisible(false);
        labelFecha.setVisible(false);
        cbMarc.setVisible(false);
        labelMarca.setVisible(false);
        cbArti.setVisible(false);
        labelArti.setVisible(false);
        labelNit.setVisible(false);
        txtNit.setVisible(false);
        labelOrden.setVisible(false);
        txtNoOrden.setVisible(false);
        clean();
    }
    conexion connect= new conexion();
    Connection db=connect.conexion();
    boolean flagSaveUpdate=false;
    String id="";
    void clean(){
        getMarca();
        getArti();
    }
    int getIdArt(String Buscar){
        int id=-1;
        try {
            String query="select idArticulo from articulo where descripcion='"+Buscar+"'";
            PreparedStatement ps=db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                id=rs.getInt("idArticulo");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener id de Articulo");
        }
        return id;
    }
    void getArti(){
        cbArti.removeAllItems();
        try {
            String query="SELECT * FROM articulo";
            PreparedStatement ps= db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cbArti.addItem(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al traer Datos de Articulo");
        }
    }
    int getIdMarca(String Buscar){
        int id=-1;
        try {
            String query="Select idMarca from marca where descripcion='"+Buscar+"'";
            PreparedStatement ps=db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                id=rs.getInt("idMarca");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener id de Marca");
        }
        return id;
    }
    void getMarca(){
        cbArti.removeAllItems();
        try {
            String query="SELECT * FROM marca";
            PreparedStatement ps= db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cbArti.addItem(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al traer Datos de Marca");
        }
    }
    void BuscarNoOrden(){        
        try {
            String query="SELECT idOrden FROM orden where idOrden='"+txtNoOrden.getText().trim()+"'";
            PreparedStatement ps= db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Numero de Orden Encontrado");
            }else{
                JOptionPane.showMessageDialog(null,"Numero de Orden NO Encontrado");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void BuscarNit(){        
        try {
            String query="SELECT idCliente FROM orden where idCliente='"+txtNit.getText().trim()+"'";
            PreparedStatement ps= db.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"NIT Encontrado");
            }else{
                JOptionPane.showMessageDialog(null,"NIT NO Encontrado");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void comparar(){
        try {
            String Ubicacion=System.getProperty("user.dir")+"/src/Reporte/Buscar.jasper";
            JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(Ubicacion);
            JasperPrint print= JasperFillManager.fillReport(reporte,null,db);
            JasperViewer view=new JasperViewer(print,false);
            view.setVisible(true);
            String UbicacionGuardar=System.getProperty("user.dir")+"/Reportes/Buscar.pdf";
            JasperExportManager.exportReportToPdfFile(print,UbicacionGuardar);
        } catch (Exception e) {
            e.printStackTrace();
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

        buttonGroupTipoOrden = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        CheckBoxNoOrden = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtNoOrden = new javax.swing.JTextField();
        CheckBoxNit = new javax.swing.JCheckBox();
        labelNit = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        CheckBoxArt = new javax.swing.JCheckBox();
        labelArti = new javax.swing.JLabel();
        cbArti = new javax.swing.JComboBox<>();
        CheckBoxMarc = new javax.swing.JCheckBox();
        cbMarc = new javax.swing.JComboBox<>();
        labelMarca = new javax.swing.JLabel();
        CheckBoxFech = new javax.swing.JCheckBox();
        labelFecha = new javax.swing.JLabel();
        JDFecha = new com.toedter.calendar.JDateChooser();
        CheckBoxTodos = new javax.swing.JCheckBox();
        CheckBoxEntregados = new javax.swing.JCheckBox();
        CheckBoxPendients = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        labelOrden = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        CheckBoxNoOrden.setText("# Orden");
        CheckBoxNoOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxNoOrdenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Buscar Por:");

        txtNoOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOrdenActionPerformed(evt);
            }
        });

        CheckBoxNit.setText("NIT");
        CheckBoxNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxNitActionPerformed(evt);
            }
        });

        labelNit.setText("NIT:");

        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });

        CheckBoxArt.setText("Articulo");
        CheckBoxArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxArtActionPerformed(evt);
            }
        });

        labelArti.setText("Articulo:");

        cbArti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CheckBoxMarc.setText("Marca");
        CheckBoxMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxMarcActionPerformed(evt);
            }
        });

        cbMarc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelMarca.setText("Marca:");

        CheckBoxFech.setText("Fecha");
        CheckBoxFech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxFechActionPerformed(evt);
            }
        });

        labelFecha.setText("Fecha:");

        buttonGroupTipoOrden.add(CheckBoxTodos);
        CheckBoxTodos.setSelected(true);
        CheckBoxTodos.setText("Todos");

        buttonGroupTipoOrden.add(CheckBoxEntregados);
        CheckBoxEntregados.setText("Entregado");

        buttonGroupTipoOrden.add(CheckBoxPendients);
        CheckBoxPendients.setText("Pendientes");
        CheckBoxPendients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxPendientsActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelOrden.setText("No. Orden:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        jLabel2.setText("Presione Enter sobre los campos a buscar para verificar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelArti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbArti, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMarc, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CheckBoxTodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CheckBoxEntregados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CheckBoxPendients)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CheckBoxNoOrden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxNit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxArt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxFech)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxMarc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxNoOrden)
                    .addComponent(CheckBoxNit)
                    .addComponent(CheckBoxArt)
                    .addComponent(CheckBoxFech)
                    .addComponent(CheckBoxMarc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelArti)
                            .addComponent(cbArti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMarca)
                            .addComponent(cbMarc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelOrden)
                        .addComponent(labelNit)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CheckBoxTodos)
                        .addComponent(CheckBoxEntregados)
                        .addComponent(CheckBoxPendients))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBoxNoOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxNoOrdenActionPerformed
        if (CheckBoxNoOrden.isSelected()) {
            labelOrden.setVisible(true);
            txtNoOrden.setVisible(true);
        }else{
            labelOrden.setVisible(false);
            txtNoOrden.setVisible(false);
        }
    }//GEN-LAST:event_CheckBoxNoOrdenActionPerformed

    private void CheckBoxNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxNitActionPerformed
        if (CheckBoxNit.isSelected()) {
            labelNit.setVisible(true);
            txtNit.setVisible(true);
        }else{
            labelNit.setVisible(false);
            txtNit.setVisible(false);
        }
    }//GEN-LAST:event_CheckBoxNitActionPerformed

    private void CheckBoxArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxArtActionPerformed
        if (CheckBoxArt.isSelected()) {
            cbArti.setVisible(true);
            labelArti.setVisible(true);
        }else{
            cbArti.setVisible(false);
            labelArti.setVisible(false);
        }
    }//GEN-LAST:event_CheckBoxArtActionPerformed

    private void CheckBoxMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxMarcActionPerformed
        if (CheckBoxMarc.isSelected()) {
            cbMarc.setVisible(true);
            labelMarca.setVisible(true);
        }else{
            cbMarc.setVisible(false);
            labelMarca.setVisible(false);
        }
    }//GEN-LAST:event_CheckBoxMarcActionPerformed

    private void CheckBoxFechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxFechActionPerformed
        if (CheckBoxFech.isSelected()) {
            JDFecha.setVisible(true);
            labelFecha.setVisible(true);
        }else{
            JDFecha.setVisible(false);
            labelFecha.setVisible(false);
        }
    }//GEN-LAST:event_CheckBoxFechActionPerformed

    private void CheckBoxPendientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxPendientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxPendientsActionPerformed

    private void txtNoOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOrdenActionPerformed
        BuscarNoOrden();
    }//GEN-LAST:event_txtNoOrdenActionPerformed

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        BuscarNit();
    }//GEN-LAST:event_txtNitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        comparar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxArt;
    private javax.swing.JCheckBox CheckBoxEntregados;
    private javax.swing.JCheckBox CheckBoxFech;
    private javax.swing.JCheckBox CheckBoxMarc;
    private javax.swing.JCheckBox CheckBoxNit;
    private javax.swing.JCheckBox CheckBoxNoOrden;
    private javax.swing.JCheckBox CheckBoxPendients;
    private javax.swing.JCheckBox CheckBoxTodos;
    private com.toedter.calendar.JDateChooser JDFecha;
    private javax.swing.ButtonGroup buttonGroupTipoOrden;
    private javax.swing.JComboBox<String> cbArti;
    private javax.swing.JComboBox<String> cbMarc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelArti;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNit;
    private javax.swing.JLabel labelOrden;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNoOrden;
    // End of variables declaration//GEN-END:variables
}
