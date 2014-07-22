/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Dragon extends Bad {
	
	public Dragon(int level){
		this.difMultiplier = level;
		this.health = (150 * this.difMultiplier);
		this.attackPwr = (30 * this.difMultiplier);
		this.speed = (15 * this.difMultiplier);
		this.armorVal = (15 * this.difMultiplier);
	}
}
