import java.util.List;
import java.util.ArrayList;

public class Application {

    public static void main(String... args) {

        // Box stringBox   =       new Box(new String("One"));
        // Box integerBox  =       new Box(1);
        // Box doubleBox   =       new Box(1.0d);
        // Box booleanBox  =       new Box(false);
        // Box longBox     =       new Box(1L);

        // GenericBox<String> stringBox    =       new GenericBox<String>(new String("One"));
        // GenericBox<Integer> integerBox  =       new GenericBox<>(1);
        // GenericBox<Double> doubleBox    =       new GenericBox<Double>(1.0d);
        // GenericBox<Boolean> booleanBox  =       new GenericBox<>(false);
        // GenericBox<Long> longBox        =       new GenericBox<>(1L);

        NamedBox<String, String> stringBox                  =       new NamedBox<>("String", "One");
        NamedBox<String, Integer> integerBox                =       new NamedBox<>("Integer", 1);
        NamedBox<String, Double> doubleBox                  =       new NamedBox<>("Double", 1.0d);
        NamedBox<String, Boolean> booleanBox                =       new NamedBox<>("Boolean", false);
        NamedBox<String, Long> longBox                      =       new NamedBox<>("Long", 1L);
        NamedBox<String, GenericBox<Long>> boxOfLongBox     =       new NamedBox<>("Box of Long Box", new GenericBox<>(1L));

        System.out.println(stringBox);
        System.out.println(integerBox);
        System.out.println(doubleBox);
        System.out.println(booleanBox);
        System.out.println(longBox);
        System.out.println(boxOfLongBox);

        List<NamedBox> listOfBoxes = new ArrayList<>();
        listOfBoxes.add(stringBox);
        listOfBoxes.add(integerBox);
        listOfBoxes.add(doubleBox);
        listOfBoxes.add(booleanBox);
        listOfBoxes.add(longBox);
        listOfBoxes.add(boxOfLongBox);

        NamedPallet<String, List> pallet = new NamedPallet<>("All Boxes", listOfBoxes);
        System.out.println(pallet);
        System.out.println(pallet.<String, Boolean>isBoxPresentOnPallet(booleanBox));
        System.out.println(pallet.isBoxPresentOnPallet(longBox)); // The Types does not needs to bo provided because of the Type Inference.

    } 
}