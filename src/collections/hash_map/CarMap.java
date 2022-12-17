package collections.hash_map;

import collections.arraylist.Car;

import java.util.List;
import java.util.Set;

interface CarMap {

    void put(CarOwner key, Car value);

    Car get(CarOwner key);

    Set<CarOwner> keySet();

    List<Car> values();

    boolean remove(CarOwner key);

    int size();

    void clear();

}
