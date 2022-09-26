package collections.arraylist;

public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car("Bmw", 1);
        Car car2 = new Car("Bmw", 2);
        Car car3 = car2;
        System.out.println(car1 == car2);
        System.out.println(car1.equals(car2));

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());


        System.out.println(car3 == car2);
    }
}
