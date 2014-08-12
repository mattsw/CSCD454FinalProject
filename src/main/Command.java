package main;

import java.util.Scanner;

import Inventory.Item;
import Inventory.RandomItemFactory;
import Party.PartyInventory;
import dungeon.NormalRoom;
import dungeon.DVineRoom;
import dungeon.TreasureChest;
import dungeon.UVineRoom;
import dungeon.StartRoom;
import dungeon.FinalBossRoom;
import dungeon.Room;
import dungeon.Dungeon;

public class Command {
	private String command;
	private Dungeon curDungeon;
	private PartyInventory inventory;
	Room curRoom;
	
	public Command(Room curRoom) {
		this.curRoom = curRoom;
		this.command = getCommand();
		this.curDungeon = curRoom.getDungeon();
		this.inventory = PartyInventory.getInventory();
	}
	
	private String getCommand() {
		String command = "";
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		
		while(true) {
			command = cin.nextLine();
			
			if(curRoom.hasEDoor()) {
				if (command.equalsIgnoreCase("e")) {
					break;
				}
			} else if(curRoom.hasNDoor()) {
				if (command.equalsIgnoreCase("n")) {
					break;
				}
			} else if(curRoom.hasSDoor()) {
				if (command.equalsIgnoreCase("s")) {
					break;
				}
			} else if(curRoom.hasWDoor()) {
				if (command.equalsIgnoreCase("w")) {
					break;
				}
			} else if (command.equalsIgnoreCase("help")) {
				break;
			} else if (command.equalsIgnoreCase("use")) {
				break;
			} else if(command.equalsIgnoreCase("exit")) {
				break;
			} else if(curRoom.getClass() == NormalRoom.class) {  //found at http://stackoverflow.com/questions/4294844/check-if-an-object-belongs-to-a-class-in-java
				NormalRoom temp = (NormalRoom) curRoom;
				if(temp.hasChest()) {
					if(command.equalsIgnoreCase("open")) {
						break;
					}
				}
			} else if(curRoom.getClass() == DVineRoom.class) {
				if(command.equalsIgnoreCase("down")) {
					break;
				}
			} else if(curRoom.getClass() == UVineRoom.class) {
				if(command.equalsIgnoreCase("up")) {
					break;
				}
			} else {
				System.out.println("You must enter a valid command.  Enter help if needed.\n");
			}
		}
		return command;
	}
	
	public void execute() {
		GameCore gameCore = GameCore.getGameCore();
		
		if (command.equalsIgnoreCase("e")) {
			this.curDungeon.setPlayerHorizPos(this.curDungeon.getPlayerPos().getX() + 1, this.curDungeon.getPlayerPos().getY());
		} else if (command.equalsIgnoreCase("n")) {
			this.curDungeon.setPlayerHorizPos(this.curDungeon.getPlayerPos().getX(), this.curDungeon.getPlayerPos().getY() - 1);
		} else if (command.equalsIgnoreCase("s")) {
			this.curDungeon.setPlayerHorizPos(this.curDungeon.getPlayerPos().getX(), this.curDungeon.getPlayerPos().getY() + 1);
		} else if (command.equalsIgnoreCase("w")) {
			this.curDungeon.setPlayerHorizPos(this.curDungeon.getPlayerPos().getX() - 1, this.curDungeon.getPlayerPos().getY());
		} else if (command.equalsIgnoreCase("help")) {
			printHelp();
		} else if (command.equalsIgnoreCase("use")) {
			inventory.getParty().useItem();
		} else if(command.equalsIgnoreCase("exit")) {
			System.exit(0); //TODO close program nicer
		} else if(command.equalsIgnoreCase("open")) {
			openChest();
		} if(command.equalsIgnoreCase("down")) {
			this.curDungeon.setPlayerVertPos(this.curDungeon.getCurPlayerFloor() - 1);
		} if(command.equalsIgnoreCase("up")) {
			this.curDungeon.setPlayerVertPos(this.curDungeon.getCurPlayerFloor() + 1);
		}
	}
	
	private void printHelp() {
		System.out.println("Hey im helpful!");  //TODO print a help menu
	}
	
	private void openChest() {
		if(curRoom instanceof NormalRoom){
			if(((NormalRoom)curRoom).hasChest()){
				TreasureChest chest = new TreasureChest();
				chest.printItem();
				Item item = chest.getItem();
				inventory.addItem(item);
			}
		}
	}
}
