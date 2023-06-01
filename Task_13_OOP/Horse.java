package Task_13_OOP;

public class Horse extends Pack_animal{
    public Horse(String name, String dateOfBirth, String commands)
    {
        super(name, dateOfBirth, commands);
    }

    public void introduction() {
        System.out.print("Я - лошадка. ");
    }
}
