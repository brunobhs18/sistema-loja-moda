/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;

/**
 *
 * @author Brunobhs18
 */
public class FornecedorDAO {
    
    public void create(Fornecedor f){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO fornecedor(nomefor,enderecofor,contatofor) VALUES(?,?,?)");
            stmt.setString(1, f.getNomefor());
            stmt.setString(2, f.getEnderecofor());
            stmt.setString(3, f.getContatofor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Fornecedor> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM fornecedor");
           rs = stmt.executeQuery();
           while(rs.next()){
               Fornecedor forn = new Fornecedor();
               
               forn.setNomefor(rs.getNString("nomefor"));
               forn.setEnderecofor(rs.getNString("enderecofor"));
               forn.setContatofor(rs.getNString("contatofor"));
               fornecedores.add(forn);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return fornecedores;
    }
    
    public void update(Fornecedor f){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE fornecedor SET enderecofor = ?,contatofor = ? WHERE nomefor = ?");
            stmt.setString(1, f.getEnderecofor());
            stmt.setString(2, f.getContatofor());
            stmt.setString(3, f.getNomefor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Fornecedor f){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM fornecedor WHERE nomefor = ?");
            stmt.setString(1, f.getNomefor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exluido com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Fornecedor> readBusca(String bus){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE nomefor LIKE ?");
           stmt.setString(1, "%"+bus+"%");
           rs = stmt.executeQuery();
           while(rs.next()){
               Fornecedor forn = new Fornecedor();
               
               forn.setNomefor(rs.getNString("nomefor"));
               forn.setEnderecofor(rs.getNString("enderecofor"));
               forn.setContatofor(rs.getNString("contatofor"));
               fornecedores.add(forn);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fazer a busca "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return fornecedores;
    }
    
    
}
