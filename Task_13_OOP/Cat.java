package Task_13_OOP;

public class Cat extends Pet{
    public Cat(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    public void introduction() {
        System.out.print("Я - котик. ");
    }
}
