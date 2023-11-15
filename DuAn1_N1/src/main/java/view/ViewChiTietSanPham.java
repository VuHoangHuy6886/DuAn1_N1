/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.SanPhamServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import model.ChiTietSanPham;
import model.SanPham;
import repository.CrudfullTable;
import repository.SanPhamService;

/**
 *
 * @author vuhoa
 */
public class ViewChiTietSanPham extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelSP = new DefaultTableModel();
    CrudfullTable<ChiTietSanPham> service = new ChiTietSanPhamServiceImpl();
    CrudfullTable<SanPham> serviceSP = new SanPhamServiceImpl();
    List<ChiTietSanPham> listSP = new ArrayList<>();
    List<SanPham> listTenSP = new ArrayList<>();

    public ViewChiTietSanPham() {
        initComponents();
        model = (DefaultTableModel) tbCTSP.getModel();
        listTenSP = serviceSP.listAll();
        showTable(listSP);
        showCombobox();
    }

    public void showTable(List<ChiTietSanPham> listSP) {
        model.setRowCount(0);
        for (ChiTietSanPham ct : listSP) {
            model.addRow(new Object[]{
                ct.getMa(), ct.getTen(), ct.getLoaiSP(), ct.getTenSanXuat(),
                ct.getQuocGia(), ct.getAnh(), ct.gethSD(), ct.getSoLuongTon(),
                ct.getGiaVon(),
                ct.getGiaBan(), ct.getGhiChu(), ct.getTrangThai()

            });
        }
//        for (ChiTietSanPham sp : listSP) {
//            model.addRow(new Object[]{
//                sp.getId(), sp.getTen(),});
//        }
    }

    public void showCombobox() {
        cbbSP.removeAllItems();
        for (SanPham sp : listTenSP) {
            cbbSP.addItem(sp.getTen());
        }
    }

    public ChiTietSanPham showIndex(int index) {
        ChiTietSanPham sp = listSP.get(index);
        //  cbbSP.setSelectedItem(sp.getLoaiSP());
        //  cbbLSP.setSelectedItem(sp.getLoaiSP());
        // Làm sạch model của ComboBox
//        cbbSP.removeAllItems();
//
//        // Thêm các mục mới vào ComboBox
//        cbbSP.addItem(sp.getTen());
//        
//        cbbNSX.removeAllItems();
//        cbbNSX.addItem(sp.getTenSanXuat());
//        
//        cbbLSP.removeAllItems();
//        cbbLSP.addItem(sp.getLoaiSP());
        txtHSD.setText(String.valueOf(sp.gethSD()));
        txtSL.setText(String.valueOf(sp.getSoLuongTon()));
        txtGia.setText(String.valueOf(sp.getGiaBan()));
        txtTT.setText(String.valueOf(sp.getTrangThai()));
        txtGhiChu.setText(sp.getGhiChu());
        return sp;
    }
//    public ChiTietSanPham data(){
//        String ten = cbbSP.getSelectedItem().toString();
//        
//        
//    }
//   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbSP = new javax.swing.JComboBox<>();
        cbbLSP = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtHSD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTSP = new javax.swing.JTable();
        pnAnh = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Sản phẩm");

        jLabel3.setText("Loại Sản Phẩm");

        jLabel4.setText("Nhà Sản Xuất");

        jLabel5.setText("Ảnh");

        cbbSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sữa Bột Vinamilk" }));
        cbbSP.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cbbSPComponentAdded(evt);
            }
        });
        cbbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSPMouseClicked(evt);
            }
        });

        cbbLSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("HSD");

        txtHSD.setText("jTextField1");

        jLabel7.setText("SoLuongTon");

        txtSL.setText("jTextField2");

        jLabel1.setText("Giá Bán");

        txtGia.setText("jTextField3");

        jLabel8.setText("Ghi Chú");

        jLabel9.setText("Trạng Thái");

        txtTT.setText("jTextField4");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        tbCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSP", "TÊN SP", "LOẠI SP", "TÊN NSX", "QUỐC GIA", "ẢNH", "HSD", "Số Lượng Tồn", "Giá Vốn", "Giá Bán", "Ghi Chú", "Trạng Thái"
            }
        ));
        tbCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTSP);

        pnAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnAnhLayout = new javax.swing.GroupLayout(pnAnh);
        pnAnh.setLayout(pnAnhLayout);
        pnAnhLayout.setHorizontalGroup(
            pnAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        pnAnhLayout.setVerticalGroup(
            pnAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        jButton1.setText("thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbSP, 0, 167, Short.MAX_VALUE)
                            .addComponent(cbbLSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(pnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHSD, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(txtSL)
                        .addComponent(txtGia)
                        .addComponent(txtTT))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTSPMouseClicked
        int index = tbCTSP.getSelectedRow();
        showIndex(index);
    }//GEN-LAST:event_tbCTSPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(cbbSP.getSelectedIndex());
        System.out.println(listTenSP.get(cbbSP.getSelectedIndex()).getTen());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbSPComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbbSPComponentAdded
        service.listAll();
    }//GEN-LAST:event_cbbSPComponentAdded

    private void cbbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSPMouseClicked
        
    }//GEN-LAST:event_cbbSPMouseClicked

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
            java.util.logging.Logger.getLogger(ViewChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChiTietSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbLSP;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnAnh;
    private javax.swing.JTable tbCTSP;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTT;
    // End of variables declaration//GEN-END:variables
}