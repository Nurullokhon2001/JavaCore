package collections.set;

import collections.arraylist.Car;
import collections.arraylist.CarCollections;

public interface CarSet<T> extends CarCollections<T> {
    boolean add(T car);

    boolean remove(T car);

    void clear();

    int size();

    boolean contains(T car);

}
