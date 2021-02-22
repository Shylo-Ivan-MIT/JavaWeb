/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan;

import java.util.List;


public interface Interface {
    String getName();
    void setName(String name);
    
    String getEmail();
    void setEmail(String email);
    
    List<String> getLanguage();
    void setLanguage(List<String> language);
    
    
    
    String getCheckEmail();
}