/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Despesas;
import model.dao.DespesasDAO;

/**
 *
 * @author Brunobhs18
 */
public class DespesasView extends javax.swing.JFrame {

    /**
     * Creates new form DespesasView
     */
    public DespesasView() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblDespesas.getModel();
        tblDespesas.setRowSorter(new TableRowSorter(modelo));
        readDespesasView();

    }

    public void readDespesasView() {
        DefaultTableModel modelo = (DefaultTableModel) tblDespesas.getModel();
        modelo.setNumRows(0);
        DespesasDAO ddao = new DespesasDAO();

        for (Despesas d : ddao.read()) {
            modelo.addRow(new Object[]{
                d.getTipo(),
                d.getValorD(),
                d.getData()
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDespesas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtValorD = new javax.swing.JTextField();
        txtDataD = new javax.swing.JTextField();
        btnAddD = new javax.swing.JToggleButton();
        btnAlterarD = new javax.swing.JToggleButton();
        btnExcluirD = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());

        tblDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Valor", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDespesasMouseClicked(evt);
            }
        });
        tblDespesas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDespesasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDespesas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Despesas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Valor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Data:");

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        btnAddD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddD.setText("Adicionar");
        btnAddD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDActionPerformed(evt);
            }
        });

        btnAlterarD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterarD.setText("Alterar");
        btnAlterarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDActionPerformed(evt);
            }
        });

        btnExcluirD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluirD.setText("Excluir");
        btnExcluirD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddD)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarD)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirD)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtValorD, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtDataD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddD)
                    .addComponent(btnAlterarD)
                    .addComponent(btnExcluirD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void btnAddDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDActionPerformed
        // TODO add your handling code here:
        Despesas d = new Despesas();
        DespesasDAO ddao = new DespesasDAO();
        d.setTipo(txtTipo.getText());
        d.setValorD(Double.parseDouble(txtValorD.getText()));
        d.setData(txtDataD.getText());
        ddao.create(d);

        txtTipo.setText("");
        txtValorD.setText("");
        txtDataD.setText("");

        readDespesasView();

    }//GEN-LAST:event_btnAddDActionPerformed

    private void btnExcluirDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tblDespesas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Favor selecionar uma linha valida!");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) tblDespesas.getModel();
            int i = JOptionPane.showConfirmDialog(this, "Deseja excluir essa linha?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                Despesas d = new Despesas();
                DespesasDAO ddao = new DespesasDAO();
                d.setTipo(txtTipo.getText());
                ddao.delete(d);

                txtTipo.setText("");
                txtValorD.setText("");
                txtDataD.setText("");

                readDespesasView();

                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
            }
        }
    }//GEN-LAST:event_btnExcluirDActionPerformed

    private void btnAlterarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tblDespesas.getSelectedRow();
        if (linhaSelecionada != -1) {
            Despesas d = new Despesas();
            DespesasDAO ddao = new DespesasDAO();
            d.setTipo(txtTipo.getText());
            d.setValorD(Double.parseDouble(txtValorD.getText()));
            d.setData(txtDataD.getText());
            ddao.update(d);

            txtTipo.setText("");
            txtValorD.setText("");
            txtDataD.setText("");

            readDespesasView();

        }
    }//GEN-LAST:event_btnAlterarDActionPerformed

    private void tblDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDespesasMouseClicked
        // TODO add your handling code here:
        int linhaSelecionada = tblDespesas.getSelectedRow();
        if (linhaSelecionada != -1){
            txtTipo.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 0).toString());
            txtValorD.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 1).toString());
            txtDataD.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 2).toString());

        }
    }//GEN-LAST:event_tblDespesasMouseClicked

    private void tblDespesasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDespesasKeyReleased
        // TODO add your handling code here:
        int linhaSelecionada = tblDespesas.getSelectedRow();
        if (linhaSelecionada != -1){
            txtTipo.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 0).toString());
            txtValorD.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 1).toString());
            txtDataD.setText(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 2).toString());

        }
    }//GEN-LAST:event_tblDespesasKeyReleased

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
            java.util.logging.Logger.getLogger(DespesasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DespesasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DespesasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DespesasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DespesasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAddD;
    private javax.swing.JToggleButton btnAlterarD;
    private javax.swing.JToggleButton btnExcluirD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDespesas;
    private javax.swing.JTextField txtDataD;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValorD;
    // End of variables declaration//GEN-END:variables
}