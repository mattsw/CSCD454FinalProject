/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import Inventory.Equipables.*;

public abstract class Good extends Character {
	protected double xp;
	protected double nextLevel;
	protected int level;
	protected double armorMultiplier;
	protected ArmorSet armor = null; //Will implement with basic starting armor later
	
	public void addEXP(int EXP){
		if(this.isAlive()){
			this.xp = this.xp + EXP;
			if(this.xp >= this.nextLevel){
				this.nextLevel = this.nextLevel*1.5;
				this.levelUp();
			}
		}
	}
	
	public abstract void levelUp();
	
	public double getDefenceRating(){
		return armor.getDefenseRating()*this.armorMultiplier;
	}
}
