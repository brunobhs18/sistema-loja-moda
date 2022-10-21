/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connection.ConnectionFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import model.dao.VendasDAO;
import model.bean.Vendas;
/**
 *
 * @author Brunobhs18
 */
public class RelatorioNomeView extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioNomeView
     */
    public RelatorioNomeView() {
        initComponents();
    }
    
       private void gerarPDF(){
	Connection con = ConnectionFactory.getConnection();
	Document doc = new Document();
        VendasDAO vdao = new VendasDAO();
	String arquivoPdf = "relatorioVendasaPrazoNome.pdf";
	String a, b;

	try{
		PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
                doc.open();

		Paragraph p = new Paragraph(new Phrase (10F, "Relatório Vendas", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
		p.setAlignment(1);
		doc.add(p);
		p = new Paragraph("  ");
		doc.add(p);

		PdfPTable table = new PdfPTable(8);
		
		PdfPCell cel1 = new PdfPCell(new Paragraph(new Phrase(2F, "Cliente", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel2 = new PdfPCell(new Paragraph(new Phrase(2F, "Produto", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel3 = new PdfPCell(new Paragraph(new Phrase(2F, "Qtde", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel4 = new PdfPCell(new Paragraph(new Phrase(2F, "Valor Prod.", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel5 = new PdfPCell(new Paragraph(new Phrase(2F, "Valor Rec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel6 = new PdfPCell(new Paragraph(new Phrase(2F, "Valor Total", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
                PdfPCell cel7 = new PdfPCell(new Paragraph(new Phrase(2F, "Falta Rec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		PdfPCell cel8 = new PdfPCell(new Paragraph(new Phrase(2F, "Data", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
		

		table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel8).setHorizontalAlignment(Element.ALIGN_CENTER);
		

		for(Vendas v: vdao.read()){
			cel1 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getClientev() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel2 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getProdutov()+", "+v.getTamanho()+", "+v.getCor()+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel3 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getQuant()+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel4 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getValorvdp()+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel5 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getValorrb()+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel6 = new PdfPCell(new Paragraph(new Phrase(2F, ((v.getQuant() * v.getValorvdp())+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                        cel7 = new PdfPCell(new Paragraph(new Phrase(2F, (((v.getQuant() * v.getValorvdp())- v.getValorrb())+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			cel8 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getData()+""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
			
		a = txtNome.getText();
                b = v.getClientev();

		if(a.equals(b)) {
		table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel8).setHorizontalAlignment(Element.ALIGN_CENTER);
		    }

		}
                doc.add(table);
                doc.close();
                Desktop.getDesktop().open(new File(arquivoPdf));
		
	} catch (Exception e){
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

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Digite o Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
       gerarPDF();
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioNomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioNomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioNomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioNomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioNomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
