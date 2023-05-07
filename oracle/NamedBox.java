public class NamedBox<N, V> {

    private N name;
    private V value;

    public NamedBox(N name, V value) {
        this.setName(name);
        this.setValue(value);
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " -> Value: " + getValue();
    }

}