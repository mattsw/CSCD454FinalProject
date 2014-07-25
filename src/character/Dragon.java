/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Dragon extends Bad {
	
	public Dragon(int floorMod){
		this.difMultiplier = floorMod;
		this.health = (150 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (30 * this.difMultiplier);
		this.speed = (15 * this.difMultiplier);
		this.armorVal = (15 * this.difMultiplier);
	}
}
