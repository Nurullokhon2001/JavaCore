package multithreading.ls_seven;

import java.util.concurrent.*;

public class MultiThreadingLS_8 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
        });

        Future<String> featureName = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Nur";
            }
        });

        Future<Integer> featureAge = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 21;
            }
        });

        String name ;
        int age;
        try {
            name = featureName.get();
            age = featureAge.get();
            System.out.println("\n Name " + name +" Age " + age);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
