/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.dp2021.restConsumer.controller;

import org.obrii.dp2021.restConsumer.entity.MessageEntity;
import org.obrii.dp2021.restConsumer.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 38068
 */
@Controller
public class MessageController {
    
    private String url ="http://localhost:8080/RestJPA-0.0.1-SNAPSHOT/student";
    
    @Autowired
    RestTemplate restTemplate;
    
    @PostMapping("/getMessage")
    public String getFormData(@RequestParam(value="message") 
            String message, Model model){      
        url+="?message="+message;
        Student messageEntity = restTemplate.getForObject(url, Student.class);
        model.addAttribute("message",messageEntity);
        
    return "result";
    }
    
}
