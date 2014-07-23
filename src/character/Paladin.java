/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Paladin extends Good {
	
	public Paladin(){
		this.health = 50;
		this.curHealth = this.health;
		this.attackPwr = 10;
		this.speed = 5;
		this.level = 1;
		this.armorMultiplier = 1;
		this.nextLevel = 500;
		this.xp = 0;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void levelUp(){
		this.health = this.health + 8;
		this.attackPwr = this.attackPwr +1;
		this.speed = this.speed +  1;
		this.level = level + 1;
	}
}
