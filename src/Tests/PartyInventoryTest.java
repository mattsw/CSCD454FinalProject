package Tests;

import character.Wizzard;
import Inventory.ConsumableFactory;
import Inventory.EquipmentFactory;
import Inventory.ItemFactory;
import Inventory.Consumables.Consumable;
import Inventory.Equipables.Armors.ArmorPiece;
import Party.PartyInventory;

public class PartyInventoryTest {

	public static void main(String[] args) {
		PartyInventory inventory = PartyInventory.getInventory();
		ItemFactory consume = new ConsumableFactory();
		ItemFactory equip = new EquipmentFactory();
		
		Consumable potion = (Consumable)consume.generateItem("SuperPotion");
		ArmorPiece armor = (ArmorPiece)equip.generateItem("Boots", "Goblin");
		
		inventory.addConsumable(potion);
		inventory.addArmor(armor);
		
		potion = (Consumable)consume.generateItem("Potion");
		armor = (ArmorPiece)equip.generateItem("Boots", "Dragon");
		
		inventory.addConsumable(potion);
		inventory.addArmor(armor);
		
		System.out.println("TEST DISPLAY INVENTORY");
		System.out.println();
		inventory.displayInventory();
		
		character.Character wizzard = new Wizzard("Tom");
		
		System.out.println();
		System.out.println("TEST USE POTION");
		System.out.println();
		
		System.out.println("Wizzard starting health: "+wizzard.getCurHealth());
		System.out.println();
		
		wizzard.setCurHealth(3);
		
		System.out.println("Wizzard health after taking some damage: "+wizzard.getCurHealth());
		System.out.println();
		
		wizzard.combatUseItem();//Use a potion
		
		System.out.println();
		System.out.println("Wizzard health after using inventory: "+wizzard.getCurHealth());
		System.out.println();
		
		System.out.println("INVENTORY AFTER USE");
		System.out.println();
		inventory.displayInventory();
	}

}
