package multithreading.ls_one;

public class MainMultiThreading {
    public static void main(String[] args) {
        System.out.println("Start");
      //  MyThread thread = new MyThread();

//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                System.out.print(i);
//            }
//        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.print(i);

                }
            }
        });
        thread.start();
        System.out.println("Finish");
    }
}
