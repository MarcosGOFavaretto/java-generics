
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> myStringList = Populator.populateStringList();
		List<Integer> myIntegerList = Populator.populateIntegerList();
		List<Vehicle> myVechicleList = Populator.populateVehicleList();
		List<Car> myCarList = Populator.populateCarList();
		List<Motorcycle> myMotorcycleList = Populator.populateMotorcycleList();
		List<Object> myObjectList = Populator.populateObjectList();

		processAnyList(myStringList);
		processAnyList(myIntegerList);
		processAnyList(myVechicleList);
		processAnyList(myCarList);
		processAnyList(myMotorcycleList);
		processAnyList(myObjectList);

		// processVehicleList(myStringList); Compile error: String is not a Vehicle.
		// processVehicleList(myIntegerList); Compile error: Integer is not a Vehicle.
		processVehicleList(myVechicleList);
		processVehicleList(myCarList);
		processVehicleList(myMotorcycleList);
		// processVehicleList(myObjectList); Compile error: Object is not necessary a Vehicle.

		// process(myStringList); Compile error: String is not Vehicle above.
		// process(myIntegerList); Compile error: Integer is not Vehicle above.
		processVehicleAndAboveList(myVechicleList);
		// process(myCarList); Compile error: Car is not Vehicle above.
		// process(myMotorcycleList); Compile error: Motorcycle is not Vehicle above.
		processVehicleAndAboveList(myObjectList);
		
	}

	public static void processAnyList(List<?> list) {
		
		System.out.println("-- Any --");

		for (Object obj : list) {
            System.out.println(obj);
        }

    }

	public static void processVehicleList(List<? extends Vehicle> list) {

		System.out.println("-- Vehicle and below --");

		for (Vehicle obj : list) {
            System.out.println(obj);
        }

	}

	public static void processVehicleAndAboveList(List<? super Vehicle> list) {

		System.out.println("-- Vehicle and above --");

		for (Object obj : list) {
            System.out.println(obj);
        }

	}

	public class Populator {

		public static List<String> populateStringList() {

			List<String> result = new ArrayList<>();
			result.add("One");
			result.add("Two");
			result.add("Three");
	
			return result;
		}
	
		public static List<Integer> populateIntegerList() {
	
			List<Integer> result = new ArrayList<>();
			result.add(1);
			result.add(2);
			result.add(3);
	
			return result;
		}

		public static List<Car> populateCarList() {
	
			List<Car> result = new ArrayList<>();
			result.add(new Car("Fusca", 1971));
			result.add(new Car("Gol Star", 1997));
			result.add(new Car("Onix", 2018));
	
			return result;
		}

		public static List<Motorcycle> populateMotorcycleList() {
	
			List<Motorcycle> result = new ArrayList<>();
			result.add(new Motorcycle("R3", 2023));
			result.add(new Motorcycle("R6", 2018));
			result.add(new Motorcycle("R1", 2023));
	
			return result;
		}

		public static List<Vehicle> populateVehicleList() {
	
			List<Vehicle> result = new ArrayList<>();
			result.add(new Vehicle("Skate", 2023));
			result.add(new Vehicle("Bike", 2023));
			result.add(new Vehicle("Rollers", 2023));
	
			return result;
		}

		public static List<Object> populateObjectList() {
	
			List<Object> result = new ArrayList<>();
			result.add(new Vehicle("Skate", 2023));
			result.add("Test");
			result.add(1);
	
			return result;
		}

	}

}