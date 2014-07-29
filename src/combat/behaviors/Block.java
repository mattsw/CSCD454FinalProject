/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package combat.behaviors;

import java.util.Random;

public class Block implements DefenseBehavior{
	public boolean defend(double speed, String name){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1) + speed/2;
		if(chance > 80){
			System.out.println(name+" has blocked the attack!");
			return true;
		}
		return false;
	}
}
