package Task_14_java.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DatabaseRead {
    public String DatabaseGet(){
        StringBuilder content = new StringBuilder();
        int nextChar;
        String result = null;

        try(FileReader reader = new FileReader("Task_14_java/model/animalDatabase.txt"))
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

    public boolean idCheck(String id, List<String> data){
        String idForCheck = id;
        List<String> dataInput = data;
        String[] idArray = new String[dataInput.size()];
        for (int i = 0; i < dataInput.size(); i++) {
            idArray[i] = dataInput.get(i);
        }
        boolean result = false;
        for (int i = 0; i < idArray.length; i++) {
            if(idForCheck.contains(idArray[i])){
                result = true;
                break;
            }
        }

        return result;
    }

    public String commandsRead(String id){
        StringBuilder content = new StringBuilder();
        String fileName = id;
        String result = null;
        int nextChar;
        String path = "Task_14_java/model/commandsDatabase/"+ fileName + ".txt";
        if (Files.exists(Path.of(path))) {
            try(FileReader reader = new FileReader(path))
            {
                while ((nextChar = reader.read()) != -1) {
                    content.append((char) nextChar);
                }
                result = String.valueOf(content);
                result = "Cписок команд: " + result;
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } else {
            result = "Животное еще не обучено, но всё в ваших руках!";
        }
        return result;
    }
}
