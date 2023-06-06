package Task_14_java.controller;

import Task_14_java.model.Counter;
import Task_14_java.model.DatabaseAdd;
import Task_14_java.model.DatabaseRead;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessing {
    private static boolean monthCheck(String data) {
        boolean monthCheck = true;
        String monthString = data;
        try {
            int monthInt = Integer.parseInt(monthString);
            if (monthInt < 1){
                monthCheck = false;
            } else if (monthInt > 12) {
                monthCheck = false;
            }
            return monthCheck;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    private static int monthInt(String data) {
        String monthString = data;
        try {
            int month = Integer.parseInt(monthString);
            return month;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    private static boolean dayCheck(String day, String month) {
        boolean dayCheck = true;
        String dayString = day;
        int monthInt = monthInt(month);
        try {
            int dayInt = Integer.parseInt(dayString);
            if (dayInt < 1){
                dayCheck = false;
            } else if (dayInt > 31) {
                dayCheck = false;
            } else if (monthInt == 2) {
                if (dayInt > 29){
                    dayCheck = false;
                }
            } else if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) {
                if (dayInt > 30){
                    dayCheck = false;
                }
            }
            return dayCheck;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    private static boolean yearCheck(String data) {
        boolean yearCheck = true;
        String  yearString = data;
        try {
            int yearInt = Integer.parseInt(yearString);
            int curYear = Year.now().getValue();
            if (yearInt < 1950){
                yearCheck = false;
            } else if (yearInt > curYear) {
                yearCheck = false;
            }
            return yearCheck;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }


    public void inputValidation(String type, String name, String year, String month, String day){
        String AnimalType = type;
        String AnimalName = name;
        String AnimalYear = year;
        String AnimalMonth = month;
        String AnimalDay = day;

        if (AnimalName == " " || AnimalName == "") {
            try {
                throw new RuntimeException("Кличка не заполнена");
            } catch (Exception e) {
                System.out.println("Введена пустая строка в кличке");
                throw e;
            }
        } else if (!monthCheck(AnimalMonth)) {
            try {
                throw new RuntimeException("Некорректный месяц даты рождения");
            } catch (Exception e) {
                System.out.println("Месяц даты рождения должен быть от 1 до 12");
                throw e;
            }
        } else if (!dayCheck(AnimalDay, AnimalMonth)) {
            try {
                throw new RuntimeException("Некорректный день даты рождения");
            } catch (Exception e) {
                System.out.println("Некорректный день даты рождения");
                throw e;
            }
        } else if (!yearCheck(AnimalYear)) {
            try {
                throw new RuntimeException("Некорректный год даты рождения");
            } catch (Exception e) {
                System.out.println("Некорректный год даты рождения");
                throw e;
            }
        }
        String[] dataArray = { AnimalType, AnimalName, AnimalDay + '-' + AnimalMonth + '-' + AnimalYear};
        inputWrite(dataArray);
    }

    private void inputWrite(String[] data){
        DatabaseAdd add = new DatabaseAdd();
        Counter getId = new Counter();
        String id = getId.add();
        String[] dataOutput= {id, data[0], data[1], data[2]};
        add.add(dataOutput);
    }


    public void newCommandInput(String id, String data) throws IOException {
        String inputId = id;
        DatabaseRead read = new DatabaseRead();
        DatabaseAdd add = new DatabaseAdd();
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
            add.commandAdd(inputId,data);
        }
    }

}
