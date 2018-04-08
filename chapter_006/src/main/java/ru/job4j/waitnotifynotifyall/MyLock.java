package ru.job4j.waitnotifynotifyall;

public class MyLock {
    private boolean isLocked = false;
    private Thread lockedBy = null;

    public synchronized void lock() {
        try {
            while (isLocked) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (lockedBy == Thread.currentThread()) {
            isLocked = false;
            this.notifyAll();
        }
    }
}
