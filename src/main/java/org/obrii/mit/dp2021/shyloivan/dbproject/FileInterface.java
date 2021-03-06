/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject;
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
public class FileInterface implements DataInterface {

    private File file;

    public FileInterface() {
    }

    public FileInterface(File file) {
        this.file = file;
    }

    @Override
    public void writeData(List<DataClass> data) {

        try ( FileOutputStream f = new FileOutputStream(file);  ObjectOutputStream o = new ObjectOutputStream(f)) {

            data.forEach(d -> {
                try {
                    o.writeObject(d);
                } catch (IOException ex) {
                    Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

      @Override
    public List<DataClass> searchData(String s) {

 
       
            
            List<DataClass> newData = new ArrayList<>();
        for (DataClass d : this.readData()) {
            
            if(d.getName().contains(s)){
                newData.add(d);}
        }
        

            return newData;
    }
    
    
    @Override
    public List<DataClass> readData() {

        try ( FileInputStream f = new FileInputStream(file);  ObjectInputStream o = new ObjectInputStream(f)) {
            List<DataClass> result = new ArrayList<>();
            while (f.available() > 0) {
                result.add((DataClass) o.readObject());
            }

            return result;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<DataClass>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileInterface.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<DataClass>();
        }

    }

    @Override
    public void createData(DataClass addingData) {
        List<DataClass> data = this.readData();
        addingData.setId(data.size());
        data.add(addingData);
        this.writeData(data);

    }

    @Override
    public void deleteData(int id) {        
        List<DataClass> newData = new ArrayList<>();
        for (DataClass d : this.readData()) {
            if (d.getId() != id) {
                newData.add(d);
            }
        }
        this.writeData(newData);
    }
    
    @Override
    public void updateData(int id, DataClass data) {        
        List<DataClass> newData = new ArrayList<>();
        data.setId(id);
        for (DataClass d : this.readData()) {
            if (d.getId() != id) {
                newData.add(d);
            } else{ newData.add(data); }
        }
        this.writeData(newData);
    }

       public void stData() {        
        List<DataClass> newData = new ArrayList<>();
        int i = 0;
        for (DataClass d : this.readData()) {
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
