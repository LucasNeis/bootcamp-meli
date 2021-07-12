public class Person implements Precedent<Person> {
    private String name;
    private String cpf;

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public int preceeds(Person other) {
        return name.compareToIgnoreCase(other.getName());
    }

    @Override
    public String toString() {
        return name + " - " + cpf;
    }
}
