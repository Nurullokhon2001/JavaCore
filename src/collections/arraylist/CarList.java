package collections.arraylist;

public interface CarList {
    Car get(int index);

    void add(Car car);

    boolean remove(Car car);

    boolean removeAt(int index);

    int getSize();

    void clear();
}
