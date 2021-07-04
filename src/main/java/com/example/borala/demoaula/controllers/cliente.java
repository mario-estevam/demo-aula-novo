package com.example.borala.demoaula.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping ("/cliente")
public class cliente {

    conectaBanco conex = new conectaBanco();

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        ArrayList<Alimento> array = new ArrayList<>();
        array = AlimentoDao.listar();
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
                        "  <td>Carrinho</td>\n" +
                "    </tr> \n"
                );

                for (int i=0; i<array.size(); i++) {

                    response.getWriter().println("" +

                            "<tr>\n" +
                            "        <td> " + array.get(i).getID() +  "  </td>  \n" +
                            "        <td>" + array.get(i).getNome() + "</td>   \n" +
                            "        <td> " + array.get(i).getMarca() + "</td>    \n" +
                            "        <td> " + array.get(i).getPesagem() + " </td>   \n" +
                            "        <td>" + array.get(i).getTipo() + "</td>  \n" +
                            "        <td>" + array.get(i).getPreco() + "  </td>   " +
                            "        <td> <a href=\"/adicionarCarrinho?id="+array.get(i).getID()+"\">adicionar </td><br/> \n" +
                            "   </tr> \n");
                }


                response.getWriter().println("\n" +
                            "\n" +
                            "</table>\n" +
                            "<p><a href=\"/VerCarrinho\">Ver Carrinho</a></p>\n" +
                            "</body>\n" +
                            "</html>");


    }
}