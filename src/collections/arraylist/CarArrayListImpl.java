package collections.arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayListImpl<T> implements CarList<T> {
    public Object[] array = new Object[10];
    int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public boolean add(T car) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] =  car;
        size++;
        return true;
    }

    @Override
    public void add(T car, int index) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
//        for (int i = size; i > index; i--) {
//            array[i] = array[i - 1];
//        }
        array[index] =  car;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }
        };
    }

    @Override
    public boolean remove(T car) {
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
    public boolean contains(T car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
