package dungeon;

import java.util.Random;

import main.Command;

import combat.Combat;

import Party.Party;

public class NormalRoom extends Room {
	protected TreasureChest chest;

	public NormalRoom(double chestMod, Dungeon dungeon) {
		super(chestMod, dungeon);
		generateChest(chestMod);
	}
	
	private void generateChest(double chestMod) {
		Random rand = new Random();
		
		if(rand.nextDouble() <= chestMod) {
			this.chest = new TreasureChest();
		} else {
			this.chest = null;
		}
	}
	
	@Override
	public String toString() {
		String message = super.toString();
		
		if(this.chest != null) {
			message += "There is a treasure chest in this room!\n\n";
		}
		
		return message;
	}
	
	
	public boolean hasChest() {
		if(this.chest != null) {
			return true;
		}
		return false;
	}
	
	public void clearChest() {
		this.chest = null;
	}

	@Override
	public void entered(Party goodParty, int curFloor) {
		Combat.chanceFight(goodParty, curFloor);
		System.out.println(this);
		System.out.println("Enter your choice, or type help.\n");
		Command command = new Command(this);
		command.execute();
	}
}
