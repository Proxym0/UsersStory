package entity;

public class Phone {
    private final String phones;

    public Phone(String phones) {
        this.phones = phones;
    }

    public String getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phones='" + phones + '\'' +
                '}';
    }
}
