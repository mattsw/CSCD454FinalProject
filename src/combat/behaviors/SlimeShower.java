/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package combat.behaviors;

import java.util.Random;

public class SlimeShower implements AttackBehavior{
	public double attack(double atkPower, String atName, String dfName){
		System.out.println(atName+" explodes a piece of itself showering toxic goo on "+dfName);
		Random rand = new Random();
		if(rand.nextInt(100) + 1 < 20){
			System.out.println("The attack misses!");
			return 0;
		}
		return (rand.nextInt(8) + 1) + atkPower;
	}
}
