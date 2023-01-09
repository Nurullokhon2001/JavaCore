package multithreading.ls_five;

public class Counter {
    int count;

    public void inc() {
        count++;
    }

    public void dec() {
        count--;
    }

    public void getCount() {
        System.out.println(count);
    }
}
