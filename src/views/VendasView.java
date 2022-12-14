/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import connection.ConnectionFactory;
import java.util.Vector;
import model.dao.VendasDAO;
import model.bean.Vendas;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Brunobhs18
 */
public class VendasView extends javax.swing.JFrame {

    /**
     * Creates new form Vendas
     */
    public VendasView() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        tblVendas.setRowSorter(new TableRowSorter(modelo));
        restaurarCombobox1();
        restaurarCombobox2();
        readVendasView();
    }

    public void readVendasView() {
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        modelo.setNumRows(0);
        VendasDAO vdao = new VendasDAO();

        for (Vendas v : vdao.read()) {
            modelo.addRow(new Object[]{
                v.getId(),
                v.getClientev(),
                v.getProdutov() + ", " + v.getTamanho() + ", " + v.getCor(),
                v.getQuant(),
                v.getFormapgt(),
                v.getVezes(),
                v.getValorrb(),
                v.getDesconto(),
                v.getData()
            });
        }

    }

    public void readVendasViewForBusca(String bus) {
        DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
        modelo.setNumRows(0);
        VendasDAO vdao = new VendasDAO();

        for (Vendas v : vdao.readBusca(bus)) {
            modelo.addRow(new Object[]{
                v.getId(),
                v.getClientev(),
                v.getProdutov() + ", " + v.getTamanho() + ", " + v.getCor(),
                v.getQuant(),
                v.getFormapgt(),
                v.getVezes(),
                v.getValorrb(),
                v.getDesconto(),
                v.getData()
            });
        }

    }

    Vector<Integer> obj1 = new Vector<Integer>();

    public void restaurarCombobox1() {
        try {
            VendasDAO objnomec = new VendasDAO();
            ResultSet rs = objnomec.listaCliente();
            while (rs.next()) {
                obj1.addElement(rs.getInt(1));
                boxNomeCli.addItem(rs.getNString(2));
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar " + erro);
        }
    }

    Vector<Integer> obj2 = new Vector<Integer>();
    Vector<Integer> obj3 = new Vector<Integer>();

    public void restaurarCombobox2() {
        try {
            VendasDAO objnomeprod = new VendasDAO();
            ResultSet rs = objnomeprod.listaProduto();
            while (rs.next()) {
                obj2.addElement(rs.getInt(1));
                obj3.addElement(rs.getInt(4));
                boxNomeProd.addItem(rs.getNString(3) + ", " + rs.getNString(5) + ", " + rs.getNString(6));
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar " + erro);
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

        jLabel4 = new javax.swing.JLabel();
        boxNomeProd = new javax.swing.JComboBox<>();
        btnAddV = new javax.swing.JButton();
        txtFormapgt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValorrb = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spiQuant = new javax.swing.JSpinner();
        boxNomeCli = new javax.swing.JComboBox<>();
        spiVezes = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNVenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        boxNomeProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        boxNomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNomeProdActionPerformed(evt);
            }
        });
        getContentPane().add(boxNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 57, 376, 30));

        btnAddV.setText("Adicionar");
        btnAddV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddV, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 135, -1, -1));

        txtFormapgt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtFormapgt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Forma de Pagamento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("x Vezes:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 60, -1));

        txtValorrb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtValorrb, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 150, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("VENDAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 6, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Desconto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Produto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        spiQuant.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(spiQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, -1));

        boxNomeCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        boxNomeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNomeCliActionPerformed(evt);
            }
        });
        getContentPane().add(boxNomeCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 56, 240, 27));

        spiVezes.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(spiVezes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 50, -1));

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N?? Venda", "Cliente", "Produto", "Quantidade", "Forma Pgto", "x Vezes", "Valor Recebido", "Desconto", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVendas.getTableHeader().setReorderingAllowed(false);
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        tblVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblVendasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, 973, 387));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 135, -1, -1));

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 135, -1, -1));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 135, -1, -1));

        txtBusca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 132, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Valor Recebido:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));
        getContentPane().add(txtDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 130, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Nome do Produto:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("N?? da  Venda:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtNVenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNVenda.setText("0");
        getContentPane().add(txtNVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 20, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void boxNomeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNomeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNomeProdActionPerformed

    private void boxNomeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNomeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNomeCliActionPerformed

    private void btnAddVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVActionPerformed
        // TODO add your handling code here:
        String d;
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        d = sdf.format(data).toString();
        int codn, codp, q, t, resP;
        double vlr;
        codn = obj1.get(boxNomeCli.getSelectedIndex() - 1);
        codp = obj2.get(boxNomeProd.getSelectedIndex() - 1);
        q = obj3.get(boxNomeProd.getSelectedIndex() - 1);
        t = (int) spiQuant.getValue();

        resP = q - t;
        vlr = 0.00;

        Vendas v = new Vendas();
        VendasDAO vdao = new VendasDAO();
        v.setCodcli(codn);
        v.setCodp(codp);
        v.setQuant(Integer.parseInt(spiQuant.getValue().toString()));
        v.setFormapgt(txtFormapgt.getText());
        v.setVezes(Integer.parseInt(spiVezes.getValue().toString()));
        if (txtValorrb.getText().isEmpty()) {
            v.setValorrb(vlr);
        } else {
            v.setValorrb(Double.parseDouble(txtValorrb.getText()));
        }
        if (txtDesconto.getText().isEmpty()) {
            v.setDesconto(vlr);
        } else {
            v.setDesconto(Double.parseDouble(txtDesconto.getText()));
        }
        v.setQtdProd(resP);
        v.setData(d);
        if (resP < 0) {
            JOptionPane.showMessageDialog(this, "Quantidade de produto insuficiente!");
        } else {
            vdao.create(v);
            vdao.updateprod(v);
        }

        txtFormapgt.setText("");
        txtValorrb.setText("");
        txtDesconto.setText("");

        readVendasView();

    }//GEN-LAST:event_btnAddVActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tblVendas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Favor selecionar uma linha valida!");
        } else {
            DefaultTableModel tabelaVendas = (DefaultTableModel) tblVendas.getModel();
            int i = JOptionPane.showConfirmDialog(this, "Deseja excluir essa linha?", "Confirma????o", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                Vendas v = new Vendas();
                VendasDAO vdao = new VendasDAO();
                v.setId((int) tblVendas.getValueAt(tblVendas.getSelectedRow(), 0));
                vdao.delete(v);

                txtFormapgt.setText("");
                txtValorrb.setText("");
                txtDesconto.setText("");
                readVendasView();

                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (tblVendas.getSelectedRow() != -1) {
            String d;
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            d = sdf.format(data).toString();
            int codn, codp, q, t, resP;
            double vlr;
            codn = obj1.get(boxNomeCli.getSelectedIndex() - 1);
            codp = obj2.get(boxNomeProd.getSelectedIndex() - 1);
            q = obj3.get(boxNomeProd.getSelectedIndex() - 1);
            t = (int) spiQuant.getValue();

            resP = q - t;
            vlr = 0.00;

            Vendas v = new Vendas();
            VendasDAO vdao = new VendasDAO();
            v.setCodcli(codn);
            v.setCodp(codp);
            v.setQuant(Integer.parseInt(spiQuant.getValue().toString()));
            v.setFormapgt(txtFormapgt.getText());
            v.setVezes(Integer.parseInt(spiVezes.getValue().toString()));
            if (txtValorrb.getText().isEmpty()) {
                v.setValorrb(vlr);
            } else {
                v.setValorrb(Double.parseDouble(txtValorrb.getText()));
            }
            if (txtDesconto.getText().isEmpty()) {
                v.setDesconto(vlr);
            } else {
                v.setDesconto(Double.parseDouble(txtDesconto.getText()));
            }
            v.setQtdProd(resP);
            v.setData(d);
            v.setId((int)tblVendas.getValueAt(tblVendas.getSelectedRow(), 0));
            if (resP < 0) {
                JOptionPane.showMessageDialog(this, "Quantidade de produto insuficiente!");
            } else {
                vdao.update(v);
                vdao.updateprod(v);
            }

                txtFormapgt.setText("");
                txtValorrb.setText("");
                txtDesconto.setText("");

                readVendasView();
            }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        readVendasViewForBusca(txtBusca.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        // TODO add your handling code here:
        if (tblVendas.getSelectedRow() != -1) {
            txtNVenda.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 0).toString());
            boxNomeCli.setSelectedItem(tblVendas.getValueAt(tblVendas.getSelectedRow(), 1).toString());
            boxNomeProd.setSelectedItem(tblVendas.getValueAt(tblVendas.getSelectedRow(), 2).toString());
            spiQuant.setValue(tblVendas.getValueAt(tblVendas.getSelectedRow(), 3));
            txtFormapgt.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 4).toString());
            spiVezes.setValue(tblVendas.getValueAt(tblVendas.getSelectedRow(), 5));
            txtValorrb.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 6).toString());
            txtDesconto.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 7).toString());

        }
    }//GEN-LAST:event_tblVendasMouseClicked

    private void tblVendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVendasKeyReleased
        // TODO add your handling code here:
        if (tblVendas.getSelectedRow() != -1) {
            txtNVenda.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 0).toString());
            boxNomeCli.setSelectedItem(tblVendas.getValueAt(tblVendas.getSelectedRow(), 1).toString());
            boxNomeProd.setSelectedItem(tblVendas.getValueAt(tblVendas.getSelectedRow(), 2).toString());
            spiQuant.setValue(tblVendas.getValueAt(tblVendas.getSelectedRow(), 3));
            txtFormapgt.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 4).toString());
            spiVezes.setValue(tblVendas.getValueAt(tblVendas.getSelectedRow(), 5));
            txtValorrb.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 6).toString());
            txtDesconto.setText(tblVendas.getValueAt(tblVendas.getSelectedRow(), 7).toString());

        }
    }//GEN-LAST:event_tblVendasKeyReleased

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
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxNomeCli;
    private javax.swing.JComboBox<String> boxNomeProd;
    private javax.swing.JButton btnAddV;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spiQuant;
    private javax.swing.JSpinner spiVezes;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtFormapgt;
    private javax.swing.JLabel txtNVenda;
    private javax.swing.JTextField txtValorrb;
    // End of variables declaration//GEN-END:variables
}
