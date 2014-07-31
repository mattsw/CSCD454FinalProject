package Tests;

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
		
		Consumable potion = (Consumable)consume.generateItem("Potion");
		ArmorPiece armor = (ArmorPiece)equip.generateItem("Boots", "Goblin");
		
		inventory.addConsumable(potion);
		inventory.addEquipable(armor);
		
		potion = (Consumable)consume.generateItem("Potion");
		armor = (ArmorPiece)equip.generateItem("Boots", "Goblin");
		
		inventory.addConsumable(potion);
		inventory.addEquipable(armor);
		
		inventory.displayInventory();

	}

}
