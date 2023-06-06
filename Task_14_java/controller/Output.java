package Task_14_java.controller;

import Task_14_java.model.DatabaseAdd;
import Task_14_java.model.DatabaseRead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {
    public void printAll(){
        DatabaseRead read = new DatabaseRead();
        String print = read.DatabaseGet();
        String[] printList= print.split("/\n");
        for (int i = 0; i < printList.length; i++) {
            String dataString = printList[i];
            String[] dataArray = dataString.split(";");
            String printString = "id: " + dataArray[0] + ", Тип: " + dataArray[1] + ", Класс: " + dataArray[2] + ", Кличка: " + dataArray[3] + ", Дата рождения: " + dataArray[4];
            System.out.println(printString);
        }
    }

    public void commandOutput(String id) throws IOException {
        String inputId = id;
        DatabaseRead read = new DatabaseRead();
        String database = read.DatabaseGet();
        String[] dataStrings = database.split("/\n");
        List<String> idList = new ArrayList<String>();
        for (int i = 0; i < dataStrings.length; i++) {
            String dataString = dataStrings[i];
            String[] dataArray = dataString.split(";");
            idList.add(dataArray[0]);
        }
        if(!read.idCheck(inputId,idList)){
            System.out.println("Животного с таким id нет в базе, его нельзя обучить.");
        }  else {
            System.out.println(read.commandsRead(inputId));
        }
    }
}
