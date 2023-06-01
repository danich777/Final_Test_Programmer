package Task_13_OOP;

public class Humster extends Pet{
    public Humster(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    public void introduction() {
        System.out.print("Я - хомяк. ");
    }
}
