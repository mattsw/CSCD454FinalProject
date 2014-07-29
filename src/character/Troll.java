/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Random;

import combat.behaviors.Evade;
import combat.behaviors.TrollSpit;
import combat.behaviors.TrollWhack;

public class Troll extends Bad {

	public Troll(int floorMod){
		this.name = "Troll";
		this.difMultiplier = (0.8 * floorMod);
		this.health = (25 * this.difMultiplier);
		this.curHealth = this.health;
		this.attackPwr = (8 * this.difMultiplier);
		this.speed = (6 * this.difMultiplier);
		this.armorVal = (8 * this.difMultiplier);
		this.defend = new Evade();
	}
	
	public void setAttackBehavior(){
		Random rand = new Random();
		double chance = (rand.nextInt(100) + 1);
		if(chance <= 70){
			this.attack = new TrollWhack();
		}
		else{
			this.attack = new TrollSpit();
		}
	}

}
