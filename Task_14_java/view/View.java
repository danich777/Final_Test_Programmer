package Task_14_java.view;
import Task_14_java.controller.*;
import java.util.Scanner;

public class View {

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine().toUpperCase();
    }

    private String animal_type() {
        Animals_types type = Animals_types.NONE;
        String animal = "";
        while (true) {
            String selection = prompt("Выберите класс животного:\n DOG - собака; CAT - кошка; HAMSTER - хомяк;\n HORSE - лошадь; CAMEL - верблюд; DONKEY - осёл\n");
            type = Animals_types.valueOf(selection);
            try {
                switch (type) {
                    case DOG:
                        animal = "Собака";
                        return animal;
                    case CAT:
                        animal = "Кошка";
                        return animal;
                    case HAMSTER:
                        animal = "Хомяк";
                        return animal;
                    case HORSE:
                        animal = "Лошадь";
                        return animal;
                    case CAMEL:
                        animal = "Верблюд";
                        return animal;
                    case DONKEY:
                        animal = "Осёл";
                        return animal;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }


    public void run() {
        Commands com = Commands.NONE;
        InputProcessing processing = new InputProcessing();
        Output print = new Output();
        while (true) {
            String command = prompt("Выберите команду:\n NEWAN - Завести новое животное\n ALL - Показать список всех животных\n COM - Увидеть список команд, которое выполняет животное\n NEWCOM - Обучить животное новым командам\n EXIT - Выход\n");
            try {
                com = Commands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Неизвестная команда");
                continue;
            }

            try {
                switch (com) {
                    case NEWAN:
                        System.out.println("Вы выбрали режим заведения нового животного.");
                        String type = animal_type();
                        String name = prompt("Введите кличку животного: ");
                        String year = prompt("Введите год рождения животного: ");
                        String month = prompt("Введите месяц рождения животного: ");
                        String day = prompt("Введите день рождения животного: ");
                        processing.inputValidation(type, name, year, month, day);
                        System.out.println("");
                        break;
                    case ALL:
                        System.out.println("Вы выбрали режим отображения всех животных.\n");
                        print.printAll();
                        System.out.println("");
                        break;
                    case COM:
                        System.out.println("Вы выбрали режим отображения команд.");
                        String animId = prompt("Введите id животного: ");
                        print.commandOutput(animId);
                        System.out.println("");
                        break;
                    case NEWCOM:
                        System.out.println("Вы выбрали режим обучения животного новой команде.");
                        String animalIdCom = prompt("Введите id животного: ");
                        String newCommand = prompt("Введите команду: ").toLowerCase();
                        processing.newCommandInput(animalIdCom,newCommand);
                        System.out.println("");
                        break;
                    case EXIT:
                        System.out.println("До свидания!");
                        return;
                    case NONE:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
