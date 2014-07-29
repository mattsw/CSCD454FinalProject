/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Random;

import combat.behaviors.DragonClaw;
import combat.behaviors.DragonFlame;
import combat.behaviors.DragonTail;
import combat.behaviors.Evade;

public class Dragon extends Bad {
	
	public Dragon(int floorMod){
		this.name = "Dragon";
		this.difMultiplier = floorMod;
		this.health = (150 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (30 * this.difMultiplier);
		this.speed = (15 * this.difMultiplier);
		this.armorVal = (15 * this.difMultiplier);
		this.defend = new Evade();
	}
	
	public void setAttackBehavior(){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1);
		if(chance <= 40){
			this.attack = new DragonClaw();
		}
		else if(chance <= 70){
			this.attack = new DragonTail();
		}
		else{
			this.attack = new DragonFlame();
		}
	}
}
