/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Ogre extends Bad {
	
	public Ogre(int level){
		this.difMultiplier = (0.75 * level);
		this.health = (40 * this.difMultiplier);
		this.attackPwr = (10 * this.difMultiplier);
		this.speed = (4 * this.difMultiplier);
		this.armorVal = (10 * this.difMultiplier);
	}
}
