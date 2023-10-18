package Task12;

public class Timer {
    public static void main(String[] args) {

        Thread secondCounterThread = new Thread(new SecondCounterThread());     //TEST
        Thread messageThread = new Thread(new FiveSecondMessageThread());
        secondCounterThread.start();
        messageThread.start();


    }

    static class SecondCounterThread implements Runnable {
        @Override
        public void run() {
            int counter = 0;
            while (true) {
                counter++;
                System.out.println("Current time: " + counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }


    static class FiveSecondMessageThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("5 seconds have passed.");

            }

        }

    }


}
