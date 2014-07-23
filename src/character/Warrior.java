/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public class Warrior extends Good {
	public Warrior(){
		this.health = 60;
		this.curHealth = this.health;
		this.attackPwr = 15;
		this.speed = 6;
		this.level = 1;
		this.armorMultiplier = 0.9;
		this.nextLevel = 500;
		this.xp = 0;
		//updateArmorVal();   <--for use when armor functionality is implemented
	}
	
	public void addEXP(int EXP){
		
		if(this.isAlive()){
			this.xp = this.xp + EXP;
			
			if(this.xp >= this.nextLevel){
				this.nextLevel = this.nextLevel*1.5;
				this.levelUp();
			}
		}
	}
	
	public void levelUp(){
		this.health = this.health + 7;
		this.attackPwr = this.attackPwr +2;
		this.speed = this.speed +  1;
		this.level = level + 1;
	}
}
