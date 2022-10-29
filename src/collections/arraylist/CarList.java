package collections.arraylist;

public interface CarList extends CarCollections {
    Car get(int index);

    void add(Car car,int index);

    boolean removeAt(int index);

}
