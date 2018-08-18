package model;

import atomic.AtomicState;
import enums.Key;
import enums.Rotation;
import enums.State;
import prefab.Player;
import prefab.floor.Dirt;
import prefab.wall.Stone;
import structure.basic.GameObject;
import structure.basic.Observer;
import structure.basic.Transform;
import structure.object.Enemy;
import structure.object.Floor;
import structure.object.Item;
import structure.object.Unit;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	public static final Random rand = new Random();
	public static final int changeRate = 2;
	public static final int row = 15;
	public static final int col = 15;
	private final AtomicState state = new AtomicState(State.prepare);
	private static Game instance;	// store instance for access functions like drop, don't touch it.
	private int currentLevel;
	private ArrayList<Observer> observers;
	private Player player;
	private ArrayList<Item> activeItems;  // active items
	private Floor[][] ground;
	private GameObject[][] board;

	public Game(){
		Game.instance = this;
	}

	public void initNewGame() {
		// GC all existing objects
		resetAll();

		// build floors and immutable walls
		setupFloor(currentLevel / changeRate);
		setupBorder(currentLevel / changeRate);
		setupPlayer();


		// start game
		state.setState(State.idle);
	}

	private void setupPlayer() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == null) {
					player = new Player(new Transform(i, j, Rotation.down));
					board[i][j] = player;
					return;
				}
			}
		}
	}

	private void resetAll() {
		player = null;
		board = new GameObject[row][col];
		ground = new Floor[row][col];
		activeItems = new ArrayList<>();
		state.setState(State.prepare);
		currentLevel = 1;
	}

	private void setupFloor(int type) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				switch(type) {
					case 0: ground[i][j] = new Dirt(new Transform(i, j, Rotation.down)); break;
					default: throw new TypeNotPresentException("no such type", new Throwable());
				}
			}
		}
	}

	private void setupBorder(int type) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
					switch(type) {
						case 0: board[i][j] = new Stone(new Transform(i, j, Rotation.down)); break;
						default: throw new TypeNotPresentException("no such type", new Throwable());
					}
				}
			}
		}
	}

	private void initPlayer(int x, int y) {
		player = new Player(new Transform(x, y, Rotation.up));
		board[x][y] = player;
	}

	public GameObject getBlock(int x, int y) {
		return board[x][y];
	}

	public BufferedImage getFloorImage(int x, int y) {
		return ground[x][y].getSprite().getImage();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void command(Key key) {
		switch(key) {
			case up: move(Rotation.up); break;
			case down: move(Rotation.down); break;
			case left: move(Rotation.left); break;
			case right: move(Rotation.right); break;
			case save: break;
			case load: break;
			case restart: break;
		}
	}

	private void move(Rotation rotation) {

		int ox = player.getTransform().getX();
		int oy = player.getTransform().getY();
		int x = ox;
		int y = oy;

		switch (rotation) {
			case up: x--; break;
			case down: x++; break;
			case left: y--; break;
			case right: y++; break;
		}

		// check if anything on the way
		if (board[x][y] == null) {
			// nothing, then move
			swap(ox, oy, x, y, rotation);
		}

		// check what is on the way
		GameObject go = board[x][y];
		switch (go.getTag()) {
			case item: ((Item)go).takeEffect(player); swap(ox, oy, x, y, rotation);break;
			case enemy: player.attack((Unit) go); break;
		}

	}

	public void drop(int x, int y, GameObject go) {
		board[x][y] = go;
	}

	private void swap(int ox, int oy, int x, int y, Rotation rotation) {
		board[ox][oy] = null;
		board[x][y] = player;
		player.setPosition(x, y);
		player.getTransform().setRotation(rotation);
		System.out.println("before suspend");
		suspend(State.move);
		System.out.println("after suspend " + x + " y is " + y);
	}

	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}

	public static Game instance() {
		return Game.instance;
	}

/*
	public void suspend(State state) {
		try {
			synchronized (this.state) {
				this.state.setState(state);
				while(this.state.getState() != State.idle) {
					this.state.wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
*/
	public void suspend(State state) {
		this.state.setState(state);
		System.out.println("ui thread is" + Thread.currentThread().getId());
		while(this.state.getState() != State.idle) {
			// no op
		}
	}

	public State getState() {
		return this.state.getState();
	}

	public void setState(State state) {
		this.state.setState(state);
	}

	/*
	public void notifyState(State state) {
		synchronized (this.state) {
			this.state.setState(state);
			this.state.notify();
		}
	}
	*/
}
