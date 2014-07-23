/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Shaman extends Good {
	
	public Shaman(){
		this.health = 30;
		this.curHealth = this.health;
		this.attackPwr = 12;
		this.speed = 6;
		this.level = 1;
		this.armorMultiplier = 0.6;
		this.nextLevel = 500;
		this.xp = 0;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void levelUp(){
		this.health = this.health + 5;
		this.attackPwr = this.attackPwr +1.5;
		this.speed = this.speed +  1;
		this.level = level + 1;
	}
}
