package com.example.borala.demoaula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/VerCarrinho")
public class VerCarrinho {



    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        HttpSession session = request.getSession();
        if(session.getAttribute("carrinho") != null){
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
                    "    </tr> \n"
            );
            ArrayList<Alimento> lista = (ArrayList<Alimento>)session.getAttribute("carrinho");
            for (Alimento a : lista){

                response.getWriter().println("" +

                        "<tr>\n" +
                        "        <td> " + a.getID() +  "  </td>  \n" +
                        "        <td>" + a.getNome() + "</td>   \n" +
                        "        <td> " + a.getMarca() + "</td>    \n" +
                        "        <td> " + a.getPesagem() + " </td>   \n" +
                        "        <td>" + a.getTipo() + "</td>  \n" +
                        "        <td>" + a.getPreco() + "  </td>   " +
                        "   </tr> \n");
            }


            response.getWriter().println("\n" +
                    "\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "<p><a href=\"/Finalizar\">Finalizar Pedido</a></p>\n" +
                    "</html>");


        } else{
            response.sendRedirect("/cliente");
        }


        }

}


