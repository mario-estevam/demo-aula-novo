package com.example.borala.demoaula.controllers;

import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDao {
    conectaBanco conex = new conectaBanco();


    public void salvar (Usuario mod){
        Connection connection = null;
        try {
            connection = conectaBanco.getConnection();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }

      // estabelecer a conexao com o banco de dados
        try {
            PreparedStatement pst = connection.prepareStatement("insert into usuario(login,senha,perfil,email) values (?,?,?,?)");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            pst.setString(1,mod.getLogin());
            pst.setString(2,mod.getSenha());
            pst.setString(3,mod.getPerfil());
            pst.setString(4,mod.getEmail());
            pst.execute();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Usuario> listar () {
        Connection connection = null;
        ArrayList<Usuario> array = new ArrayList<>();
        try {
            connection = conectaBanco.getConnection();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }

        // estabelecer a conexao com o banco de dados
        try {
            PreparedStatement pst = connection.prepareStatement("select * from usuario");// o preapredStatement é responsavel por fazer uma inserção de dados de forma segura no banco através de uma String sql q é passada por parametro
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario(rs.getString("login"), rs.getString("senha"), rs.getString("email"), rs.getString("perfil"));
                array.add(usu);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return array;
    }


}