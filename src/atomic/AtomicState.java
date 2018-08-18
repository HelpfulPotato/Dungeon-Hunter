package atomic;

import enums.State;

public class AtomicState {
    private State state;

    public AtomicState(State state) {
        this.state = state;
    }

    synchronized public State getState() {
        return state;
    }

    synchronized public void setState(State state) {
        this.state = state;
    }
}
