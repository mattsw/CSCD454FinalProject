package Party;

import java.util.ArrayList;
import java.util.Scanner;

import Inventory.Consumables.Consumable;
import Inventory.Equipables.*;

public class PartyInventory {
	
	private static PartyInventory inventory = null;
	
	int maxItems;
	int itemCount;
	int consumableCount;
	int equipableCount;
	ArrayList<Consumable> consumables;
	ArrayList<IEquipable> equipables;
	
	public static  PartyInventory getInventory(){
		if(inventory == null){
			inventory = new PartyInventory();
		}
		return inventory;
	}
	
	private PartyInventory(){
		this.maxItems = 40;
		this.itemCount = 0;
		this.consumableCount = 0;
		this.equipableCount = 0;
		this.consumables = new ArrayList<Consumable>();
		this.equipables = new ArrayList<IEquipable>();
	}
	
	public void useEquipable(character.Character target){
		if(equipables.isEmpty()){
			System.out.println("You have nothing to equip!");
		}
		else{
			System.out.println("What would you like to equip?:");
			displayEquipables();
			//More coming
		}
	}
	
	public void useConsumable(character.Character target){
		if(equipables.isEmpty()){
			System.out.println("You have nothing to consume!");
		}
		else{
			System.out.println("What would you like the consume?:");
			displayConsumables();
			System.out.println("0. Exit Inventory");
			@SuppressWarnings("resource")
			Scanner getChoice = new Scanner(System.in);
			int choice = -1;
			
			while(choice < 0 || choice > this.consumableCount){
				System.out.println();
				System.out.print("Please choose the number of the item you would like to use(example: 1 = "+consumables.get(0).getType()+"): ");
				try{
					choice = getChoice.nextInt();
					System.out.println();
				}
				catch(Exception e){//Bad input
					getChoice.next();//Clear buffer
					choice = -1000;//Cause invalid message to re-prompt input
				}
				
				if(choice < 0  || choice > this.consumableCount){
					System.out.println("Invalid choice. Try again!");
				}
				else{
					if(choice != 0){
						choice = choice - 1;//For list index retrieval
						target.setCurHealth(target.getCurHealth() + consumables.get(choice).consume());
						if(target.getCurHealth() > target.getHealth()){
							target.setCurHealth(target.getHealth());
						}
						this.consumables.remove(choice);
						this.itemCount--;
					}
				}
			}
		}
	}
	
	public void displayEquipables(){
		int i = 1;
		for(IEquipable item:equipables){
			System.out.println(i+". "+item.getItemType());
			i++;
		}
	}
	
	public void displayConsumables(){
		int i = 1;
		for(Consumable item:consumables){
			System.out.println(i+". "+item.getType());
			i++;
		}
	}
	
	public void displayInventory(){
		System.out.println("EQUIPABLE ITEMS:");
		displayEquipables();
		System.out.println("CONSUMABLE ITEMS:");
		displayConsumables();
		System.out.println("Inventory slots remaining: "+(maxItems-itemCount));
	}
	
	public void addEquipable(IEquipable item){
		if(itemCount == maxItems){
			System.out.println("No more inventory space!");
		}
		else{
			this.equipables.add(item);
			this.itemCount++;
			this.equipableCount++;
		}
	}
	
	public void addConsumable(Consumable item){
		if(itemCount == maxItems){
			System.out.println("No more inventory space!");
		}
		else{
			this.consumables.add(item);
			this.itemCount++;
			this.consumableCount++;
		}
	}
}
