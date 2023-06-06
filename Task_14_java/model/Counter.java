package Task_14_java.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Counter {



    private String lastIdGet(){
        StringBuilder content = new StringBuilder();
        int nextChar;
        String result = null;

        try(FileReader reader = new FileReader("Task_14_java/model/Count.txt"))
        {
            while ((nextChar = reader.read()) != -1) {
                content.append((char) nextChar);
            }
            result = String.valueOf(content);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return result;

    }

    private void countWrite(String data) {

        try(FileWriter writer = new FileWriter("Task_14_java/model/Count.txt", false))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String add(){
        String id = lastIdGet();
        try {

            int temp = Integer.parseInt(id) + 1;
            id = String.valueOf(temp);
            countWrite(id);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
