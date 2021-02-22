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

public abstract class App {

    protected Interface user;
    public App() {
    }
    
    public void setUser(HttpServletRequest request){
        user = new User(
        request.getParameter("name"),
        request.getParameter("email"),
        request.getParameterValues("language"),false);
        
    }
    
    public abstract void setUser(HttpServletRequest request, boolean checkEmail);
    
    final public Interface getUser(){
    return user;
    }
    
}
