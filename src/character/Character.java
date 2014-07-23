/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public abstract class Character {
	protected double health;
	protected double curHealth;
	protected double attackPwr;
	protected double armorVal;
	protected double speed;
	
	
	public double getHealth() {
		return this.health;
	}
	public double getSpeed() {
		return this.speed;
	}
	public double getAttackPwr() {
		return this.attackPwr;
	}
	public double getArmorVal() {
		return this.armorVal;
	}
	public double getCurHealth() {
		return this.curHealth;
	}
	public void setCurHealth(int health) {
		if(health >= 0) {
			this.curHealth = health;
		} else {
			this.curHealth = 0;
		}
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
	public void setSpeed(int speed) {
		if(health >= 0) {
			this.speed = speed;
		} else {
			this.speed = 0;
		}
	}
	public boolean isAlive(){
		if(this.curHealth <= 0){
			return false;
		}
		return true;
	}
}
