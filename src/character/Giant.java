/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Random;

import combat.behaviors.Block;
import combat.behaviors.GiantCrush;
import combat.behaviors.GiantPunch;
import combat.behaviors.GiantSmash;


public class Giant extends Bad {
	
	public Giant(int floorMod){
		this.name = "Giant";
		this.difMultiplier = (floorMod * 1.25);
		this.health = (120 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (25 * this.difMultiplier);
		this.speed = (12 * this.difMultiplier);
		this.armorVal = (12 * this.difMultiplier);
		this.defend = new Block();
		this.experianceWorth = (200 * this.difMultiplier);
	}
	
	public void setAttackBehavior(){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1);
		if(chance <= 40){
			this.attack = new GiantPunch();
		}
		else if(chance <= 70){
			this.attack = new GiantSmash();
		}
		else{
			this.attack = new GiantCrush();
		}
	}
}
