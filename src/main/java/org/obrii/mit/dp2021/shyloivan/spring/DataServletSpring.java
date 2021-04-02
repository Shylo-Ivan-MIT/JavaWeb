/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.spring;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


/**
 *
 * @author Користувач
 */
@WebServlet(name = "DataServlet", urlPatterns = {"/Data"})
public class DataServletSpring extends HttpServlet {

    @Autowired
    Spring Spring;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("search") != null) {
            request.setAttribute("data", Spring.sortData(request.getParameter("search")));
        } else {
            request.setAttribute("data", Spring.readData());
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Data user = new Data(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("age"))
        );
        Spring.createData(user);
        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        Data user = new Data(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("age"))
        );
        Spring.updateData(user, Integer.parseInt(request.getParameter("id")));
        doGet(request, responce);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        Spring.deleteData(Integer.parseInt(request.getParameter("id")));
        doGet(request, responce);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}