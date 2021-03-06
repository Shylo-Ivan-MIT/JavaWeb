package org.obrii.mit.dp2021.shyloivan;
import java.util.List;

/**
 *
 * @author Користувач
 */
public interface CrudDataInterface {

    void createData(Data addingData);

    List<Data> readData();

    void updateData(int id, Data data);

    void deleteData(int id);

    void writeData(List<Data> data);
    
    public List<Data> sortData(String phrase);

}