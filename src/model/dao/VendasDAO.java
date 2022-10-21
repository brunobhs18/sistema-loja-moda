/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.bean.Vendas;
import model.bean.Cliente;
import model.bean.Produto;
/**
 *
 * @author Brunobhs18
 */
public class VendasDAO {
    public void create(Vendas v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO vendas (codcliv,codprodv,quantidadev,formapagamento,vezes,valorrecebido,desconto,datav) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, v.getCodcli());
            stmt.setInt(2, v.getCodp());
            stmt.setInt(3, v.getQuant());
	    stmt.setString(4, v.getFormapgt());
            stmt.setInt(5, v.getVezes());
	    stmt.setDouble(6, v.getValorrb());
	    stmt.setDouble(7, v.getDesconto());
            stmt.setString(8, v.getData());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Vendas> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendas> vendas = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM vw_vendas");
           rs = stmt.executeQuery();
           while(rs.next()){
               Vendas v = new Vendas();
               v.setCodcli(rs.getInt("codcli"));
               v.setClientev(rs.getNString("nomecli"));
               v.setCodp(rs.getInt("cod"));
               v.setProdutov(rs.getNString("nomeprod"));
               v.setQtdProd(rs.getInt("quantidade"));
               v.setTamanho(rs.getNString("tamanho"));
               v.setCor(rs.getNString("cor"));
               v.setId(rs.getInt("id"));
               v.setCodcliv(rs.getInt("codcliv"));
               v.setCodprodv(rs.getInt("codprodv"));
               v.setQuant(rs.getInt("quantidadev"));
               v.setFormapgt(rs.getNString("formapagamento"));
	       v.setVezes(rs.getInt("vezes"));
	       v.setValorrb(rs.getDouble("valorrecebido"));
               v.setDesconto(rs.getDouble("desconto"));
               v.setValorvdp(rs.getDouble("valorvenda"));
	       v.setData(rs.getNString("datav"));
               vendas.add(v);
           }

       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return vendas;
    }
    
    public void update(Vendas v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE vendas SET codcliv = ?, codprodv = ?, quantidadev = ?, "
                    + "formapagamento = ?, vezes = ?, valorrecebido = ?, desconto = ?, datav = ? WHERE id = ?");
            stmt.setInt(1, v.getCodcli());
            stmt.setInt(2, v.getCodp());
            stmt.setInt(3, v.getQuant());
	    stmt.setString(4, v.getFormapgt());
            stmt.setInt(5, v.getVezes());
	    stmt.setDouble(6, v.getValorrb());
            stmt.setDouble(7, v.getDesconto());
	    stmt.setString(8, v.getData());
	    stmt.setInt(9, v.getId());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Vendas v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM vendas WHERE id = ?");
            stmt.setInt(1, v.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exluido com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Vendas> readBusca(String bus){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendas> vendas = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM vw_vendas WHERE nomeprod LIKE ?");
           stmt.setString(1, "%"+bus+"%");
           rs = stmt.executeQuery();
           while(rs.next()){
               Vendas v = new Vendas();
               v.setCodcli(rs.getInt("codcli"));
               v.setClientev(rs.getNString("nomecli"));
               v.setCodp(rs.getInt("cod"));
               v.setProdutov(rs.getNString("nomeprod"));
               v.setQtdProd(rs.getInt("quantidade"));
               v.setTamanho(rs.getNString("tamanho"));
               v.setCor(rs.getNString("cor"));
               v.setId(rs.getInt("id"));
               v.setCodcliv(rs.getInt("codcliv"));
               v.setCodprodv(rs.getInt("codprodv"));
               v.setQuant(rs.getInt("quantidadev"));
               v.setFormapgt(rs.getNString("formapagamento"));
	       v.setVezes(rs.getInt("vezes"));
	       v.setValorrb(rs.getDouble("valorrecebido"));
               v.setDesconto(rs.getDouble("desconto"));
	       v.setData(rs.getNString("datav"));
               vendas.add(v);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fazer a busca "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return vendas;
    }
    
    public ResultSet listaCliente(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
                
       try { 
           stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY nomecli");
           rs = stmt.executeQuery();
           }
           
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao listar"+ex);
       
       }
        return rs;
    }
    
    public ResultSet listaProduto(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
                
       try { 
           stmt = con.prepareStatement("SELECT * FROM produtos ORDER BY nomeprod");
           rs = stmt.executeQuery();
           }
           
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao listar"+ex);
       
       }
        return rs;
    }  
    
        public void updateprod(Vendas p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET quantidade = ?  WHERE cod = ?");
            stmt.setInt(1, p.getQtdProd());
            stmt.setInt(2, p.getCodp());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 

           
}
