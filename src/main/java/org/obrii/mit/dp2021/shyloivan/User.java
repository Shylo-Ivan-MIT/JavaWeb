/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 38068
 */
public class User implements Interface {


    private String name;
    private String email;
    private List<String> language;
    private boolean checkEmail;

    public User() {
    }

    public User(String name, String email, String[] language, boolean checkEmail) {
        this.name = name;
        this.email = email;
        if (language != null) this.language = Arrays.asList(language);
        this.checkEmail = checkEmail;              
        
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<String> getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(List<String> language) {
        this.language = language;
    }

    @Override
    public String getCheckEmail(){
        return checkEmail ? "subscribed for notifications":"not subscribed";
    }


    /*@Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", languages=" + language + "ch=," + checkEmail'}';
    }*/

}
