package com.example.borala.demoaula.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/config")
public class config {
    AlimentoDao control = new AlimentoDao();

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        AlimentoDao ali = new AlimentoDao();
        ali.create();


        ali.salvar(new Alimento("1","feijao","Tio joao","1kg","feijao preto",10));
        ali.salvar(new Alimento("2","arroz","ArrowZ","1kg","aroz branco",5));
        ali.salvar(new Alimento("3","Banana","Bans","50g","Banana Prata",5));
        ali.salvar(new Alimento("4","Macarrao","Macarrone","1kg","macarrao tradicional",2));
        ali.salvar(new Alimento("5","Lasanha","Sadia","600g","Lasanha de microondas",11));

        response.sendRedirect("/ok");

        }



}
