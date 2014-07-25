/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Zombie extends Bad {
	
	public Zombie(int floorMod){
		this.difMultiplier = (0.6 * floorMod);
		this.health = (60 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (8 * this.difMultiplier);
		this.speed = (3 * this.difMultiplier);
		this.armorVal = (3 * this.difMultiplier);
	}
}
