/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Eduardo
 */
public class Venda {
    private int idVenda;
    private int idUsuario;
    private int idBovino;
    private String nome;
    private String endereco;
    private String telefone;
    

    public Venda() {
    }

    public Venda(int idVenda, int idUsuario, int idBovino, String nome, String endereco, String telefone) {
        this.idVenda = idVenda;
        this.idUsuario = idUsuario;
        this.idBovino = idBovino;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(int idBovino) {
        this.idBovino = idBovino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}