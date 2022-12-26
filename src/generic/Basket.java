package generic;

import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
    List<T> fruits = new ArrayList<>();

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight = weight + (fruit).getWeight();
        }
        return weight;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

//    public <T extends Fruit> int compare(Basket<?> fruit) {
//        // return Float.compare(getWeight(), fruit.getWeight());
//        if (fruit.getWeight() == getWeight()) {
//            return 0;
//        } else if (fruit.getWeight() < getWeight()) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    public int compare(Basket<?> fruit) {
        // return Float.compare(getWeight(), fruit.getWeight());
        if (fruit.getWeight() == getWeight()) {
            return 0;
        } else if (fruit.getWeight() < getWeight()) {
            return 1;
        } else {
            return -1;
        }
    }

    public static <T extends Fruit> void transfer(Basket<? extends T> src, Basket<? super T> dst) {
        dst.fruits.addAll(src.fruits);
        src.fruits.clear();
    }
}
