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
public class User {


    private String name;
    private String email;
    private List<String> language;
    

    public User() {
    }

    public User(String name, String email, String[] language) {
        this.name = name;
        this.email = email;
        if (language != null) this.language = Arrays.asList(language);
        //if (language != null) Collections.addAll(this.language, language);                
        
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }



    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", languages=" + language + '}';
    }

}
