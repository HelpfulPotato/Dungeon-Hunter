package structure.basic;

public class Attribute extends Component{
	public static final float critRate = 1.5f;
	private int hp;
	private int maxHp;
	private int strength;
	private int armor;
	private float critChance;
	private float hpAbsorb;
	private float blockChance;
	private float blockRate;
	private float counterChance;
	private float comboChance;
	private float dodgeChance;
	private float pierceRate;

	public Attribute(int hp, int maxHp, int strength, int armor, float critChance, float hpAbsorb, float blockChance,
					 float blockRate, float counterChance, float comboChance, float dodgeChance, float pierceRate) {
		this.hp = hp;
		this.maxHp = maxHp;
		this.strength = strength;
		this.armor = armor;
		this.critChance = critChance;
		this.hpAbsorb = hpAbsorb;
		this.blockChance = blockChance;
		this.blockRate = blockRate;
		this.counterChance = counterChance;
		this.comboChance = comboChance;
		this.dodgeChance = dodgeChance;
		this.pierceRate = pierceRate;
	}

	public float getPercent() {
		return (float) hp / (float) maxHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hitPoint) {
		this.hp = hitPoint;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public float getCritChance() {
		return critChance;
	}

	public void setCritChance(float critChance) {
		this.critChance = critChance;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}

	public float getHpAbsorb() {
		return hpAbsorb;
	}

	public void setHpAbsorb(float hpAbsorb) {
		this.hpAbsorb = hpAbsorb;
	}

	public float getBlockChance() {
		return blockChance;
	}

	public void setBlockChance(float blockChance) {
		this.blockChance = blockChance;
	}

	public float getBlockRate() {
		return blockRate;
	}

	public void setBlockRate(float blockRate) {
		this.blockRate = blockRate;
	}

	public float getComboChance() {
		return comboChance;
	}

	public void setComboChance(float comboChance) {
		this.comboChance = comboChance;
	}
}
