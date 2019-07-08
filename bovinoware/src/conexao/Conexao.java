/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Giuliano
 */
public class Conexao {
    private final String url    = "jdbc:mysql://localhost:3306/bovinoware?zeroDateTimeBehavior=convertToNull";
    private final String user   = "root";
    private final String pass   = "";
    private final String driver = "com.mysql.jdbc.Driver";
    
    Connection conexao;
    public Statement stm;
    public ResultSet rs;
    
    public Connection getConectar(){
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, pass);
           // JOptionPane.showMessageDialog(null, "Conectado !");
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Erro de driver " + Driver);
        } catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Erro ao localizar o BD " + Fonte);            
        }
        return conexao;
    }
    
    public void desconectar(){
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Desconectado!");            
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão " + Erro);
        }
    }
    
    public void executarSQL(String sql){
        try {
            stm = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
    }
}
