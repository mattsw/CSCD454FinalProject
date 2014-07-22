/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Giant extends Bad {
	
	public Giant(int level){
		this.difMultiplier = (level * 1.25);
		this.health = (120 * this.difMultiplier);
		this.attackPwr = (25 * this.difMultiplier);
		this.speed = (12 * this.difMultiplier);
		this.armorVal = (12 * this.difMultiplier);
	}
}
