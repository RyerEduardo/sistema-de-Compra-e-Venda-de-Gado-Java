/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import model.Usuario;

/**
 *
 * @author Eduardo
 */
public class UsuarioController {
    
    UsuarioDao udao = new UsuarioDao();
    
    public boolean efetuarLogin(String login, String senha){
      return  udao.efetuarLogin(login, senha);
        
    }
    
    public int buscaId(String login, String senha){
       return udao.buscaID(login, senha);
    }
    public boolean verificaNomeUser(String login){
       return udao.verificaNomeUser(login);
    }
    
    public void salvar(Usuario u){
        udao.salvar(u);
    }
}
