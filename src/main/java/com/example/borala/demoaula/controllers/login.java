package com.example.borala.demoaula.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class login {

    UsuarioDao control = new UsuarioDao();
    conectaBanco conex = new conectaBanco();


    @PostMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       String login = request.getParameter("login");
       String senha = request.getParameter("senha");
       String perfil = request.getParameter("perfil");
       String email = request.getParameter("email");
       if (login.length() <= 0){
                request.setAttribute("cliente", "Por favor preencha seu login");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente");
                dispatcher.forward(request,response);

       } else if (senha.length() <=0){
           request.setAttribute("cliente", "Por favor preencha sua senha");
           RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente");
           dispatcher.forward(request,response);
        }else if (perfil.length() <= 0) {
           request.setAttribute("cliente", "Por favor preencha seu perfil");
           RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente");
           dispatcher.forward(request,response);
        }else if  (email.length()<=0){
           request.setAttribute("cliente", "Por favor preencha seu email");
           RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente");
           response.getWriter().println("preencha seu e-mail");
           dispatcher.forward(request,response);
        }

       else {
           Usuario mod = new Usuario(login, senha, perfil, email);
           control.salvar(mod);
           response.sendRedirect("/listar");

       }
    }

}