package multithreading.ls_two;

public class MultiThreadingLS_2_2 {

  private   static final int SIZE  = 50_000_000;
    private  static final int HALF  = SIZE/2;

//    public static void main(String[] args) {
//
//        Thread thread1 = new Thread(() -> {
//            list1 = new ArrayList<>();
//        });
//
//        Thread thread2 = new Thread(() -> {
////            try {
////                thread1.join();
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//            System.out.println(list1.size());
//        });
//
//        thread1.start();
//        thread2.start();
//    }


    // Homework

    public static void main(String[] args) {
        withoutConcurrency();
        withConcurrency();

    }

    private static void withoutConcurrency() {
        float[] math = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            math[i] = 1.0f;
        }

        long before = System.currentTimeMillis();

        for (int i = 0; i < math.length; i++) {
            math[i] = (float) (math[i] * Math.sin(0.2f + (float) (i / 5)) * Math.cos(0.2f + (float) (i / 5)) * Math.cos(0.4f + (float) (i / 2)));
        }

        long after = System.currentTimeMillis();

        System.out.println("withoutConcurrency " + (after - before));
    }

    private static void withConcurrency() {
        float[] math = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            math[i] = 1.0f;
        }

        long before = System.currentTimeMillis();
        float[] math1 = new float[HALF];
        float[] math2 = new float[HALF];

        System.arraycopy(math, 0, math1, 0, HALF);

        Thread thread1 = new Thread(() -> {
            long before1 = System.currentTimeMillis();
            for (int i = 0; i < math1.length-1; i++) {
                math1[i] = (float) (math1[i] * Math.sin(0.2f + (float) (i / 5)) * Math.cos(0.2f + (float) (i / 5)) * Math.cos(0.4f + (float) (i / 2)));
            }
            long after1 = System.currentTimeMillis();
            System.out.println("thread1 " + (after1 - before1));
        });

        System.arraycopy(math,HALF,math2,0,HALF );

        Thread thread2 = new Thread(() -> {
            long before2 = System.currentTimeMillis();
            for (int i = 0; i < math2.length-1; i++) {
                math2[i] = (float) (math2[i] * Math.sin(0.2f + (float) (i / 5)) * Math.cos(0.2f + (float) (i / 5)) * Math.cos(0.4f + (float) (i / 2)));
            }
            long after2 = System.currentTimeMillis();
            System.out.println("thread2 " + (after2 - before2));

        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(math1,0,math,0,HALF);
        System.arraycopy(math2,0,math,HALF,HALF);

        long after = System.currentTimeMillis();

        System.out.println("withConcurrency " + (after - before));

    }
}
