/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import java.util.Scanner;

import combat.behaviors.*;
import Inventory.Equipables.*;
import Party.PartyInventory;

public abstract class Good extends Character {
	protected PartyInventory inventory = PartyInventory.getInventory();
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

	public void combatUseItem(){
		inventory.useConsumable(this);
	}
	
	public boolean defend(){
		setDefenseBehavior();
		return this.defend.defend(this.speed, this.name);
	}
	
	public void setDefenseBehavior(){
		Scanner getChoice = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("What defense would do you want you use?:");
		System.out.println("1. Bock");
		System.out.println("2. Evade");
		
		
		while(choice < 1 || choice > 2){
			System.out.print("Choose your defense(example 2 = Evade): ");
			try{
				choice = getChoice.nextInt();
				System.out.println();
			}
			catch(Exception e){//Bad input
				getChoice.next();//Clear buffer
				choice = -1000;//Cause invalid message to re-prompt input
			}
			
			if(choice < 1  || choice > 2){
				System.out.println("Invalid choice. Try again!");
			}
			else{
				if(choice == 1){
					this.defend = new Block();
				}
				else{
					this.defend = new Evade();
				}
			}
		}
	}	
}
