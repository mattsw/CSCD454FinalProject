/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Random;

import combat.behaviors.Evade;
import combat.behaviors.GoblinBow;
import combat.behaviors.GoblinStick;

public class Goblin extends Bad {

	public Goblin(int floorMod){
		this.name = "Goblin";
		this.difMultiplier = (0.9 * floorMod);
		this.health = (15 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (8 * this.difMultiplier);
		this.speed = (7 * this.difMultiplier);
		this.armorVal = (5 * this.difMultiplier);
		this.defend = new Evade();
	}
	
	public void setAttackBehavior(){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1);
		if(chance <= 70){
			this.attack = new GoblinStick();
		}
		else{
			this.attack = new GoblinBow();
		}
	}
}
