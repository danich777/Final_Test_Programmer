package Task_13_OOP;

public class Camel extends Pack_animal{
    public Camel(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    public void introduction() {
        System.out.print("Я - верблюдик. ");
    }
}
