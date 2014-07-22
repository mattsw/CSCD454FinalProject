/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Warrior extends Good {
	public Warrior(){
		this.health = 60;
		this.attackPwr = 15;
		this.speed = 6;
		this.level = 1;
		this.armorMultiplier = 0.9;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void levelUp(){
		this.health = this.health + 7;
		this.attackPwr = this.attackPwr +2;
		this.speed = this.speed +  1;
		this.level = level + 1;
	}
}
