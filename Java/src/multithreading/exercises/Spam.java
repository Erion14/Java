package multithreading.exercises;

import java.io.IOException;
import java.util.Scanner;

import java.util.Scanner;

public class Spam {
    private long[] intervals;
    private String[] messages;

    public Spam(long[] intervals, String[] messages) {
        if (intervals.length != messages.length) {
            throw new IllegalArgumentException("Number of intervals and messages should be the same");
        }

        this.intervals = intervals;
        this.messages = messages;
    }

    public void startSpam() {
        Thread spamThread = new Thread(() -> {
            for (int i = 0; i < intervals.length; i++) {
                if (waitForEnter()) {
                    break;
                }

                System.out.println(messages[i]);

                try {
                    Thread.sleep(intervals[i]);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        spamThread.start();
    }

    private boolean waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to stop spam...");

        try {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 5000) {
                if (System.in.available() > 0 && System.in.read() == '\n') {
                    return true;
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        return false;
    }


    public static void main(String[] args) {
        long[] intervals = {500, 1000, 1500, 2000, 2500};
        String[] messages = {"Message 1", "Message 2", "Message 3", "Message 4", "Message 5"};

        Spam spam = new Spam(intervals, messages);
        spam.startSpam();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Imitating pressing Enter...");
        System.out.println();
    }
}
