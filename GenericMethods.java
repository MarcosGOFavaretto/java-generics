
import java.util.List;

public class GenericMethods {

    public static void main(String... args) {

        notGenericMethod();
        genericMethodWithMultipleGenericNames(new String[] { "One", "Two", "Three" }, new Integer[] { 1, 2, 3 });
        genericMethodWithMultipleGenericNamesAndBounds(new String[] { "One", "Two", "Three" }, new Integer[] { 1, 2, 3 });

    }

    public static void notGenericMethod() {
        System.out.println("I am not Generic!");
    }

    /**
     * The "<T, E>" defines all "generic names" allowed on method's signature.
     */
    public static <T, E> void genericMethodWithMultipleGenericNames(T[] list, E[] list2) {
        System.out.println("I am Generic!");
    }

    /**
     * The "extends Number & Comparable" defines that all T
     * referenced classes must extends Number and Comparable one.
     */
    public static <T, E extends Number & Comparable> void genericMethodWithMultipleGenericNamesAndBounds(T[] list, E[] list2) {
        System.out.println("I am Generic with Bounds!");
    }

}