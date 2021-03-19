/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.mit.dp2021.shyloivan.dbproject_single;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Користувач
 */
public class Store {
private static Store usersStorage = new Store();
    private static List<DataClassForSingle> dataList;

    private Store() {
        dataList = new ArrayList<>();
        
    }

    public static Store getUser() {
        return usersStorage;
    }

    public static List<DataClassForSingle> getStore() {
        return dataList;
    }
}
