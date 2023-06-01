package Task_13_OOP;

public class Animal
{
    String name;
    private String dateOfBirth;
    String commands;

    private void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public Animal(String name, String dateOfBirth, String commands)
    {
        this.name = name;
        this.setDateOfBirth(dateOfBirth);
        this.commands = commands;
    }

    public String toString() {
        return "Меня зовут" + name + ". " ;
    }
    protected void speech() {
        System.out.print(toString());
        System.out.println("");
    }

    public int yearOfBirth(){
        String[] birth = dateOfBirth.split("");
        String yearString = birth[6] + birth[7] + birth[8] + birth[9];
        int yearInt = Integer.parseInt(yearString);
        return yearInt;
    }

}