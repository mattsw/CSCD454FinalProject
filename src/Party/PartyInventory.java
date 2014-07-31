package Party;

import java.util.ArrayList;

import Inventory.Consumables.Consumable;
import Inventory.Equipables.IEquipable;

public class PartyInventory {
	
	private static PartyInventory inventory = null;
	
	int maxItems;
	int itemCount;
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
			//More coming
		}
	}
	
	public void displayEquipables(){
		int i = 0;
		for(IEquipable item:equipables){
			System.out.println(i+". "+item.getItemType());
		}
	}
	
	public void displayConsumables(){
		int i = 0;
		for(Consumable item:consumables){
			System.out.println(i+". "+item.getType());
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
			equipables.add(item);
		}
	}
	
	public void addConsumable(Consumable item){
		if(itemCount == maxItems){
			System.out.println("No more inventory space!");
		}
		else{
			consumables.add(item);
		}
	}
}
