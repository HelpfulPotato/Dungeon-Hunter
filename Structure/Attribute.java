package Structure;

public class Attribute extends Component{
	private GameObject parent;
	private int hitPoint;
	private int strength;
	private int armor;

	public Attribute(GameObject parent, int hitPoint, int strength, int armor) {
		super(parent);
		this.hitPoint = hitPoint;
		this.strength = strength;
		this.armor = armor;
	}

	public GameObject getParent() {
		return parent;
	}

	public int getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(int hitPoint) {
		this.hitPoint = hitPoint;
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
}
