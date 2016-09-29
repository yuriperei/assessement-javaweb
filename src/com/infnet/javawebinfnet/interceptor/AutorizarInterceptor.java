/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author DesenvolvedorJava
 */
public class AutorizarInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) {

        String uri = request.getRequestURI();
        if (uri.endsWith("login") || uri.endsWith("manterUsuario") || uri.endsWith("cadastro") || uri.contains("resources")) {
            return true;
        }
        
        if(uri.endsWith("livrosWS") || uri.contains("livroWS")){
            return true;
        }

        // ....
        if (request.getSession().getAttribute("usuario") != null) {
            return true;
        }

        try {
            response.sendRedirect("login");
        } catch (IOException e) {
        }

        return false;
    }

}
