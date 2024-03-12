package carlos.holanda.desafiobackendolisaude.enums;

public enum Degree {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int number;

    Degree(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
