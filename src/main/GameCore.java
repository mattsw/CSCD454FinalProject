/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package main;

import Party.Party;
import Party.PartyFactory;
import dungeon.Dungeon;

public class GameCore {
	Dungeon curDungeon;
	PartyFactory partyFactory;
	Party goodGuys;
	
	public GameCore(Dungeon dungeon, Party goodGuys, PartyFactory partyFactory) {
		this.curDungeon = dungeon;
		this.goodGuys = goodGuys;
		this.partyFactory = partyFactory;
	}
	//entry point
	public void play() {
		System.out.println("here");
	}
}
