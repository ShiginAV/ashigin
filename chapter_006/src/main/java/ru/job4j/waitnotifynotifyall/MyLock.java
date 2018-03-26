package ru.job4j.waitnotifynotifyall;

public class MyLock {
    private boolean isLocked = false;

    public synchronized void lock() {
        try {
            while (isLocked) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        this.notify();
    }
}
