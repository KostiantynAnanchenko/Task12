package Task12;


public class FizzBuzzMultithreaded {
    private int n;
    private int current;


    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        this.current = 1;
    }

    public static void main(String[] args) {

        FizzBuzzMultithreaded test = new FizzBuzzMultithreaded(15);

        Thread threadA = new Thread(() -> {
            try {
                test.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                test.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                test.fizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                test.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public synchronized void fizz() throws InterruptedException {

        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                System.out.printf("Fizz  ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {

        while (current <= n) {
            if (current % 5 == 0 && current % 3 != 0) {
                System.out.printf("Buzz  ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }

    }

    public synchronized void fizzBuzz() throws InterruptedException {

        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                System.out.printf("FizzBuzz  ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {

        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                System.out.printf(String.valueOf(current+"  "));
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }


}