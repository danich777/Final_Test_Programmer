package Task_13_OOP;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_13 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик", "01.02.2020", "сидеть, кушать");
        Dog dog2 = new Dog("Бобик", "01.01.2019", "ко мне");
        Cat cat1 = new Cat("Марсик","01.01.2018","кушать");
        Humster ham1 = new Humster("Пузик", "01.01.2023", "кушать");
        Horse hor1 = new Horse("Ласточка", "01.01.2018", "хоп");
        Camel cam1 = new Camel("Персик", "01.01.2017", "брр");
        Donkey don1 = new Donkey("Иа", "01.01.2016", "сахарок");
        Donkey don2 = new Donkey("Серый", "01.01.2015", "ко мне");

        List<Animal> animals = Arrays.asList(dog1, dog2, cat1, ham1, hor1, cam1, don1, don2);
        ArrayList<Integer> years = new ArrayList<Integer>();
        for (Animal a : animals){
            years.add(a.yearOfBirth());
        }
        System.out.print("Года рождения животных: ");
        for (int year : years) {
            System.out.print(year + " ");
        }
        System.out.println("");
        System.out.println("");

        List<Dog> dogs = Arrays.asList(dog1, dog2);
        for (Dog d : dogs){
            d.introduction();
            d.speech();
        }
        cat1.introduction();
        cat1.speech();
        ham1.introduction();
        ham1.speech();
        hor1.introduction();
        hor1.speech();
        cam1.introduction();
        cam1.speech();
        List<Donkey> dons = Arrays.asList(don1, don2);
        for (Donkey dn : dons){
            dn.introduction();
            dn.speech();
        }
    }
}