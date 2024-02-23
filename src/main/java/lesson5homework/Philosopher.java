package lesson5homework;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final CountDownLatch countDownLatch;
    private final Fork leftFork;
    private final Fork rightFork;

    private void unlockFork(Fork fork) {
        try {
            fork.unlock();
        } catch (Throwable ignored) {
            System.out.printf("Error unlocking fork for %s", getName());
        }
    }

    public Philosopher(CountDownLatch countDownLatch, Fork leftFork, Fork rightFork, String name) {
        this.countDownLatch = countDownLatch;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        setName(name);
    }

    @Override
    public void run() {
        countDownLatch.countDown();
        try {
            String threadName = getName();
            System.out.printf("Philosopher %s waits his friends...\n", threadName);
            countDownLatch.await();
            System.out.printf("Philosopher with name %s started\n", threadName);
            for (int i = 0; i < 3;) {
                boolean isLeftLocked = false;
                boolean isRightLocked = false;
                try {
                    isLeftLocked = leftFork.tryLock();
                    isRightLocked = rightFork.tryLock();
                    if (isLeftLocked && isRightLocked) {
                        int attemptNumber = i + 1;
                        System.out.printf("Philosopher with name %s eats in %d time...\n", threadName, attemptNumber);
                        sleep(2000);
                        System.out.printf("Philosopher with name %s finished eating in %d time\n", threadName, attemptNumber);
                        i++;
                    }
                    else {
                        System.out.printf("Philosopher with name %s thinking...\n", threadName);
                        sleep(1000);
                    }

                } finally {
                    if (isLeftLocked) unlockFork(leftFork);
                    if (isRightLocked) unlockFork(rightFork);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
