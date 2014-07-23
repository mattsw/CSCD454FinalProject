/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Troll extends Bad {

	public Troll(int level){
		this.difMultiplier = (0.8 * level);
		this.health = (25 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (8 * this.difMultiplier);
		this.speed = (6 * this.difMultiplier);
		this.armorVal = (8 * this.difMultiplier);
	}
}
