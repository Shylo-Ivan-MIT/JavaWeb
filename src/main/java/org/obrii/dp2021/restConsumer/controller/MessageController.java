/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.dp2021.restConsumer.controller;

import java.util.List;
import org.obrii.dp2021.restConsumer.entity.Embedded;
import org.obrii.dp2021.restConsumer.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 38068
 */
@Controller
public class MessageController {

    private final String URL = "http://localhost:8080/RestJPA-0.0.1-SNAPSHOT/student";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getMessage")
    public String getFormData(Model model) {

        Embedded messageEntity = restTemplate.getForObject(URL, Embedded.class);

        List<Student> list = messageEntity.getListOfStudents().getStudentList();

        model.addAttribute("students", list);

        return "result";
    }

    @PostMapping("/update")
    public String updateData(@RequestParam(name = "name") String name,
            @RequestParam(name = "age") String age,
            @RequestParam(name = "url") String url,
            Model model) {

        restTemplate.put(url, new Student(name,Integer.parseInt(age)));

        return getFormData(model);
    }

}
