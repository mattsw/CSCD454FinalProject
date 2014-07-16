package Inventory.Consumables;

public class SuperPotion extends Consumable {
	private int healthRestore = 70;

	public SuperPotion(){
		this.name = "Super Potion";
	}
	
	int Consume() {
		return healthRestore;
	}
	
	
}
