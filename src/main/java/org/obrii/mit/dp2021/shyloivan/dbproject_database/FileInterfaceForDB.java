/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject_database;
import org.obrii.mit.dp2021.shyloivan.dbproject.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Користувач
 */
public class FileInterfaceForDB implements DataInterfaceForDB {

    private File file;

    public FileInterfaceForDB() {
    }

    public FileInterfaceForDB(File file) {
        this.file = file;
    }

    @Override
    public void writeData(List<DataClassForDB> data) {

        try ( FileOutputStream f = new FileOutputStream(file);  ObjectOutputStream o = new ObjectOutputStream(f)) {

            data.forEach(d -> {
                try {
                    o.writeObject(d);
                } catch (IOException ex) {
                    Logger.getLogger(FileInterfaceForDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInterfaceForDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileInterfaceForDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

      @Override
    public List<DataClassForDB> searchData(String s) {

 
       
            
            List<DataClassForDB> newData = new ArrayList<>();
        for (DataClassForDB d : this.readData()) {
            
            if(d.getName().contains(s)){
                newData.add(d);}
        }
        

            return newData;
    }
    
    
    @Override
    public List<DataClassForDB> readData() {

        try ( FileInputStream f = new FileInputStream(file);  ObjectInputStream o = new ObjectInputStream(f)) {
            List<DataClassForDB> result = new ArrayList<>();
            while (f.available() > 0) {
                result.add((DataClassForDB) o.readObject());
            }

            return result;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInterfaceForDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<DataClassForDB>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileInterfaceForDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<DataClassForDB>();
        }

    }

    @Override
    public void createData(DataClassForDB addingData) {
        List<DataClassForDB> data = this.readData();
        addingData.setId(data.size());
        data.add(addingData);
        this.writeData(data);

    }

    @Override
    public void deleteData(int id) {        
        List<DataClassForDB> newData = new ArrayList<>();
        for (DataClassForDB d : this.readData()) {
            if (d.getId() != id) {
                newData.add(d);
            }
        }
        this.writeData(newData);
    }
    
    @Override
    public void updateData(int id, DataClassForDB data) {        
        List<DataClassForDB> newData = new ArrayList<>();
        data.setId(id);
        for (DataClassForDB d : this.readData()) {
            if (d.getId() != id) {
                newData.add(d);
            } else{ newData.add(data); }
        }
        this.writeData(newData);
    }

       public void stData() {        
        List<DataClassForDB> newData = new ArrayList<>();
        int i = 0;
        for (DataClassForDB d : this.readData()) {
            d.setId(i);
            i++;
                newData.add(d);
            
        }
        this.writeData(newData);
    }

    
    public File getFile() {
        return file;
    }

    public void setFileName(File file) {
        this.file = file;
    }

}
