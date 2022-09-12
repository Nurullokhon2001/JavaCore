package collections.arraylist;

import java.util.Arrays;

public class CarListImpl implements CarList {
    public Car[] array = new Car[10];
    int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size - 1; i++) {
            if (array[i] == car) {
                return removeAt(i);
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
