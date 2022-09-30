package collections.set;

import collections.arraylist.Car;

public interface CarSet {
    boolean add(Car car);

    boolean remove(Car car);

    void clear();

    int size();

}
