package Task_13_OOP;

public class Dog extends Pet{

    public Dog(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    public void introduction() {
        System.out.print("Я - собачка. ");
    }

}
