package com.example.borala.demoaula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/cadastrar")
public class cadastrar {

    AlimentoDao control = new AlimentoDao();



    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String pesagem = request.getParameter("pesagem");
        String tipo = request.getParameter("tipo");
        String preco = request.getParameter("preco");
        Alimento mod = new Alimento(id, nome, marca, pesagem, tipo, Integer.parseInt(preco));
        control.salvar(mod);
        response.sendRedirect("/admin");


    }
}