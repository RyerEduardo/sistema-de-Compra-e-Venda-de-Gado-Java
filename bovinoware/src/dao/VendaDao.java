/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Bovino;
import model.Venda;

/**
 *
 * @author Eduardo
 */
public class VendaDao {
//    Conexao con = new Conexao();
    Connection con = null;
    PreparedStatement pstm = null;
    
   
    public void salvar(Venda venda) {
       String sql = "INSERT INTO venda (idUsuario, idBovino, nome, endereco, telefone) "
                + "VALUES(?, ?, ?, ?, ?)";
       
        try {
          
        con = new Conexao().getConectar();
        pstm = con.prepareStatement(sql);
        
        this.pstm.setInt(1, venda.getIdUsuario());
        this.pstm.setInt(2, venda.getIdBovino());
        this.pstm.setString(3, venda.getNome());
        this.pstm.setString(4, venda.getEndereco());
        this.pstm.setString(5, venda.getTelefone());
        

        this.pstm.execute();
        this.pstm.close();
        con.close();
            JOptionPane.showMessageDialog(null, "Venda Registrada Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta xxxxxxx" + Erro + "SQL" + sql);
        }
    }

   
    public void editar(Venda venda, int idVenda) {

        String sql = "UPDATE venda SET nome = ?, endereco = ?, telefone = ? WHERE idVenda = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setString(1, venda.getNome());
            this.pstm.setString(2, venda.getEndereco());
            this.pstm.setString(3, venda.getTelefone());
            this.pstm.setInt(4, idVenda);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Venda editada com sucesso!");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }

    }

 
    public void excluir(int id) {
//        con.conectar();
        String sql = "DELETE FROM Venda WHERE idVenda = ?";
//        con.executarSQL("SELECT * FROM venda");
        
        try {
//            con.stm.executeUpdate(sql);
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro de venda excluido!");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

    
    public List<Venda> getVendas(int id) {
//        con.conectar();
        List<Venda> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM venda WHERE idUsuario = ?";
//        con.executarSQL(sql);
        
        try {
//            con.rs.first();
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Venda(
                    rs.getInt("idVenda"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idBovino"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString(" telefone")
                         
                    )
                            
                );
            }
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
//        con.desconectar();
        return list;
    }

    public Venda buscaVenda(int idVenda) {

        List<Venda> list = new ArrayList<>();
        Venda b = new Venda();
        ResultSet rs;
        String sql = "SELECT * FROM venda WHERE idVenda = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, idVenda);
         
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Venda(
                    rs.getInt("idVenda"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idBovino"),
                    rs.getString("nome"),
                    rs.getString("endereco"),  
                    rs.getString("telefone")
                                
                    )
                );
            }
            for (Venda u: list){
                
                b.setIdVenda(u.getIdVenda());
                b.setIdUsuario(u.getIdUsuario());
                b.setIdBovino(u.getIdBovino());
                b.setNome(u.getNome());
                b.setEndereco(u.getEndereco());
                b.setTelefone(u.getTelefone());
                
            } 
                    
            
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
//        con.desconectar();
        return b;
    }
    public Venda buscaVenda2(int idBovino, int idUser) {

        List<Venda> list = new ArrayList<>();
        Venda b = new Venda();
        ResultSet rs;
        String sql = "SELECT * FROM venda WHERE idBovino = ? and idUsuario = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, idBovino);
            this.pstm.setInt(2, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Venda(
                    rs.getInt("idVenda"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idBovino"),
                    rs.getString("nome"),
                    rs.getString("endereco"),  
                    rs.getString("telefone")
                                
                    )
                );
            }
            for (Venda u: list){
                
                b.setIdVenda(u.getIdVenda());
                b.setIdUsuario(u.getIdUsuario());
                b.setIdBovino(u.getIdBovino());
                b.setNome(u.getNome());
                b.setEndereco(u.getEndereco());
                b.setTelefone(u.getTelefone());
                
            } 
                    
            
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
//        con.desconectar();
        return b;
    }
 
    
     
}
