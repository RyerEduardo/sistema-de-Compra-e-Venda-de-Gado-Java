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
public class Bovino {
    private int id;
    private int idRaca;
    private int idUser;
    private String brinco;
    private String dataNascimento;
    private String dataCompra;
    private int pesoCompra;
    private double valorCompra;
    private boolean vendido; //usado para operação de venda
    private String dataVenda;
    private int pesoVenda;
    private double valorVenda;
    private boolean registrado; //usado para operação de compra 

   
    public Bovino() {
       
    }
    public Bovino(int id) {
        this.id = id;
    }

    public Bovino(int id, int idRaca, int idUser, String brinco, String dataNascimento, String dataCompra, int pesoCompra, double valorCompra, boolean vendido, String dataVenda, int pesoVenda, double valorVenda, boolean registrado) {
        this.id = id;
        this.idRaca = idRaca;
        this.idUser = idUser;
        this.brinco = brinco;
        this.dataNascimento = dataNascimento;
        this.dataCompra = dataCompra;
        this.pesoCompra = pesoCompra;
        this.valorCompra = valorCompra;
        this.vendido = vendido;
        this.dataVenda = dataVenda;
        this.pesoVenda = pesoVenda;
        this.valorVenda = valorVenda;
        this.registrado = registrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getBrinco() {
        return brinco;
    }

    public void setBrinco(String brinco) {
        this.brinco = brinco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getPesoCompra() {
        return pesoCompra;
    }

    public void setPesoCompra(int pesoCompra) {
        this.pesoCompra = pesoCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getPesoVenda() {
        return pesoVenda;
    }

    public void setPesoVenda(int pesoVenda) {
        this.pesoVenda = pesoVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

   
    
    
}

