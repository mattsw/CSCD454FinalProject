/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public abstract class Bad extends Character {
	
	protected double difMultiplier;
	protected double armorVal;
	
	public double getDefenceRating(){
		return this.armorVal;
	}
	
	public boolean defend(){
		return defend.defend(this.speed, this.name);
	}
	
	public void addEXP(int EXP){
		//Not Implemented
	}
	
	public void useItem(){
		//Not Implemented
	}
	
	public void combatUseItem(){
		//Not Implemented
	}
}
