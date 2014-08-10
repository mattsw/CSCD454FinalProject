package dungeon;

import main.Command;
import combat.Combat;
import Party.Party;

public class FinalBossRoom extends Room {
	
	public FinalBossRoom(double chestMod, Dungeon dungeon) {
		super(chestMod, dungeon);
	}
	
	@Override
	public String toString() {
		String message = super.toString();
		message += "You have finally found the boss of this cave network!\n" +
				"You ready your weapons and charge!\n";
		
		return message;
	}

	@Override
	public void entered(Party goodParty, int curFloor) {
		System.out.println(this);
		//TODO fight final boss.  game ends after boss is defeated
		
		System.exit(0); //TODO end game better
	}
}
