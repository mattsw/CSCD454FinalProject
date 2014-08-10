package dungeon;

import main.Command;

import combat.Combat;

import Party.Party;

public class UVineRoom extends Room {
	private boolean bossDefeated;
	
	public UVineRoom(double chestMod, Dungeon dungeon) {
		super(chestMod, dungeon);
		this.bossDefeated = false;
	}
	
	@Override
	public String toString() {
		String message = super.toString();
		
		message += "There are vines leading to the next floor in this room.";
		
		if(!bossDefeated) {
			message += "There is a boss protecting the vines, prepare for combat!\n\n";
		}
		
		return message;
	}

	@Override
	public void entered(Party goodParty, int curFloor) {
		//TODO add fight for level boss
		System.out.println(this);
		System.out.println("Enter your choice, or type help.\n");
		Command command = new Command(this);
		command.execute();
	}

}
