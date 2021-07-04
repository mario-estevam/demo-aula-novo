package com.example.borala.demoaula.controllers;

import com.sun.net.httpserver.Authenticator;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;


@Controller
@RequestMapping("/admin")
public class admin {

    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.getWriter().println(" <!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/cadastrar\"  method=\"post\">\n" +
                "    ID: <input type=\"text\" name=\"id\"> <br />\n" +
                "    Nome do Alimento: <input type=\"text\" name=\"nome\"><br />\n" +
                "    Marca: <input type=\"text\" name=\"marca\"><br />\n" +
                "    Peso: <input type=\"text\" name=\"pesagem\"><br />\n" +
                "    Tipo: <input type=\"text\" name=\"tipo\"><br />\n" +
                "    Preco: <input type=\"number\" name=\"preco\"><br />\n" +
                "    \n" +
                "    <button type=\"submit\">Enviar</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

            HttpSession session = request.getSession();
            var out = response.getWriter();
            var dataCriacao = new Date(session.getCreationTime());
            var dataUltimoAcesso = new Date((session.getLastAccessedTime()));
            var formatData = new SimpleDateFormat("dd/MM/yyyy--hh:mm:ss");

            Cookie c = new Cookie("visita", formatData.format(dataCriacao));
            c.setMaxAge(60*60*24);
            response.addCookie(c);
            out.println("Ultimo acesso: " +formatData.format(dataCriacao));
    }


}
