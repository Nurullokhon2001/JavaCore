package generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    @Test
    public void testBasket() {
        Basket<Orange> oranges = new Basket<>();
        Basket<Apple> apples = new Basket<>();
        Basket<Fruit> fruits = new Basket<>();
        for (int i = 0; i < 10; i++) {
            oranges.add(new Orange());
            apples.add(new Apple());
        }
        assertEquals(15f, oranges.getWeight(), 0.001);
        assertEquals(10f, apples.getWeight(), 0.001);
        assertEquals(1, oranges.compare(apples));
        Basket.transfer(oranges, fruits);
        Basket.transfer(apples, fruits);
        assertEquals(25f, fruits.getWeight(), 0.001);
        assertEquals(0f, apples.getWeight(), 0.001);
        assertEquals(0f, oranges.getWeight(), 0.001);

        Basket<Orange> oranges2 = new Basket<>();
        Basket<Apple> apples2 = new Basket<>();
        for (int i = 0; i < 10; i++) {
            oranges2.add(new Orange());
            apples2.add(new Apple());
        }
        Basket.transfer(oranges2, oranges);
        Basket.transfer(apples2, apples);
        assertEquals(15f, oranges.getWeight(), 0.001);
        assertEquals(10f, apples.getWeight(), 0.001);
    }
}