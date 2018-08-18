package atomic;

import enums.State;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AtomicState {
    private State state;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public AtomicState(State state) {
        this.state = state;
    }

    public State getState() {
        try {
            lock.readLock().lock();
            return state;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setState(State state) {
        lock.writeLock().lock();
        this.state = state;
        lock.writeLock().unlock();
    }
}
