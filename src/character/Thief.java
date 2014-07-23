/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Thief extends Good {
	
	public Thief(){
		this.health = 35;
		this.curHealth = this.health;
		this.attackPwr = 7;
		this.speed = 10;
		this.level = 1;
		this.armorMultiplier = 0.5;
		this.nextLevel = 500;
		this.xp = 0;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void levelUp(){
		this.health = this.health + 5;
		this.attackPwr = this.attackPwr +1;
		this.speed = this.speed + 2;
		this.level = level + 1;
	}
}
