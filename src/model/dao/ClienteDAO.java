package model.dao;
import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDAO {
        public void create(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nomecli,endereco,contato) VALUES(?,?,?)");
            stmt.setString(1, c.getNomecli());
            stmt.setString(2, c.getEnderecocli());
            stmt.setString(3, c.getContatocli());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM cliente");
           rs = stmt.executeQuery();
           while(rs.next()){
               Cliente cli = new Cliente();
               
               cli.setNomecli(rs.getNString("nomecli"));
               cli.setEnderecocli(rs.getNString("endereco"));
               cli.setContatocli(rs.getNString("contato"));
               clientes.add(cli);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return clientes;
    }
    
    public void update(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET endereco = ?,contato = ? WHERE nomecli = ?");
            stmt.setString(1, c.getEnderecocli());
            stmt.setString(2, c.getContatocli());
            stmt.setString(3, c.getNomecli());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE nomecli = ?");
            stmt.setString(1, c.getNomecli());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exluido com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> readBusca(String bus){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM cliente WHERE nomecli LIKE ?");
           stmt.setString(1, "%"+bus+"%");
           rs = stmt.executeQuery();
           while(rs.next()){
               Cliente cli = new Cliente();
               
               cli.setNomecli(rs.getNString("nomecli"));
               cli.setEnderecocli(rs.getNString("endereco"));
               cli.setContatocli(rs.getNString("contato"));
               clientes.add(cli);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return clientes;
    }
}
