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
import model.Compra;
import model.Venda;

/**
 *
 * @author Eduardo
 */
public class CompraDao {
//    Conexao con = new Conexao();
    Connection con = null;
    PreparedStatement pstm = null;

   
    public void salvar(Compra compra) {

        String sql = "INSERT INTO compra (idUsuario, idBovino, nome, endereco, telefone) "
                + "VALUES(?, ?, ?, ?, ?)";
       
        try {
          
        con = new Conexao().getConectar();
        pstm = con.prepareStatement(sql);
        
        this.pstm.setInt(1, compra.getIdUsuario());
        this.pstm.setInt(2, compra.getIdBovino());
        this.pstm.setString(3, compra.getNome());
        this.pstm.setString(4, compra.getEndereco());
        this.pstm.setString(5, compra.getTelefone());
        

        this.pstm.execute();
        this.pstm.close();
        con.close();
            JOptionPane.showMessageDialog(null, "Compra Registrada Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta xxxxxxx" + Erro + "SQL" + sql);
        }

    }
    
     public void editar(Compra compra, int idCompra) {

        String sql = "UPDATE compra SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setString(1, compra.getNome());
            this.pstm.setString(2, compra.getEndereco());
            this.pstm.setString(3, compra.getTelefone());
            this.pstm.setInt(4, idCompra);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro de Compra Alterado com Sucesso!");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }

    }
        
    public Compra buscaCompra(int idCompra){
        
        List<Compra> list = new ArrayList<>();
        Compra b = new Compra();
        ResultSet rs;
        String sql = "SELECT * FROM compra WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, idCompra);
         
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Compra(
                    rs.getInt("id"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idBovino"),
                    rs.getString("nome"),
                    rs.getString("endereco"),  
                    rs.getString("telefone")
                                
                    )
                );
            }
            for (Compra u: list){
                
                b.setId(u.getId());
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
    
   
   

 
    public void excluir(int id) {

        String sql = "DELETE FROM Compra WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro de Compra Excluido Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }

    }

    
    public List<Compra> listar(int idUser) {

        List<Compra> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM compra WHERE idUsuario = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Compra(
                    rs.getInt("id"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idBovino"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone")                   
                    )
                );
            }
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }

        return list;
    }

    
    
}
