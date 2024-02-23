package lesson5homework;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Fork fork1_2 = new Fork();
        Fork fork5_1 = new Fork();
        Fork fork3_2 = new Fork();
        Fork fork4_3 = new Fork();
        Fork fork5_4 = new Fork();
        List<Philosopher> philosophers = List.of(
                new Philosopher(countDownLatch, fork5_1, fork1_2, "1"), //p1
                new Philosopher(countDownLatch, fork1_2, fork3_2, "2"), //p2
                new Philosopher(countDownLatch, fork3_2, fork4_3, "3"), //p3
                new Philosopher(countDownLatch, fork4_3, fork5_4, "4"), //p4
                new Philosopher(countDownLatch, fork5_4, fork5_1, "5")  //p5
        );
        philosophers.forEach(Thread::start);
    }
}
