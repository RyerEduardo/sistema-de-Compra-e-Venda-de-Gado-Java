/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.VendaDao;
import java.util.List;

import model.Venda;

/**
 *
 * @author Eduardo
 */
public class VendaController {
    
    VendaDao vdao = new VendaDao();
    
     public List getVendas(int idUser){
        return vdao.getVendas(idUser);
    }
    public Venda buscaVenda(int idVenda){
        return vdao.buscaVenda(idVenda);
    }
    public Venda buscaVenda2(int idBovino, int idUser){//usado quando não tem o id da venda
        return vdao.buscaVenda2(idBovino, idUser);
    }
     public void excluir(int idVenda){
        vdao.excluir(idVenda); 
     }
    public void salvar(Venda v){
        vdao.salvar(v);
    }
    
     public void editaVenda(Venda v, int idVenda){
         vdao.editar(v, idVenda);
     }
}
