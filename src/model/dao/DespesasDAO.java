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
import model.bean.Despesas;



/**
 *
 * @author Brunobhs18
 */
public class DespesasDAO {
        
    public void create(Despesas d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO despesas (tipo,valor,data) VALUES(?,?,?)");
            stmt.setString(1, d.getTipo());
            stmt.setDouble(2, d.getValorD());
            stmt.setString(3, d.getData());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Despesas> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Despesas> despesas = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM despesas");
           rs = stmt.executeQuery();
           while(rs.next()){
               Despesas d = new Despesas();
               
               d.setTipo(rs.getNString("tipo"));
               d.setValorD(rs.getDouble("valor"));
               d.setData(rs.getNString("data"));
               despesas.add(d);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return despesas;
    }
    
    public void update(Despesas d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE despesas SET valor = ?, data = ? WHERE tipo = ?");
            stmt.setDouble(1, d.getValorD());
            stmt.setString(2, d.getData());
            stmt.setString(3, d.getTipo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Despesas d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM despesas WHERE tipo = ?");
            stmt.setString(1, d.getTipo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exluido com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
}
}
