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
import java.io.Serializable;
import java.util.Arrays;

public class Data implements Serializable{
    
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    

    public Data() {
    }

    public Data(int id, String name, int age, String gender, String email) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + '}';
    }

}