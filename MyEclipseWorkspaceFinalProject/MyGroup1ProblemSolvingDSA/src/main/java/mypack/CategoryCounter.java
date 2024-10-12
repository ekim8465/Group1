package mypack;

import java.util.*;

public class CategoryCounter {

static int counter = 0;
	
	public static void main(String[] args) {
		System.out.println("Welcome to OOD Essentials using Java");
		
		Car c1 = new Car(++counter,"honda1", "red"); //1 
		Car c2 = new Car(++counter,"honda2", "red"); //2
 		Car c3 = new Car(++counter,"honda3", "red");
		Car c4 = new Car(++counter,"honda4", "blue");
		Car c5 = new Car(++counter,"honda5", "red");
		Car c6 = new Car(++counter,"honda6", "green");
		
		Car c7 = new Car(++counter, "honda?", "black" );
		
		List<Car> cars = new ArrayList<>();
		cars.add(c1);cars.add(c2);cars.add(c3);cars.add(c4);cars.add(c5);cars.add(c6);cars.add(c7);
		
		//getCountByColor(cars); //brute force
		
		
		getCountByColorOptimized(cars);
		
	}
	
	private static void getCountByColorOptimized(List<Car> cars) { //red:4, blue:1, green:1, black:1
		Map<String, Integer> map = new HashMap<>();
		//populate the map 
		
		for(int i=0; i<cars.size(); i++) {
		 Car carObjectInCurrentIteration = cars.get(i);
		 String carColor = carObjectInCurrentIteration.getColor();
		 
		 if(!map.containsKey(carColor)) { //does map already contain the color? if not, add the key and initialize the value to 
			 map.put(carColor, 1);
		 }
		 else {
			int count = map.get(carColor);
			++count;
			map.put(carColor, count);
		 }
		}
		
		
		//print the map 
		System.out.println(map);
		
		for(Map.Entry<String, Integer> me :map.entrySet()) {
			String color = me.getKey();
			int count = me.getValue();
			System.out.println(color + ":" + count + ",");
		}
	}

	/**
	 * @param cars
	 */
	private static void getCountByColor(List<Car> cars) {  //red:4, blue:1, green:1
		int redCount = 0;
		int blueCount = 0; 
		int greenCount = 0;
		
		for(Car car : cars) {
			if(car.getColor().equals("red")) {
				++redCount;
			}
			else if(car.getColor().equals("blue")) {
				++blueCount;
			}
			else {
				++greenCount;
			}
		}
		
		System.out.println("red:"+redCount + "," + "blue:" + blueCount + "," + "green:" + greenCount);
	}
}

class Car{
	private int id; 
	private String name;
	private String color;
	
	public Car(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}