package dungeon;

import combat.Combat;

import main.Command;
import main.GameCore;
import Party.Party;
import Party.PartyFactory;

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

		if (!bossDefeated) {
			message += "There is a boss protecting the vines, prepare for combat!\n\n";
		}

		return message;
	}

	@Override
	public void entered(Party goodParty, int curFloor) {
		System.out.println(this);
		boolean lived = true;
		if (!bossDefeated) {
			PartyFactory pFactory = new PartyFactory();
			Party bossParty = pFactory.makeBossParty(this.dungeon.getCurPlayerFloor(), "giant");
			Combat curFight = new Combat(goodParty, bossParty);
			lived = curFight.fight();
			this.bossDefeated = true;
		}
		if(!lived){
			GameCore gameCore = GameCore.getGameCore();
			gameCore.endGameKilled();
		}
		else{
			System.out.print(this);
			System.out.println("Enter your choice, or type help.\n");
			Command command = new Command(this);
			command.execute();
		}
	}

}
