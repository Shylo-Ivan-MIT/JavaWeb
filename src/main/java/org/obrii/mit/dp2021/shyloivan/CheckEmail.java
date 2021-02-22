/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan;

/**
 *
 * @author Користувач
 */
import javax.servlet.http.HttpServletRequest;

public class CheckEmail extends App {

    @Override
    public void setUser(HttpServletRequest request, boolean checkEmail) {
        user = new User(
                
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameterValues("language"),
                checkEmail);
    }
}