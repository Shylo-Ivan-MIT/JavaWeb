/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject_database;
import org.obrii.mit.dp2021.shyloivan.dbproject.*;
import java.util.List;
/**
 *
 * @author Користувач
 */
public interface DataInterfaceForDB {
public List<DataClassForDB> searchData(String s);
    public void updateData(int id, DataClassForDB data);
    public void deleteData(int id);
    public void createData(DataClassForDB addingData);
    public List<DataClassForDB> readData();
    public void writeData(List<DataClassForDB> data);
    public void stData();
}
