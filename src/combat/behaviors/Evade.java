/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package combat.behaviors;

import java.util.Random;

public class Evade implements DefenseBehavior{
	
	public boolean defend(double speed, String name){
		Random rand = new Random();
		double chance = (rand.nextInt(1000) + 1) + speed;
		if(chance > 900){
			System.out.println(name+" has evaded the attack!");
			return true;
		}
		return false;
	}
}
