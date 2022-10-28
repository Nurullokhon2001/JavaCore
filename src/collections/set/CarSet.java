package collections.set;

import collections.arraylist.Car;
import collections.arraylist.CarCollections;

public interface CarSet extends CarCollections {
    boolean add(Car car);

    boolean remove(Car car);

    void clear();

    int size();

    boolean contains(Car car);

}
