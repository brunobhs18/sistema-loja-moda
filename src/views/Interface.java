/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;
import connection.ConnectionFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Despesas;
import model.bean.Fornecedor;
import model.bean.Produto;
import model.bean.Vendas;
import model.dao.ClienteDAO;
import model.dao.DespesasDAO;
import model.dao.FornecedorDAO;
import model.dao.ProdutoDAO;
import model.dao.VendasDAO;

/**
 *
 * @author Brunobhs18
 */
public class Interface extends javax.swing.JFrame {

    Connection con = null;

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        con = ConnectionFactory.getConnection();
        readProdutoView();

    }

    private static void gerarPDF() {
        Connection con = ConnectionFactory.getConnection();
        Document doc = new Document();
        FornecedorDAO pdao = new FornecedorDAO();
        String arquivoPdf = "relatorioFornecedores.pdf";

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
            doc.open();
            doc.setPageSize(PageSize.A4);
            doc.setMargins(40f, 40f, 40f, 40f);

            Paragraph p = new Paragraph(new Phrase (10F, "Relatório Fornecedores", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("  ");
            doc.add(p);

            PdfPTable table = new PdfPTable(3);

            PdfPCell cel1 = new PdfPCell(new Paragraph (new Phrase(2F, "Nome", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel2 = new PdfPCell(new Paragraph (new Phrase(2F, "Endereço", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel3 = new PdfPCell(new Paragraph(new Phrase(2F, "Contato", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));

            table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);

            for (Fornecedor f : pdao.read()) {
                cel1 = new PdfPCell(new Paragraph(new Phrase(2F, (f.getNomefor() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel2 = new PdfPCell(new Paragraph(new Phrase(2F, (f.getEnderecofor() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel3 = new PdfPCell(new Paragraph(2F, (f.getContatofor() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F)));

                table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);

            }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(arquivoPdf));

        } catch (Exception e) {
        }

    }

    private static void gerarPDF1() {
        Connection con = ConnectionFactory.getConnection();
        Document doc = new Document();
        ProdutoDAO pdao = new ProdutoDAO();
        String arquivoPdf = "relatorioProdutos.pdf";

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
            doc.open();

            Paragraph par = new Paragraph(new Phrase (10F, "Relatório Produtos", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
            par.setAlignment(1);
            doc.add(par);
            par = new Paragraph("  ");
            doc.add(par);

            PdfPTable table = new PdfPTable(7);

            PdfPCell cel1 = new PdfPCell(new Paragraph(new Phrase(2F, "Codigo", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel2 = new PdfPCell(new Paragraph(new Phrase(2F, "Nome", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel3 = new PdfPCell(new Paragraph(new Phrase(2F, "Fornecedor", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel4 = new PdfPCell(new Paragraph(new Phrase(2F, "Qtde", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel5 = new PdfPCell(new Paragraph(new Phrase(2F, "Tamanho", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel6 = new PdfPCell(new Paragraph(new Phrase(2F, "Cor", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel7 = new PdfPCell(new Paragraph(new Phrase(2F, "Valor Compra", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));

            table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);

            for (Produto p : pdao.read()) {
                cel1 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getCod() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel2 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getNomeprod() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel3 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getFornecedorp() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel4 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getQtd() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel5 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getTamanho() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel6 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getCor() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel7 = new PdfPCell(new Paragraph(new Phrase(2F, (p.getValorcp() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));

                table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);

            }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(arquivoPdf));

        } catch (Exception e) {
        }

    }

    private static void gerarPDF2() {
        Connection con = ConnectionFactory.getConnection();
        Document doc = new Document();
        ClienteDAO cdao = new ClienteDAO();
        String arquivoPdf = "relatorioClientes.pdf";

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
            doc.open();

            Paragraph p = new Paragraph(new Phrase (10F, "Relatório Clientes", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("  ");
            doc.add(p);

            PdfPTable table = new PdfPTable(3);

            PdfPCell cel1 = new PdfPCell(new Paragraph(new Phrase(2F, "Nome", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel2 = new PdfPCell(new Paragraph(new Phrase(2F, "Endereço", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel3 = new PdfPCell(new Paragraph(new Phrase(2F, "Contato", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));

            table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);

            for (Cliente c : cdao.read()) {
                cel1 = new PdfPCell(new Paragraph(new Phrase(2F, (c.getNomecli() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel2 = new PdfPCell(new Paragraph(new Phrase(2F, (c.getEnderecocli() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel3 = new PdfPCell(new Paragraph(new Phrase(2F, (c.getContatocli() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));

                table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);

            }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(arquivoPdf));

        } catch (Exception e) {
        }

    }

    private static void gerarPDF3() {
        Connection con = ConnectionFactory.getConnection();
        Document doc = new Document();
        VendasDAO vdao = new VendasDAO();
        String arquivoPdf = "relatorioVendas.pdf";

        try {
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
            PdfPCell cel4 = new PdfPCell(new Paragraph(new Phrase(2F, "Forma Pgto.", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel5 = new PdfPCell(new Paragraph(new Phrase(2F, "Vezes", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel6 = new PdfPCell(new Paragraph(new Phrase(2F, "Valor Rec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel7 = new PdfPCell(new Paragraph(new Phrase(2F, "Desconto", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));
            PdfPCell cel8 = new PdfPCell(new Paragraph(new Phrase(2F, "Data", FontFactory.getFont(FontFactory.TIMES_BOLD, 11F))));

            table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel8).setHorizontalAlignment(Element.ALIGN_CENTER);

            for (Vendas v : vdao.read()) {
                cel1 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getClientev() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel2 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getProdutov() + ", " + v.getTamanho() + ", " + v.getCor() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel3 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getQuant() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel4 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getFormapgt() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel5 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getVezes() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel6 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getValorrb() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel7 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getDesconto() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));
                cel8 = new PdfPCell(new Paragraph(new Phrase(2F, (v.getData() + ""), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9F))));

                table.addCell(cel1).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel2).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel3).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel4).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel5).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel6).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel7).setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cel8).setHorizontalAlignment(Element.ALIGN_CENTER);

            }
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File(arquivoPdf));

        } catch (Exception e) {
        }

    }
    
       private static void gerarPDF4(){
	Connection con = ConnectionFactory.getConnection();
	Document doc = new Document();
        VendasDAO vdao = new VendasDAO();
	String arquivoPdf = "relatorioVendasaPrazo.pdf";
	double a, b, c, d;

	try{
		PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
                doc.open();

		Paragraph p = new Paragraph(new Phrase (10F, "Relatório Vendas à Prazo", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
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
			
		a = v.getValorrb();
		b = v.getDesconto();
		c = v.getValorvdp();
		d = c - (a + b);	

		if(d != 0) {
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
       
 public void readProdutoView(){
        DefaultListModel modelo = new DefaultListModel();
	listProdSEstoque.setVisible(false);
	listProdSEstoque.setModel(modelo);
        int a;
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        for(Produto p: pdao.read()) {
            a = p.getQtd();
            if(a == 0){
            modelo.addElement(
           "Cod " + p.getCod() + " - " + 
            p.getNomeprod() + " - " + 
            p.getFornecedorp()+ " - " + 
            p.getTamanho() + " - " +
            p.getCor() + ""
        );
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProdSEstoque = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnSAtual = new javax.swing.JButton();
        btnSEstoque = new javax.swing.JButton();
        btnProdSEstoque = new javax.swing.JButton();
        txtSaldoEstoque = new javax.swing.JLabel();
        txtSaldoAtual = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFor = new javax.swing.JMenu();
        menuAddFor = new javax.swing.JMenuItem();
        menuRelatorioFor = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenu();
        menuAddPro = new javax.swing.JMenuItem();
        menuRelatorioPro = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAddCliente = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financeiro Chloe");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Saldo Atual:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Saldo em Estoque:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Produtos sem Estoque:");

        jScrollPane1.setViewportView(listProdSEstoque);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/chloe.png"))); // NOI18N

        btnSAtual.setText("Ver");
        btnSAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAtualActionPerformed(evt);
            }
        });

        btnSEstoque.setText("Ver");
        btnSEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEstoqueActionPerformed(evt);
            }
        });

        btnProdSEstoque.setText("Ver");
        btnProdSEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdSEstoqueActionPerformed(evt);
            }
        });

        txtSaldoEstoque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtSaldoAtual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menuFor.setText("Fornecedores");

        menuAddFor.setText("Adicionar");
        menuAddFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddForActionPerformed(evt);
            }
        });
        menuFor.add(menuAddFor);

        menuRelatorioFor.setText("Relatório");
        menuRelatorioFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioForActionPerformed(evt);
            }
        });
        menuFor.add(menuRelatorioFor);

        jMenuBar1.add(menuFor);

        menuProduto.setText("Produtos");
        menuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutoActionPerformed(evt);
            }
        });

        menuAddPro.setText("Adicionar");
        menuAddPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddProActionPerformed(evt);
            }
        });
        menuProduto.add(menuAddPro);

        menuRelatorioPro.setText("Relatório Estoque");
        menuRelatorioPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioProActionPerformed(evt);
            }
        });
        menuProduto.add(menuRelatorioPro);

        jMenuBar1.add(menuProduto);

        jMenu3.setText("Clientes");

        menuAddCliente.setText("Adicionar");
        menuAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuAddCliente);

        jMenuItem6.setText("Relatório");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Vendas");

        jMenuItem7.setText("Adicionar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Relatório");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Relatório a Prazo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem1.setText("Relatório por Nome");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Despesas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Adicionar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(btnSEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSaldoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnProdSEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnProdSEstoque)
                    .addComponent(btnSAtual)
                    .addComponent(btnSEstoque))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSaldoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAddForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddForActionPerformed
        // TODO add your handling code here:
        FornecedorView f1 = new FornecedorView();
        f1.setVisible(true);
    }//GEN-LAST:event_menuAddForActionPerformed

    private void menuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuProdutoActionPerformed

    private void menuAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddClienteActionPerformed
        // TODO add your handling code here:
        ClienteView c1 = new ClienteView();
        c1.setVisible(true);
    }//GEN-LAST:event_menuAddClienteActionPerformed

    private void menuAddProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddProActionPerformed
        // TODO add your handling code here:
        ProdutoView p1 = new ProdutoView();
        p1.setVisible(true);
    }//GEN-LAST:event_menuAddProActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        VendasView v1 = new VendasView();
        v1.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menuRelatorioForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioForActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja gerar esse Relatorio?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            gerarPDF();
        }
    }//GEN-LAST:event_menuRelatorioForActionPerformed

    private void menuRelatorioProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioProActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja gerar esse Relatorio?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            gerarPDF1();
        }
    }//GEN-LAST:event_menuRelatorioProActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja gerar esse Relatorio?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            gerarPDF2();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja gerar esse Relatorio?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            gerarPDF3();
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Deseja gerar esse Relatorio?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            gerarPDF4();
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnSEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEstoqueActionPerformed
        // TODO add your handling code here:
        double s = 0;
        String saldo;
        ProdutoDAO pdao = new ProdutoDAO();
        
        for(Produto p: pdao.read()) {
            s += (p.getValorcp()* p.getQtd());            
        }
        saldo = "R$ " + s + " ";
        txtSaldoEstoque.setText(saldo);
    }//GEN-LAST:event_btnSEstoqueActionPerformed

    private void btnProdSEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdSEstoqueActionPerformed
        // TODO add your handling code here:
        listProdSEstoque.setVisible(true);
        
    }//GEN-LAST:event_btnProdSEstoqueActionPerformed

    private void btnSAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAtualActionPerformed
        // TODO add your handling code here:
        double s = 0;
        double v1 = 0;
        double d1 = 0;
        double t;
        String saldo;
        ProdutoDAO pdao = new ProdutoDAO();
        VendasDAO vdao = new VendasDAO();
        DespesasDAO ddao = new DespesasDAO();
        
        for(Produto p: pdao.read()) {
            s += (p.getValorcp()* p.getQtd());            
        }
              
        
        for(Vendas v: vdao.read()){
            v1 +=(v.getValorrb());
        }
        
        for(Despesas d: ddao.read()){
            d1 += (d.getValorD());
        }
        
        t = v1 - s - d1;
        saldo = "R$ " + t + " ";
        
        txtSaldoAtual.setText(saldo);
        
    }//GEN-LAST:event_btnSAtualActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        RelatorioNomeView r1 = new RelatorioNomeView();
        r1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DespesasView desp = new DespesasView();
        desp.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProdSEstoque;
    private javax.swing.JButton btnSAtual;
    private javax.swing.JButton btnSEstoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listProdSEstoque;
    private javax.swing.JMenuItem menuAddCliente;
    private javax.swing.JMenuItem menuAddFor;
    private javax.swing.JMenuItem menuAddPro;
    private javax.swing.JMenu menuFor;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenuItem menuRelatorioFor;
    private javax.swing.JMenuItem menuRelatorioPro;
    private javax.swing.JLabel txtSaldoAtual;
    private javax.swing.JLabel txtSaldoEstoque;
    // End of variables declaration//GEN-END:variables
}
