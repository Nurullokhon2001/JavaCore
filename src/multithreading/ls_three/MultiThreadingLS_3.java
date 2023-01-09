package multithreading.ls_three;

public class MultiThreadingLS_3 {

    static ATM ATM = new ATM(1000);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            ATM.getSum("User1", 300);
        });

        Thread thread2 = new Thread(() -> {
//            try {
//                thread1.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            ATM.getSum("User2", 400);
        });

        Thread thread3 = new Thread(() -> {

//            try {
//                thread2.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            ATM.getSum("User3", 500);
        });

        thread1.start();
        thread2.start();
        thread3.start();



//        Thread thread = new Thread(() -> {
//            try {
//                thread1.join();
//                thread2.join();
//                thread3.join();
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        });
//
//        thread.setDaemon(true);
//        thread.start();

    }
}
