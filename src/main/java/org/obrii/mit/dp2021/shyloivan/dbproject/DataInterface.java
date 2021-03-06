/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject;
import java.util.List;
/**
 *
 * @author Користувач
 */
public interface DataInterface {
public List<DataClass> searchData(String s);
    public void updateData(int id, DataClass data);
    public void deleteData(int id);
    public void createData(DataClass addingData);
    public List<DataClass> readData();
    public void writeData(List<DataClass> data);
    public void stData();
}
