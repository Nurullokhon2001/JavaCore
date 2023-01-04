package multithreading.ls_two;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadingLS_2_1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list1.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list2.add(i);
                System.out.println(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }

        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list3.add(i);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        thread2.interrupt();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
        System.out.println(Thread.currentThread());
    }
}
