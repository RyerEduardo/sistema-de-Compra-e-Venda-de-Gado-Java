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
import model.Raca;

/**
 *
 * @author Eduardo
 */
public class RacaDao {
//    Conexao con = new Conexao();
    Connection con = null;
    PreparedStatement pstm = null;
    
   
    public void salvar(Raca raca) {
//        con.conectar();
        String sql = "INSERT INTO raca (nome) "
                + "VALUES(?)";
//        con.executarSQL("SELECT * FROM raca");
        try {
//            con.stm.executeUpdate(sql);
        con = new Conexao().getConectar();
        pstm = con.prepareStatement(sql);
        
        this.pstm.setString(1, raca.getNome());
      
        this.pstm.execute();
        this.pstm.close();
        con.close();
            JOptionPane.showMessageDialog(null, "Raca Registrada Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

   
    public void editar(Raca raca) {

        String sql = "UPDATE raca SET nome = ? WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setString(1, raca.getNome());
            this.pstm.setInt(2, raca.getId());

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Alteração Realizada Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

 
    public void excluir(int id) {
//        con.conectar();
        String sql = "DELETE FROM Raca WHERE id = ?";
//        con.executarSQL("SELECT * FROM raca");
        
        try {
//            con.stm.executeUpdate(sql);
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Raça Excluida Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

    
    public List<Raca> getRacas() {
//        con.conectar();
        List<Raca> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM raca";
//        con.executarSQL(sql);
        
        try {
//            con.rs.first();
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Raca(
                    rs.getInt("id"),
                    rs.getString("nome")                 
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
    
     public int getIdCombo(String nome)
    {
        int resultado=0;
         ResultSet rs;
        String sql = "SELECT id FROM raca where nome=?";
         try {
//            
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setString(1, nome);
            
            rs = pstm.executeQuery();
            
            rs.first();
            resultado = rs.getInt("id");
         }catch(SQLException erro)
         {
             JOptionPane.showMessageDialog(null, "Erro ao buscar raça no combo" + erro + "SQL" + sql);
         }
         return resultado;
    }
    public String getNomeCombo(int id)
    {
        String resultado="";
        ResultSet rs;
        String sql = "SELECT DISTINCT nome FROM raca INNER JOIN bovino ON idRaca = raca.id WHERE idRaca=?";
         try {    // SELECT DISTINCT nome FROM marca INNER JOIN notebook ON marca_id = marca.id WHERE marca_id=?";
//            
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            rs.first();
            resultado = rs.getString("nome");
         }catch(SQLException erro)
         {
             JOptionPane.showMessageDialog(null, "Erro ao buscar marca no combo" + erro + "SQL" + sql);
         }
         return resultado;
    }
    
     public List<String> getRaca() {
        List<String> list = new ArrayList<>();
        
        String sql = "SELECT nome FROM raca ORDER BY nome ASC";
        ResultSet rs;
        
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                list.add(rs.getString("nome"));
            }
            
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista de raças" + Erro + "SQL" + sql);
        }
        
        return list;
    }
    
}
