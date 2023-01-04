package multithreading.ls_one;

public class MultiThreadingLS_1 {
    public static void main(String[] args) {
        System.out.println("Start");
        //  MyThread thread = new MyThread();

        Thread thread = new Thread(() -> {
            System.out.print(" ssss" + Thread.currentThread().isInterrupted());
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.print(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        });

        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 100) {
                System.out.print(thread.isInterrupted());
                thread.interrupt();
                System.out.print(thread.isInterrupted());
            }
            System.out.print("n ");

        }

        System.out.println("Finish");

    }
}
