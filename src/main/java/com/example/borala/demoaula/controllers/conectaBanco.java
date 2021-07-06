package com.example.borala.demoaula.controllers;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaBanco {
    String url;
    String usuario;
    String senha;
    Connection con;

    public conectaBanco(String host, String porta, String db, String usuario, String senha) {
        this.url = "jdbc:postgresql://" + host + ':' + porta + "/" + db + "?serverTimezone=UTC";
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectar(){
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        }catch (Exception e){
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }

    public void desconectar(){
        try {
            con.close();
        }catch (Exception e){
            System.out.println("Erro na desconexão: " + e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }
}