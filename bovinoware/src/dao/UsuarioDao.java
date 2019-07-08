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
import model.Usuario;

/**
 *
 * @author Eduardo
 */
public class UsuarioDao {
//    Conexao con = new Conexao();
    Connection con = null;
    PreparedStatement pstm = null;
    
   
    public void salvar(Usuario usuario) {
//        con.conectar();
        String sql = "INSERT INTO usuario (nome, login, senha) "
                + "VALUES(?, ?, ?)";
//        con.executarSQL("SELECT * FROM usuario");
        try {
//            con.stm.executeUpdate(sql);
        con = new Conexao().getConectar();
        pstm = con.prepareStatement(sql);
        
        this.pstm.setString(1, usuario.getNome());
        this.pstm.setString(2, usuario.getLogin());
        this.pstm.setString(3, usuario.getSenha());

        this.pstm.execute();
        this.pstm.close();
        con.close();
            JOptionPane.showMessageDialog(null, "Usuario Inserido Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

   
    public void editar(Usuario usuario) {
//        con.conectar();
        String sql = "UPDATE usuario SET login = ?, senha = ? WHERE id = ?";
//        con.executarSQL("SELECT * FROM usuario");
        
        try {
//            con.stm.executeUpdate(sql);
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setString(1, usuario.getLogin());
            this.pstm.setString(2, usuario.getSenha());
            this.pstm.setInt(3, usuario.getId());

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Usuário Alterado Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

 
    public void excluir(int id) {
//        con.conectar();
        String sql = "DELETE FROM Usuario WHERE id = ?";
//        con.executarSQL("SELECT * FROM usuario");
        
        try {
//            con.stm.executeUpdate(sql);
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Usuário Deletado Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

    
    public List<Usuario> getUsuarios() {
//        con.conectar();
        List<Usuario> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM usuario";
//        con.executarSQL(sql);
        
        try {
//            con.rs.first();
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha")                   
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

    
    public boolean efetuarLogin(String login, String senha) {
    
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        ResultSet rs;
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setString(1, login);
            this.pstm.setString(2, senha);
            
            rs = pstm.executeQuery();
            
            
            if(rs.first()){
               
                this.pstm.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Logou");
                return true;
            }
            
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Usuário Inválido");
        }
        return false;
    }
    public boolean verificaNomeUser(String login){
         List<Usuario> list = new ArrayList();
        String sql = "SELECT * FROM usuario WHERE login = ?";
        int qtd=0;
        ResultSet rs;
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setString(1, login);
            
            
            rs = pstm.executeQuery();
            
             while(rs.next()){
                list.add(
                    new Usuario(
                    rs.getInt("id")
                                     
                    )
                );
            }
             for (Usuario u: list) 
                qtd++;
        
            
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Usuário Inválido");
        }
        if(qtd == 0){
            return false;
        }else return true;
    }
    
     public int buscaID(String login, String senha) {
         List<Usuario> list = new ArrayList();
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        int id=0;
        ResultSet rs;
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setString(1, login);
            this.pstm.setString(2, senha);
            
            rs = pstm.executeQuery();
            
             while(rs.next()){
                list.add(
                    new Usuario(
                    rs.getInt("id")
                                     
                    )
                );
            }
             for (Usuario u: list) 
                id = u.getId();
        
            
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Usuário Inválido");
        }
        return id;
    }
}
