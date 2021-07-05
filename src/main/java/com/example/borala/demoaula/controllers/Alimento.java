package com.example.borala.demoaula.controllers;

public class Alimento {
    private String ID;
    private String nome;
    private String marca;
    private String pesagem;
    private String tipo;
    private Integer preco;


    public Alimento(String ID, String nome, String marca, String pesagem, String tipo, Integer preco) {
        this.ID = ID;
        this.nome = nome;
        this.marca = marca;
        this.pesagem = pesagem;
        this.tipo = tipo;
        this.preco = preco;

    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPesagem() {
        return pesagem;
    }

    public void setPesagem(String pesagem) {
        this.pesagem = pesagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

}
