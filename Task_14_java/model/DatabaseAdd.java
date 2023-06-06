package Task_14_java.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class DatabaseAdd {
    public void add(String[] data){
        String[] tempInput = data;
        String type = AnimalType(tempInput[1]);
        String content = tempInput[0] + ';' + type + ';' + tempInput[1]+ ';' + tempInput[2]+ ';' + tempInput[3] + '/';
        try(FileWriter writer = new FileWriter("Task_14_java/model/animalDatabase.txt", true))
        {
            writer.write(content);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String AnimalType(String data) throws RuntimeException {
        String type = data;
        String pet = "Домашнее животное";
        String pack = "Вьючное животное";
        try {
            if(type == "Собака" | type == "Кошка" | type == "Хомяк"){
                type = pet;
            } else if (type == "Лошадь" | type == "Верблюд" | type == "Осёл") {
                type = pack;
            } else {
                throw new RuntimeException("Не смогли присвоить тип животного.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return type;
    }

    public void commandAdd(String inputId,String data) throws IOException {
        String fileName = inputId;
        String path = "Task_14_java/model/commandsDatabase/"+ fileName + ".txt";
        File file = new File(path);
        String content = "";
//create the file.
        if (file.createNewFile()){
            try(FileWriter writer = new FileWriter(path, false)) {
                content = data;
                writer.write(content);
                writer.flush();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try(FileWriter writer = new FileWriter(path, true)) {
                content = ";" + data;
                writer.write(content);
                writer.flush();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }


    }


}
