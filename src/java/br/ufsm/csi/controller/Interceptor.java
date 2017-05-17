package br.ufsm.csi.controller;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

        String uri = request.getRequestURI();

        // Aqui deve ficar especificado as requisições que o cliente poderá fazer sem estar logado.
        if(uri.endsWith("login") || uri.endsWith("autenticarUsuario") || uri.contains("resources")){
            return true;
        }

        // Se o cliente estiver logado, libera todas as requisição
        if(request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }

        response.sendRedirect("login");

        return false;
    }

}