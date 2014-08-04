/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.*;

import character.*;

public class GoodParty extends Party{
	
	public GoodParty(int [] choices){
		this.members = new ArrayList<character.Character>();
		this.size = 3;
		addMembers(choices);
	}
	
	public void addEXP(int EXP){
		for(character.Character character: this.members){
			character.addEXP(EXP);
		}
	}
	
	private void addMembers(int [] choices){
		Scanner input = new Scanner(System.in);
		String name;
		for(int i = 0; i < choices.length; i++){
			if(choices[i] == 1){
				System.out.print("Name your Warrior: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Warrior(name));
			}
			else if(choices[i] == 2){
				System.out.print("Name your Wizzard: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Wizzard(name));
			}
			else if(choices[i] == 3){
				System.out.print("Name your Thief: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Thief(name));
			}
			else if(choices[i] == 4){
				System.out.print("Name your Shaman: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Shaman(name));
			}
			else{
				System.out.print("Name your Paladin: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Paladin(name));
			}
		}
		input.close();
	}
	
	public void useItem(){
		int itemType = getItemTypeChoice();
		System.out.println("Which hero do you want to use an item on?");
		int heroIndex = getCharacter();
		if(itemType == 1){
			this.inventory.useConsumable(members.get(heroIndex));
		}
		else{
			this.inventory.useEquipable(members.get(heroIndex));
		}
	}
	
	public int getCharacter(){
		Scanner getChoice = new Scanner(System.in);
		int choice = -1;
		
		System.out.println("1. "+this.members.get(0).getName());
		System.out.println("2. "+this.members.get(1).getName());
		System.out.println("3. "+this.members.get(2).getName());
		
		while(choice < 1 || choice > 3){
			System.out.print("Choose the number of your Hero(Example: 2 = "+this.members.get(1).getName()+":");
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
					choice = 0;
				}
				else if(choice == 2){
					choice = 1;
				}
				else{
					choice = 2;
				}
			}
		}
		getChoice.close();
		return choice;
	}
	
	public int getItemTypeChoice(){
		
		Scanner getChoice = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("What type of item do you wish to use?");
		System.out.println("1. Consumable");
		System.out.println("2. Equipable");
		
		while(choice < 1 || choice > 2){
			System.out.print("Choose your item type(example 2 = Equipable): ");
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
		}
		getChoice.close();
		return choice;
	}
}
