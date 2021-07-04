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

        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table  action=\"/config\" border=\"1\">\n" +
                "    <tr>\n" +
                "        <td>ID</td>\n" +
                "        <td>Nome do alimento</td>\n" +
                "        <td>marca</td>\n" +
                "        <td>pesagem</td>\n" +
                "        <td>tipo</td>\n" +
                "        <td>preco R$</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td> 1  </td>\n" +
                "        <td> Feijao </td>\n" +
                "        <td> Tio Joao </td>\n" +
                "        <td>  1kg </td>\n" +
                "        <td> feijao preto </td>\n" +
                "        <td>  10 </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td> 2 </td>\n" +
                "        <td>  Arroz </td>\n" +
                "        <td>  ArrowZ </td>\n" +
                "        <td>  1kg </td>\n" +
                "        <td> Arroz branco </td>\n" +
                "        <td> 5 </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td> 3 </td>\n" +
                "        <td> Macarrao </td>\n" +
                "        <td> Macarrone </td>\n" +
                "        <td>  1kg </td>\n" +
                "        <td> Macarrão tradicional </td>\n" +
                "        <td> 2 </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td> 4 </td>\n" +
                "        <td> Pizza </td>\n" +
                "        <td> Sadia </td>\n" +
                "        <td>  600g </td>\n" +
                "        <td> Pizza de microondas </td>\n" +
                "        <td> 11 </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td> 5 </td>\n" +
                "        <td> Miojo </td>\n" +
                "        <td> Nissin </td>\n" +
                "        <td>  80g </td>\n" +
                "        <td> Miojo tradicional </td>\n" +
                "        <td> 2 </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");

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
