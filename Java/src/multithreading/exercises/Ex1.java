package multithreading.exercises;

import java.util.concurrent.TimeUnit;

public class Ex1 {
    // Running threads in 4 different ways
    public static void main(String[] args) throws InterruptedException {

        // Using Runnable interface
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        // Extending Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Using Lambda Function
        Thread lambdaThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted. It's over!");
                    return; // Break out of the loop when interrupted
                }
            }
        });
        lambdaThread.start();

        // Using Method Reference
        Thread referenceThread = new Thread(Ex1::printThreadname);
        referenceThread.start();

        TimeUnit.SECONDS.sleep(5);
        myRunnableThread.interrupt();
    }

    private static void printThreadname() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted. It's over!");
                return; // Break out of the loop when interrupted
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted. It's over!");
                return; // Break out of the loop when interrupted
            }
        }
    }
}

class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted. It's over!");
                return; // Break out of the loop when interrupted
            }
        }
    }
}
