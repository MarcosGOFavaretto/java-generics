public class Motorcycle extends Vehicle {

    public Motorcycle(String name, int year) {
        super(name, year);
    }

    @Override
    public String toString() {
        return "Motorcycle[" + getName() + ", " + getYear() + "]";
    }

}