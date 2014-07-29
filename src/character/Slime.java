/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Random;

import combat.behaviors.Evade;
import combat.behaviors.SlimeGoop;
import combat.behaviors.SlimeShower;

public class Slime extends Bad {
	
	public Slime(int floorMod){
		this.name = "Slime";
		this.difMultiplier = (0.6 * floorMod);
		this.health = (50 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (12 * this.difMultiplier);
		this.speed = (5 * this.difMultiplier);
		this.armorVal = (6 * this.difMultiplier);
		this.defend = new Evade();
	}

	public void setAttackBehavior(){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1);
		if(chance <= 70){
			this.attack = new SlimeGoop();
		}
		else{
			this.attack = new SlimeShower();
		}
	}

}
