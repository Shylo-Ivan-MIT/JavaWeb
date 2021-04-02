/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Користувач
 */
@WebServlet(name = "NewFormServlet", urlPatterns = {"/fileform"})
public class NewFormServlet extends HttpServlet {
    
    DataServlet dataServlet = new DataServlet();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      dataServlet.doDelete(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataServlet.doPut(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}