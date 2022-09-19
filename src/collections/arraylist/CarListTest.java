package collections.arraylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    public CarList car;

    @org.junit.Before
    public void setUp() throws Exception {
        car = new CarArrayListImpl();
        for (int i = 0; i < 100; i++) {
            car.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, car.getSize());
    }

    @Test
    public void removeOneElements() {
        assertEquals(100, car.getSize());
        assertTrue(car.remove(new Car("Brand" + 5, 5)));
        assertEquals(99, car.getSize());
        car.add(new Car("Brand" + 5, 5));
    }

    @Test
    public void removeOneElementsByIndex() {
        assertEquals(100, car.getSize());
        assertTrue(car.removeAt(5));
        assertEquals(99, car.getSize());
        car.add(new Car("Brand" + 5, 5));
    }

    @Test
    public void clearAllArray() {
        car.clear();
        assertEquals(0, car.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOfBound() {
        car.get(101);
    }

    @Test
    public void insertInMiddle() {
        Car cars = new Car("Range Rover", 777);
        car.add(cars, 50);
        assertEquals(car.get(50).getBrand(), cars.getBrand());
    }

    @Test
    public void insertInEnd() {
        Car cars = new Car("Range Rover", 777);
        car.add(cars, 100);
        assertEquals(car.get(100).getBrand(), cars.getBrand());
    }

    @Test
    public void insertInFirst() {
        Car cars = new Car("Range Rover", 777);
        car.add(cars, 0);
        assertEquals(car.get(0).getBrand(), cars.getBrand());
    }

}