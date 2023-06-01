package Task_13_OOP;

public class Pack_animal extends Animal
{
    public Pack_animal(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    @Override
    public String toString() {
        return "Меня зовут " + name + ". Пора перевезти какой-то груз!" ;
    }

}