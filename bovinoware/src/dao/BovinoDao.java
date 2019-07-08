/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import model.Bovino;
import model.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Eduardo
 */
public class BovinoDao {
//    Conexao con = new Conexao();
    Connection con = null;
    PreparedStatement pstm = null;
    
   
    public void registraCompra(Bovino bovino) {

        String sql = "INSERT INTO bovino (idRaca, idUser, brinco, dataNascimento, dataCompra, pesoCompra, valorCompra, registrado, vendido) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
        try {
          
        con = new Conexao().getConectar();
        pstm = con.prepareStatement(sql);
        
        this.pstm.setInt(1, bovino.getIdRaca());
        this.pstm.setInt(2, bovino.getIdUser());
        this.pstm.setString(3, bovino.getBrinco());
        this.pstm.setString(4, bovino.getDataNascimento());
        this.pstm.setString(5, bovino.getDataCompra());
        this.pstm.setInt(6, bovino.getPesoCompra());
        this.pstm.setDouble(7, bovino.getValorCompra());
        this.pstm.setBoolean(8, bovino.isRegistrado());
        this.pstm.setBoolean(9, bovino.isVendido());

        this.pstm.execute();
        this.pstm.close();
        con.close();
            JOptionPane.showMessageDialog(null, "Novo Bovino adicionado ao rebanho! ");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consultayyyyy" + Erro + "SQL" + sql);
        }

    }
    
    public boolean verificaUsoRaca(int idRaca){
        
         String sql = "SELECT * FROM bovino WHERE idRaca = ?";
         int qtd = 0;
         List<Bovino> list = new ArrayList();
        ResultSet rs;
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, idRaca);
                    
            rs = pstm.executeQuery();
            
           while(rs.next()){
                list.add(
                    new Bovino(
                    rs.getInt("id")
                                    
                    )
                );
            }
             for (Bovino u: list) 
                qtd++;
             
           
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Bovino nao encontrado");
        }
        if(qtd == 0)
              return false;
        else
           return true;
        
    }
    
    public int buscaSemRegistro(){
        
        String sql = "SELECT * FROM bovino WHERE registrado = ?";
         int id=0;
         List<Bovino> list = new ArrayList();
        ResultSet rs;
        try {
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setBoolean(1, false);
                    
            rs = pstm.executeQuery();
            
           while(rs.next()){
                list.add(
                    new Bovino(
                    rs.getInt("id")
                                    
                    )
                );
            }
             for (Bovino u: list) 
                id = u.getId();
             
           
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Bovino nao encontrado");
        }
        return id;
    }
         
    public void registraVenda(Bovino bovino, int id) {

        String sql = "UPDATE bovino SET vendido = ?, dataVenda = ?, pesoVenda = ?, ValorVenda = ? WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            this.pstm.setBoolean(1, bovino.isVendido());
            this.pstm.setString(2, bovino.getDataVenda());
            this.pstm.setInt(3, bovino.getPesoVenda());
            this.pstm.setDouble(4, bovino.getValorVenda());
            this.pstm.setInt(5, id);
           

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro do bovino atualizado!.");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }
    
    public void editar(Bovino bovino, int id) {

        String sql = "UPDATE bovino SET idRaca = ?, brinco = ?, dataNascimento = ?, dataCompra = ?, pesoCompra = ?, valorCompra = ? WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            this.pstm.setInt(1, bovino.getIdRaca());
            this.pstm.setString(2, bovino.getBrinco());
            this.pstm.setString(3, bovino.getDataNascimento());
            this.pstm.setString(4, bovino.getDataCompra());
            this.pstm.setInt(5, bovino.getPesoCompra());
            this.pstm.setDouble(6, bovino.getValorCompra());
            this.pstm.setInt(7, id);
           
         
                    

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro do bovino atualizado!.");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }
    
   
    public void vinculaBovino(int id) {
//        con.conectar();
        String sql = "UPDATE bovino SET registrado = ? WHERE id = ?";
//        con.executarSQL("SELECT * FROM bovino");
        
        try {
//            con.stm.executeUpdate(sql);
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            this.pstm.setBoolean(1, true);
            this.pstm.setInt(2, id);
           

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Bovino vinculado a esta compra!");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

 
    public void cancelarRegistroCompra(int id) {

        String sql = "DELETE FROM bovino WHERE id = ?";

        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Registro do Bovino Excluido Com Sucesso");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + sql);
        }
//        con.desconectar();
    }

    
    public Bovino buscaBovino(int id, int idUser) {
//        con.conectar();
        List<Bovino> list = new ArrayList<>();
        Bovino b = new Bovino();
        ResultSet rs;
        String sql = "SELECT * FROM bovino WHERE id = ? and idUser = ?";
//        con.executarSQL(sql);
        
        try {
//            con.rs.first();
            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setInt(1, id);
            this.pstm.setInt(2, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Bovino(
                    rs.getInt("id"),
                    rs.getInt("idRaca"),
                    rs.getInt("idUser"),
                    rs.getString("brinco"),
                    rs.getString("dataNascimento"),
                    rs.getString("dataCompra"),  
                    rs.getInt("pesoCompra"),  
                    rs.getDouble("valorCompra"),
                    rs.getBoolean("vendido"),
                    rs.getString("dataVenda"),  
                    rs.getInt("pesoVenda"),  
                    rs.getDouble("valorVenda"),
                    rs.getBoolean("registrado")
                                    
                    )
                        
    
                );
            }
            for (Bovino u: list){
                
                b.setId(u.getId());
                b.setIdRaca(u.getIdRaca());
                b.setIdUser(u.getIdUser());
                b.setBrinco(u.getBrinco());
                b.setDataNascimento(u.getDataNascimento());
                b.setDataCompra(u.getDataCompra());
                b.setPesoCompra(u.getPesoCompra());
                b.setValorCompra(u.getValorCompra());
                b.setVendido(u.isVendido());
                b.setDataVenda(u.getDataVenda());
                b.setPesoVenda(u.getPesoVenda());
                b.setValorVenda(u.getValorVenda());
                b.setRegistrado(u.isRegistrado());
            } 
                    
            
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
//        con.desconectar();
        return b;
    }
    
    public List getBovinos(int idUser) { 
        List<Bovino> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM bovino WHERE vendido = ? and idUser = ?";
        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setBoolean(1, false);
            this.pstm.setInt(2, idUser);
           
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Bovino(
                    rs.getInt("id"),
                    rs.getInt("idRaca"),
                    rs.getInt("idUser"),        
                    rs.getString("brinco"),
                    rs.getString("dataNascimento"),
                    rs.getString("dataCompra"),  
                    rs.getInt("pesoCompra"),  
                    rs.getDouble("valorCompra"),
                    rs.getBoolean("vendido"),
                    rs.getString("dataVenda"),  
                    rs.getInt("pesoVenda"),  
                    rs.getDouble("valorVenda"),
                    rs.getBoolean("registrado")
                                    
                    )
                        
    
                );
            }
            this.pstm.close();
            con.close();
        } catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + sql);
        }
//        
        return list;
    }
    
    public void cancelarRegistroVenda(int id){
         
        String sql = "UPDATE bovino SET  vendido = ?, dataVenda = ?, pesoVenda = ?, valorVenda = ? WHERE id = ?";

        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            
            this.pstm.setBoolean(1, false);
            this.pstm.setString(2, null);
            this.pstm.setString(3, null);
            this.pstm.setString(4, null);
            this.pstm.setInt(5, id);
           

            this.pstm.execute();
            this.pstm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Bovino disponivel para venda!");
        } catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao desfazer venda!" + Erro + "SQL" + sql);
        }

    }
    
    
    
    
    public List getBovinosVendidos(int idUser) { 
        List<Bovino> list = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT * FROM bovino WHERE vendido = ? and idUser = ?";
        
        try {

            con = new Conexao().getConectar();
            pstm = con.prepareStatement(sql);
            this.pstm.setBoolean(1, true);
             this.pstm.setInt(2, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Bovino(
                    rs.getInt("id"),
                    rs.getInt("idRaca"),
                    rs.getInt("idUser"),
                    rs.getString("brinco"),
                    rs.getString("dataNascimento"),
                    rs.getString("dataCompra"),  
                    rs.getInt("pesoCompra"),  
                    rs.getDouble("valorCompra"),
                    rs.getBoolean("vendido"),
                    rs.getString("dataVenda"),  
                    rs.getInt("pesoVenda"),  
                    rs.getDouble("valorVenda"),
                    rs.getBoolean("registrado")
                                    
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
    
    public void relatorioBovinosVendidos(int idUser)
     {
           try{
            con = new Conexao().getConectar();
            HashMap filtro = new HashMap();
            filtro.put("id", idUser);
            filtro.put("v", true);
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Users\\brird\\Documents\\Report\\bovinosVendidos.jasper", filtro,con);
            JasperViewer visualizar = new JasperViewer(imprimir,false);
            
            visualizar.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
            visualizar.setVisible(true);
        }catch(JRException erro)
        {
            JOptionPane.showMessageDialog(null,"Erro ao gerar relatório"+ erro);
        }
     }
    
    public void relatorioRebanho(int idUser)
     {
           try{
            con = new Conexao().getConectar();
            HashMap filtro = new HashMap();
            filtro.put("id", idUser);
            filtro.put("v", false);
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Users\\brird\\Documents\\NetBeansProjects\\bovinoware\\src\\img\\rebanhoAtual.jasper", filtro,con);
            JasperViewer visualizar = new JasperViewer(imprimir,false);
            
            visualizar.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
            visualizar.setVisible(true);
        }catch(JRException erro)
        {
            JOptionPane.showMessageDialog(null,"Erro ao gerar relatório"+ erro);
        }
     }
    
      
    public void relatorioCompras(int idUser)
     {
           try{
            con = new Conexao().getConectar();
            HashMap filtro = new HashMap();
            filtro.put("id", idUser);
            filtro.put("v", false);
            JasperPrint imprimir = JasperFillManager.fillReport("C:\\Users\\brird\\Documents\\NetBeansProjects\\bovinoware\\src\\img\\listaDeCompras.jasper", filtro,con);
            JasperViewer visualizar = new JasperViewer(imprimir,false);
            
            visualizar.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
            visualizar.setVisible(true);
        }catch(JRException erro)
        {
            JOptionPane.showMessageDialog(null,"Erro ao gerar relatório"+ erro);
        }
     }
    
}
