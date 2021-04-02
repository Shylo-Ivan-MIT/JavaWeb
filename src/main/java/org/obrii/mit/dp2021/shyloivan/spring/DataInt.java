/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.spring;
import java.util.List;
/**
 *
 * @author Користувач
 */
public interface DataInt {
 public List<Data> searchData(String s);
    public void updateData(int id, Data data);
    public void deleteData(int id);
    public void createData(Data addingData);
    public List<Data> readData();
    public void writeData(List<Data> data);
    public void stData();
}
