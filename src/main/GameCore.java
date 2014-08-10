/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package main;

import java.util.Observable;
import java.util.Observer;

import Party.Party;
import Party.PartyFactory;
import dungeon.DunBuilderDirector;
import dungeon.Dungeon;
import dungeon.Point;
import dungeon.Room;

public class GameCore implements Observer {
	private static GameCore gameCore;
	private Observable dungeon;
	private Room curRoom;
	private PartyFactory partyFactory;
	private Party goodGuys;
	private Point playerFloorPos;
	private int playerFloorNum;
	
	public static GameCore getGameCore(Observable dungeon) {
		if(gameCore == null) {
			PartyFactory partyFactory = new PartyFactory();
			Party goodGuys = partyFactory.makeGoodParty();
			gameCore = new GameCore(dungeon, goodGuys, partyFactory);
		} 
		return gameCore;
	}
	
	public static GameCore getGameCore() {
		if(gameCore == null) { //if for some reason the dungeon is not instantiated yet, give an easy dungeon
			DunBuilderDirector dunCreator = new DunBuilderDirector();
			Dungeon dungeon = dunCreator.construct(1);
			PartyFactory partyFactory = new PartyFactory();
			Party goodGuys = partyFactory.makeGoodParty();
			gameCore = new GameCore(dungeon, goodGuys, partyFactory);
		} 
		return gameCore;
	}
	
	private GameCore(Observable dungeon, Party goodGuys, PartyFactory partyFactory) {
		this.dungeon = dungeon;
		this.dungeon.addObserver(this);
		this.goodGuys = goodGuys;
		this.partyFactory = partyFactory;
	}
	//entry point
	public void play() {
		Dungeon temp = (Dungeon) dungeon;
		temp.setPlayerVertPos(0); //TODO update curRoom in a better way
		curRoom.entered(this.goodGuys, this.playerFloorNum);
	}
	public void update(Observable o, Object arg) {
		if(o instanceof Dungeon) {
			Dungeon curDungeon = (Dungeon) o;
			this.playerFloorNum = curDungeon.getCurPlayerFloor();
			this.playerFloorPos = curDungeon.getPlayerPos();
			this.curRoom = curDungeon.getCurRoom(this.playerFloorNum, this.playerFloorPos);
			curRoom.entered(this.goodGuys, this.playerFloorNum);
		}
	}
	
	
}
