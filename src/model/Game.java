package Model;

import Structure.Basic.GameObject;

import java.util.ArrayList;

public class Game {
	public static final int row = 15;
	public static final int col = 15;
	private int currentLevel;
	private ArrayList<Observer> observers;
	private Player player;
	private ArrayList<Item> activeItems;  // active items
	private Floor[][] ground;
	private GameObject[][] board;

	public Game() {
		this.player = new Player();
	}

	private void initNewGame() {
		// GC all existing objects
		clearAll();


	}

	private void resetAll() {
		player = null;
		board = null;
		ground = null;
		activeItems = null;
		currentLevel = 1;
	}

	public GameObject getBlock(int x, int y) {
		return board[x][y];
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}0

	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}
}
