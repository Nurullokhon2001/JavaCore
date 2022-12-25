package collections.arraylist;

public interface CarList<T> extends CarCollections<T> {
    T get(int index);

    void add(T car,int index);

    boolean removeAt(int index);

}
