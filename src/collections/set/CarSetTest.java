package collections.set;

import collections.arraylist.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    CarSet<Car> car;

    @Before
    public void setUp() {
        car = new CarSetImpl<>();
        for (int i = 0; i < 100; i++) {
            car.add(new Car("Brand", i));
        }
    }

    @Test
    public void add() {
        assertEquals(100, car.size());
        assertTrue(car.add(new Car("Brand", 200)));
        assertFalse(car.add(new Car("Brand", 200)));
        assertFalse(car.add(new Car("Brand", 200)));
        assertEquals(101, car.size());
    }

    @Test
    public void remove() {
        assertTrue(car.remove(new Car("Brand", 99)));
        assertEquals(99, car.size());
        assertFalse(car.remove(new Car("Brand", 200)));
    }

    @Test
    public void clear() {
        car.clear();
        assertEquals(0, car.size());
    }

    @Test
    public void size() {
        car.add(new Car("Brand", 7));
        assertEquals(100, car.size());
    }

    @Test
    public void forEach() {
        int index = 0;
        for (Object car : car) {
            index++;
        }
        assertEquals(index,car.size());
    }

    @Test
    public void containsElement() {
        assertTrue(car.contains(new Car("Brand", 1)));
        assertFalse(car.contains(new Car("Brand1", 1)));
    }
}