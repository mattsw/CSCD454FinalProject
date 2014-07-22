/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Wizzard extends Good {
	
	public Wizzard(){
		this.health = 20;
		this.attackPwr = 15;
		this.speed = 5;
		this.level = 1;
		this.armorMultiplier = 0.4;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void levelUp(){
		this.health = this.health + 5;
		this.attackPwr = this.attackPwr +2;
		this.speed = this.speed +  0.8;
		this.level = level + 1;
	}
}
