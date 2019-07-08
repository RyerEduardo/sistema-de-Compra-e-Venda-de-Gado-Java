/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompraDao;
import java.util.List;
import model.Compra;
import model.Usuario;

/**
 *
 * @author Eduardo
 */
public class CompraController {
    
    CompraDao cdao = new CompraDao();
    
    public List listar(int idUser){
       return  cdao.listar(idUser);
    }
    
    public void salvar(Compra c){
        cdao.salvar(c);
    }
     public void editar(Compra c, int idCompra){
        cdao.editar(c, idCompra);
    }
    public Compra buscaCompra(int idCompra){
       return cdao. buscaCompra(idCompra);
    }
    public void excluir(int idCompra){
       cdao. excluir(idCompra);
    }
    
}
