/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RacaDao;
import java.util.List;
import model.Raca;


/**
 *
 * @author Eduardo
 */
public class RacaController {
    
    RacaDao rdao = new RacaDao();
    
    public void salvar(Raca r){
        rdao.salvar(r);
    }
    
    public List listar(){
        return rdao.getRacas();
    }
    public void editar(Raca r){
        rdao.editar(r);
    }
     public void excluir(int id){
        rdao.excluir(id);
    }
     
     public int retornaId(String nome){
        return rdao.getIdCombo(nome);
    }
     public String retornaRaca(int id){
        return rdao.getNomeCombo(id);
    }
     
     public List<String> getRaca(){
        return rdao.getRaca();
    }
    
     
}
