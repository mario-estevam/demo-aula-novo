package com.example.borala.demoaula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/listar")
public class ListarUsuarios {
    UsuarioDao control = new UsuarioDao();

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Usuario> array = new ArrayList<>();
        array = UsuarioDao.listar();
         for (int i=0; i<array.size(); i++){
             response.getWriter().println(array.get(i).getLogin());
         }

    }


}