package com.example.borala.demoaula.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping ("/adicionarCarrinho")
public class adicionarCarrinho {



   @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
       AlimentoDao pali = new AlimentoDao();
       HttpSession session = request.getSession();
       if (session.getAttribute("carrinho") == null){
           session.setAttribute("carrinho", new ArrayList<Alimento>());
       }
       ArrayList<Alimento> a = (ArrayList<Alimento>)session.getAttribute("carrinho");
       a.add(pali.readforID(request.getParameter("id")));

        response.sendRedirect("/cliente");
    }
}

