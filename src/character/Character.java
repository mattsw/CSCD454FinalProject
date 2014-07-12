/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public abstract class Character {
	protected int health;
	protected int attackPwr;
	protected int armorVal;
	
	
	public int getHealth() {
		return this.health;
	}
	public int getAttackPwr() {
		return this.attackPwr;
	}
	public int getArmorVal() {
		return this.armorVal;
	}
	public void setHealth(int health) {
		if(health >= 0) {
			this.health = health;
		} else {
			this.health = 0;
		}
	}
	public void setAttackPwr(int attackPwr) {
		if(attackPwr >= 0) {
			this.attackPwr = attackPwr;
		} else {
			this.attackPwr = 0;
		}
	}
	public void setArmorVal(int armorVal) {
		if(armorVal >= 0) {
			this.armorVal = armorVal;
		} else {
			this.armorVal = 0;
		}
	}
}
