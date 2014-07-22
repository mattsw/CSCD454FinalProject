/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Goblin extends Bad {

	public Goblin(int level){
		this.difMultiplier = (0.9 * level);
		this.health = (15 * this.difMultiplier);
		this.attackPwr = (8 * this.difMultiplier);
		this.speed = (7 * this.difMultiplier);
		this.armorVal = (5 * this.difMultiplier);
	}
}
