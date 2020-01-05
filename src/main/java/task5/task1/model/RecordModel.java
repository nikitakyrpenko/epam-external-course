package task5.task1.model;



import task5.task1.model.entities.Record;

import java.util.List;

public class RecordModel {


    public String getRecordsRepresentation(List<Record> records){
        return records.toString();
    }
}
