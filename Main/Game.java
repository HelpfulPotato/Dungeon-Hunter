package Main;

import Structure.GameObject;
import Structure.Object.Player;
import Structure.Object.Enemy;
import Structure.Object.Item;
import Structure.Object.Floor;
import java.util.ArrayList;

public class Game {
	private static final int gridNum = 15;
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Item> items;  // active items
	private Floor[][] ground;
	private GameObject[][] board;

	public Game() {
		this.player = new Player();
	}

	private void InitNewGame() {
		// clear all
		player = new Player();
		enemies.clear();
		items
	}
}
