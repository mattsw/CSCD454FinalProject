package dungeon;

import main.Command;
import combat.Combat;
import Party.Party;

public class StartRoom extends Room {
	public StartRoom(double chestMod, Dungeon dungeon) {
		super(chestMod, dungeon);
	}
	
	@Override
	public String toString() {
		String message = "You arrive in a complex cave network.  You feel" +
				"an unexplainable urge to find the master of these caves and slay it!\n";
		message += super.toString();
		
		return message;
	}

	@Override
	public void entered(Party goodParty, int curFloor) {
		System.out.println(this);
		System.out.println("Enter your choice, or type help.\n");
		Command command = new Command(this);
		command.execute();
	}
}
