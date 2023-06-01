package Task_13_OOP;

public class Pet extends Animal
{
    public Pet(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }
    @Override
    public String toString() {
        return "Меня зовут " + name + ". Погладь мне пузико!" ;
    }

}