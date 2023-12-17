/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.VoucherServicerImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Voucher;
import repository.VoucherService;

/**
 *
 * @author vuhoa
 */
public class VouCherInHoaDon extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    VoucherService serviceVouCherHoaDon = new VoucherServicerImpl();
    List<Voucher> listVouCher = new ArrayList<>();
    public static int idVouCher = 0;

    public VouCherInHoaDon() {
        initComponents();
        dtm = (DefaultTableModel) tbVouCher.getModel();
        listVouCher = serviceVouCherHoaDon.listAll();
        showTableVouCher();
    }

    public void showTableVouCher() {
        dtm.setRowCount(0);
        int index = 1;
        for (Voucher v : listVouCher) {
            dtm.addRow(new Object[]{
                index,
                v.getMaVoucher(),
                v.getPhanTram(),});
            index++;
        }
    }

//    public void showIndexVouCher(int index) {
//        listVouCher = serviceVouCherHoaDon.listAll();
//        Voucher vc = listVouCher.get(index);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimTenVouCher = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVouCher = new javax.swing.JTable();
        bthChon = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setText("Ten VouCher :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Danh Sách VouCher");

        txtTimTenVouCher.setBackground(new java.awt.Color(0, 204, 255));
        txtTimTenVouCher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        tbVouCher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã", "% GIẢM"
            }
        ));
        tbVouCher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVouCherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVouCher);

        bthChon.setText("Chọn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(txtTimTenVouCher, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bthChon)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(150, 150, 150))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimTenVouCher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthChon))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
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

    private void tbVouCherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVouCherMouseClicked
        int index = tbVouCher.getSelectedRow();
        int idVouCherInTable = listVouCher.get(index).getId();
        System.out.println(idVouCherInTable);
        idVouCher = idVouCherInTable;
    }//GEN-LAST:event_tbVouCherMouseClicked

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
            java.util.logging.Logger.getLogger(VouCherInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VouCherInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VouCherInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VouCherInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VouCherInHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthChon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVouCher;
    private javax.swing.JTextField txtTimTenVouCher;
    // End of variables declaration//GEN-END:variables
}
