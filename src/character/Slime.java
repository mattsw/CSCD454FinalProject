/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Slime extends Bad {
	
	public Slime(int floorMod){
		this.difMultiplier = (0.6 * floorMod);
		this.health = (50 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (12 * this.difMultiplier);
		this.speed = (5 * this.difMultiplier);
		this.armorVal = (6 * this.difMultiplier);
	}
}
