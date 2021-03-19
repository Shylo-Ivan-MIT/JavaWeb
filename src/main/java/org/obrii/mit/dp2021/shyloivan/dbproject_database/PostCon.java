/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject_database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Користувач
 */
public class PostCon {
    
private Logger logger;
    private Statement statement;
    private Connection conn;
    int id = 1;
    public PostCon() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection("jdbc:postgresql://obrii.org:5432/db2021mit21s19", "s19", "5496");
            this.conn.setAutoCommit(false);
            this.statement = this.conn.createStatement();
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        sql("CREATE TABLE IF NOT EXISTS ("
                        + "id integer primary key not null, "
                        + "name text not null, "
                        + "age integer not null "
                        + ");");
  
    }
   
    public void sql(String stok){
        try{
            statement.executeUpdate(stok);
            conn.commit();
        }
        catch(SQLException e){
             logger.log(Level.WARNING, null, e);
        }
    }
    
    public List<DataClassForDB> readData() {
        try {
            ResultSet result = this.statement.executeQuery("SELECT * FROM customers");
            List<DataClassForDB> data = new ArrayList<>();

            while (result.next()) {
                data.add(new DataClassForDB(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age")
                ));
            }

            return data;
        } 
        catch (SQLException e) {
            this.logger.log(Level.WARNING, e.toString());
            return new ArrayList<>();
        }
        
    }

    public void createData(DataClassForDB data) {
        List<DataClassForDB> datasize = this.readData();
        if(datasize.size()==0){
            id=1;
        }
        data.setId(this.id);
        id=id+1;
        sql(String.format("INSERT INTO customers (id, name, age) VALUES (%d, '%s', %d);",
                data.getId(), data.getName(), data.getAge()));
    }

    public void deleteData(int id) {        
        sql("DELETE FROM customers WHERE id=" + id);
    }
    
    public void updateData(int id, DataClassForDB data) {  
        sql(String.format("UPDATE customers "
                        + "SET name='" + data.getName() + "' , "
                        + "age=" + data.getAge()
                + "WHERE id="+id)
        );
    }
    
    public List<DataClassForDB> searchData(String phrase) {
        List<DataClassForDB> newData = new ArrayList<>();
        for (DataClassForDB d : this.readData()) {
            if(d.getName().contains(phrase)){
                newData.add(d);}
        }
            return newData;
    }
}
