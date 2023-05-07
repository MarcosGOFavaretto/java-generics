
/**
 * Beetween the diamond operator "<>" are defined all type parameters (also
 * known as type variables). By convention, its names are sigle and uppercase letters.
 * 
 * Common type variable's names are:
 * - E: Reference to "Elements".
 * - K: Reference to "Key".
 * - N: Reference to "Number".
 * - T: Reference to "Type".
 * - V: Reference to "Value".
 * 
 * An "GenericBox<String> stringBox" is a parameterized type of GenericBox<T>.
 * An "GenericBox box" is a raw type of GenericBox<T> (avoid raw types if possible).
 * 
 */
public class GenericBox<T> {

    private T item;

    public GenericBox() {
    }

    public GenericBox(T item) {
        this.setItem(item);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return getItem().toString();
    }

}