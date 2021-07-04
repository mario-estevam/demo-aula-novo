package com.example.borala.demoaula.controllers;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AlimentoDao {

    conectaBanco conex = new conectaBanco();


    public void salvar (Alimento mod){
        Connection connection = null;
        try {
            connection = conectaBanco.getConnection();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }

        // estabelecer a conexao com o banco de dados
        try {
            PreparedStatement pst = connection.prepareStatement("insert into alimento(id,nome,marca,pesagem,tipo,preco) values (?,?,?,?,?,?)");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            pst.setString(1,mod.getID());
            pst.setString(2,mod.getNome());
            pst.setString(3,mod.getMarca());
            pst.setString(4,mod.getPesagem());
            pst.setString(5,mod.getTipo());
            pst.setInt(6,mod.getPreco());
            pst.execute();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlimentoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Alimento> listar () {
        Connection connection = null;
        ArrayList<Alimento> array = new ArrayList<>();
        try {
            connection = conectaBanco.getConnection();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }

        // estabelecer a conexao com o banco de dados
        try {
            PreparedStatement pst = connection.prepareStatement("select * from alimento");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Alimento ali = new Alimento(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"),rs.getString("tipo"),rs.getInt("preco"));
                array.add(ali);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlimentoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return array;
    }






    public Alimento readforID (String id) {
        Connection connection = null;
        try {
            connection = conectaBanco.getConnection();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }

        // estabelecer a conexao com o banco de dados
       PreparedStatement stmt = null;
        ResultSet rs = null;
        Alimento a = null;

        try{

            stmt = connection.prepareStatement("select * from alimento where id =? ");
            stmt.setString(1,( id ));
            rs = stmt.executeQuery();

            if (rs.next()) {
                 a = new Alimento(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"),rs.getString("tipo"),rs.getInt("preco"));
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return a;
    }





}
