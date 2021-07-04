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
    conectaBanco conex = new conectaBanco();
    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

                String ID = "1";
                String nome = "Feijao";
                String marca = "Tio joao";
                String pesagem = "1kg";
                String tipo = "feijao preto";
                Integer preco = 10;
                Alimento mod = new Alimento(ID,nome,marca,pesagem,tipo,preco);
                control.salvar(mod);

                String ID2 = "2";
                String nome2 = "Arroz";
                String marca2 = "ArrowZ";
                String pesagem2 = "1kg";
                String tipo2 = "Arroz Branco";
                Integer preco2 = 5;
                Alimento mod2 = new Alimento(ID2,nome2,marca2,pesagem2,tipo2,preco2);
                control.salvar(mod2);

                String ID3= "3";
                String nome3 = "Macarrao";
                String marca3 = "Macarrone";
                String pesagem3 = "1kg";
                String tipo3 = "Macarrao Tradicional";
                Integer preco3 = 2;
                Alimento mod3 = new Alimento(ID3,nome3,marca3,pesagem3,tipo3,preco3);
                control.salvar(mod3);


                String ID4 = "4";
                String nome4 = "Pizza";
                String marca4 = "Sadia";
                String pesagem4 = "600g";
                String tipo4 = "Pizza de microondas";
                Integer preco4 = 11;
                Alimento mod4 = new Alimento(ID4,nome4,marca4,pesagem4,tipo4,preco4);
                control.salvar(mod4);

                String ID5 = "5";
                String nome5 = "Miojo";
                String marca5 = "Nissin";
                String pesagem5 = "80g";
                String tipo5 = "Miojo tradicional";
                Integer preco5 = 2;
                Alimento mod5 = new Alimento(ID5,nome5,marca5,pesagem5,tipo5,preco5);
                control.salvar(mod5);

                response.sendRedirect("/ok");

        }



}
