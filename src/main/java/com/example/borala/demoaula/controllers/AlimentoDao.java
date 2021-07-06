package com.example.borala.demoaula.controllers;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class AlimentoDao {


    private static conectaBanco con;
    private final String CREATE = " CREATE TABLE public.alimento(" +
            " id character varying COLLATE pg_catalog.\"default\" NOT NULL," +
            " nome character varying COLLATE pg_catalog.\"default\"," +
            " marca character varying COLLATE pg_catalog.\"default\"," +
            " pesagem character varying COLLATE pg_catalog.\"default\", " +
            "tipo character varying COLLATE pg_catalog.\"default\", " +
            "preco character varying COLLATE pg_catalog.\"default\", " +
            "CONSTRAINT alimento_pkey PRIMARY KEY (id));";

    public AlimentoDao() {
        con = new conectaBanco(System.getenv("DATABASE_HOST"), System.getenv("DATABASE_PORT"), System.getenv("DATABASE_NAME"), System.getenv("DATABASE_USERNAME"), System.getenv("DATABASE_PASSWORD"));
    }


    public void salvar (Alimento mod){

        // estabelecer a conexao com o banco de dados
        try {
            con.conectar();
            PreparedStatement pst = con.getCon().prepareStatement("insert into alimento(id,nome,marca,pesagem,tipo,preco) values (?,?,?,?,?,?)");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            pst.setString(1,mod.getID());
            pst.setString(2,mod.getNome());
            pst.setString(3,mod.getMarca());
            pst.setString(4,mod.getPesagem());
            pst.setString(5,mod.getTipo());
            pst.setInt(6,mod.getPreco());
            pst.execute();
            con.desconectar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlimentoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Alimento> listar () {

        ArrayList<Alimento> array = new ArrayList<>();


        // estabelecer a conexao com o banco de dados
        try {
            con.conectar();
            PreparedStatement pst = con.getCon().prepareStatement("select * from alimento");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Alimento ali = new Alimento(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"),rs.getString("tipo"),rs.getInt("preco"));
                array.add(ali);
            }
            con.desconectar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AlimentoDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return array;
    }

    public void create(){


        try {
            con.conectar();
            Statement st = con.getCon().createStatement();
            st.execute(CREATE);
            con.desconectar();
        }catch(SQLException e){
            System.out.println("erro"+e);
        }
        
    }





    public Alimento readforID (String id) {


        // estabelecer a conexao com o banco de dados
       PreparedStatement stmt = null;
        ResultSet rs = null;
        Alimento a = null;

        try{
            con.conectar();
            stmt = con.getCon().prepareStatement("select * from alimento where id =? ");
            stmt.setString(1,( id ));
            rs = stmt.executeQuery();

            if (rs.next()) {
                 a = new Alimento(rs.getString("id"), rs.getString("nome"), rs.getString("marca"), rs.getString("pesagem"),rs.getString("tipo"),rs.getInt("preco"));
            }
            con.desconectar();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return a;
    }






}
