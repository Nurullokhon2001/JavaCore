package multithreading.ls_three;

public class ATM {
    private int total;

    Object objectForSynchronized = new Object();

    public ATM(int total) {
        this.total = total;
    }

    //synchronized
    public  void getSum(String recipient, int sum) {
//        synchronized (objectForSynchronized){
//
//        }
        System.out.println(recipient + " подошел к банкомату ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (sum > total) {
            System.out.println("В банкомате недостаточно денег для " + recipient);
        } else {
            total -= sum;
            System.out.println(recipient + " вывел " + sum + " рублей " + " В банкомате остался " + total + " рублей");
            System.out.println("Current sum " + total);
        }
    }
}
