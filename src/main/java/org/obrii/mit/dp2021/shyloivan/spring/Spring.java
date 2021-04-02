/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Користувач
 */
@Component

public class Spring {

    int id = 1;
    @Autowired
    SpringInt SpringInterface;

    public Spring() {
    }

    public Iterable<Data> readData() {
        return SpringInterface.findAll();
    }

    public ArrayList<Data> sortData(String s) {
        Iterable<Data> data = SpringInterface.findAll();
        Iterator<Data> iterator = data.iterator();
        ArrayList<Data> newData = new ArrayList<Data>();
        while (iterator.hasNext()) {
            Data item = iterator.next();
            if (item.getName().contains(s)) {
                newData.add(item);
            }
        }
        return newData;
    }

    public void createData(Data data) {
        SpringInterface.save(data);
    }

    public void deleteData(Integer id) {
        SpringInterface.deleteById(id);
    }

    public void updateData(Data data, Integer id) {
        Data update = SpringInterface.findById(id).get();
        update.setName(data.getName());
        update.setAge(data.getAge());
        SpringInterface.save(update);

    }
}
