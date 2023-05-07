public class Car extends Vehicle {

    public Car(String name, int year) {
        super(name, year);
    }

    @Override
    public String toString() {
        return "Car[" + getName() + ", " + getYear() + "]";
    }

}