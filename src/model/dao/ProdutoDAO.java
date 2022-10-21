
package model.dao;
import java.sql.*;
import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Produto;
import model.bean.Fornecedor;

public class ProdutoDAO {
    public void create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produtos (codfor,nomeprod,quantidade,tamanho,cor,valorcompra,valorvenda) VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getCodfor());
            stmt.setString(2, p.getNomeprod());
            stmt.setInt(3, p.getQtd());
	    stmt.setString(4, p.getTamanho());
            stmt.setString(5, p.getCor());
	    stmt.setDouble(6, p.getValorcp());
	    stmt.setDouble(7, p.getValorvd());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
       public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM vw_produtos");
           rs = stmt.executeQuery();
           while(rs.next()){
               Produto prod = new Produto();
               prod.setCod(rs.getInt("cod"));
               prod.setCodfor(rs.getInt("codf"));
               prod.setFornecedorp(rs.getNString("nomefor"));
               prod.setNomeprod(rs.getNString("nomeprod"));
               prod.setQtd(rs.getInt("quantidade"));
	       prod.setTamanho(rs.getNString("tamanho"));
	       prod.setCor(rs.getNString("cor"));
	       prod.setValorcp(rs.getDouble("valorcompra"));
	       prod.setValorvd(rs.getDouble("valorvenda"));
               produtos.add(prod);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return produtos;
    }
    
        public void update(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET codfor = ?, nomeprod = ?, quantidade = ?, "
                    + "tamanho = ?, cor = ?, valorcompra = ?, valorvenda = ? WHERE cod = ?");
            stmt.setInt(1, p.getCodfor());
            stmt.setString(2, p.getNomeprod());
            stmt.setInt(3, p.getQtd());
            stmt.setString(4, p.getTamanho());
            stmt.setString(5, p.getCor());
            stmt.setDouble(6, p.getValorcp());
            stmt.setDouble(7, p.getValorvd());
            stmt.setInt(8, p.getCod());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
        public void delete(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE cod = ?");
            stmt.setInt(1, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exluido com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
        public List<Produto> readBusca(String bus){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
       try { 
           stmt = con.prepareStatement("SELECT * FROM vw_produtos WHERE nomeprod LIKE ?");
           stmt.setString(1, "%"+bus+"%");
           rs = stmt.executeQuery();
           while(rs.next()){
               Produto prod = new Produto();
               prod.setCod(rs.getInt("cod"));
               prod.setCodfor(rs.getInt("codf"));
               prod.setFornecedorp(rs.getNString("nomefor"));
               prod.setNomeprod(rs.getNString("nomeprod"));
               prod.setQtd(rs.getInt("quantidade"));
	       prod.setTamanho(rs.getNString("tamanho"));
	       prod.setCor(rs.getNString("cor"));
	       prod.setValorcp(rs.getDouble("valorcompra"));
	       prod.setValorvd(rs.getDouble("valorvenda"));
               produtos.add(prod);
           }
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao fazer a busca "+ex);
       }finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
        
        return produtos;
    }
    
    public ResultSet listaFornecedor(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
                
       try { 
           stmt = con.prepareStatement("SELECT * FROM fornecedor ORDER BY nomefor");
           rs = stmt.executeQuery();
           }
           
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao listar"+ex);
       
       }
        return rs;
}  

}
