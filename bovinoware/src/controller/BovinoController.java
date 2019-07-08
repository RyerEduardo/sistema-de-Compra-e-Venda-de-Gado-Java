/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BovinoDao;
import java.util.List;
import model.Bovino;



/**
 *
 * @author Eduardo
 */
public class BovinoController {
    
    private Bovino bovino;
    
    private BovinoDao bdao = new BovinoDao();
   
    public void registraCompra(Bovino b){
        bdao.registraCompra(b);
    }
    public int  somaBovinos(int idUser ){
        List<Bovino> cLista = bdao.getBovinos(idUser);      
        int qtd = 0;
            for (Bovino b: cLista) 
             qtd++;
             
       return qtd;
    }
    public void cancelarRegistroVenda(int idBovino){
        bdao.cancelarRegistroVenda(idBovino);
    }
    
    public void cancelarRegistroCompra(int idBovino){
        bdao.cancelarRegistroCompra(idBovino);
    }
    public int  somaBovinosVendidos(int idUser ){
        List<Bovino> cLista = bdao.getBovinosVendidos(idUser);      
        int qtd = 0;
            for (Bovino b: cLista) 
             qtd++;
             
       return qtd;
    }
    
    public int buscaSemRegistro(){
        return bdao.buscaSemRegistro();
    }
    public void relatorioBovinosVendidos(int idUser){
        bdao.relatorioBovinosVendidos(idUser);
    }
    public void relatorioRebanho(int idUser){
        bdao.relatorioRebanho(idUser);
    }
    public void relatorioCompras(int idUser){
        bdao.relatorioCompras(idUser);
    }
    public void vinculaBovino(int id){
         bdao.vinculaBovino(id);
    }
    
    public List getBovinos(int idUser) {
         return bdao.getBovinos(idUser);
    }
     public Bovino getBovino(int idBovino, int idUser) {
        return bdao.buscaBovino(idBovino, idUser);
    }
    public List getBovinosVendidos(int idUser) {
         return bdao.getBovinosVendidos(idUser);
    }
    public void registraVenda(Bovino bovino, int idBovino){
        bdao.registraVenda(bovino, idBovino);
    }
     public void editar(Bovino bovino, int idBovino){
        bdao.editar(bovino, idBovino);
    }
    public boolean verificaUsoRaca(int idRaca){
        return bdao.verificaUsoRaca(idRaca);
    }
}
