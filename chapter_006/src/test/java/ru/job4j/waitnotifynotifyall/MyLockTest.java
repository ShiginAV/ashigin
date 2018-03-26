package ru.job4j.waitnotifynotifyall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyLockTest {
    private final int threadsNumber = 3;
    private MyLock locker = new MyLock();
    private List<String> threadsNamesList = new ArrayList<>();

    @Test
    public void executingThreadsWithCommonLock() throws InterruptedException {
        for (int i = 0; i < threadsNumber; i++) {
            new Thread(() -> {
                locker.lock();
                try {
                    threadsNamesList.add(Thread.currentThread().getName());
                } finally {
                    locker.unlock();
                }
            }).start();
        }

        Thread.sleep(500);
        assertThat(threadsNamesList.size(), is(threadsNumber));
    }
}