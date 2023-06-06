package Task_14_java.view;

public enum Commands {
    NEWAN,
    ALL,
    COM,
    NEWCOM,
    EXIT,
    NONE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
