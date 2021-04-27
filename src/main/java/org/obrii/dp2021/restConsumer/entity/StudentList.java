/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.dp2021.restConsumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 38068
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentList {
   
    @JsonProperty("student")
    private List<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "StudentList{" + "studentList=" + studentList + '}';
    }

}
