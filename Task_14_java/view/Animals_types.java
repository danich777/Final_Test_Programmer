package Task_14_java.view;

public enum Animals_types {
    DOG,
    CAT,
    HAMSTER,
    HORSE,
    CAMEL,
    DONKEY,
    NONE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
