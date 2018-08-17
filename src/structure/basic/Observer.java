package structure.basic;

import enums.GameEvent;

/**
 * An interface that allows an object to receive updates from the object
 * they listen to.
 */
public interface Observer {
    void update(Object observable, GameEvent e);
}