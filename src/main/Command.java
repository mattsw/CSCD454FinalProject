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
	private Room curRoom;
	
	public Command(Room curRoom) {
		this.curRoom = curRoom;
		this.command = getCommand();
		this.curDungeon = curRoom.getDungeon();
		this.inventory = PartyInventory.getInventory();
	}
	
	private String getCommand() {
		String commandTest = "";
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		
		while(true) {
			commandTest = cin.nextLine();
			
			if(curRoom.hasEDoor()) {
				if (commandTest.equalsIgnoreCase("e")) {
					break;
				}
			} 
			if(curRoom.hasNDoor()) {
				if (commandTest.equalsIgnoreCase("n")) {
					break;
				}
			} 
			if(curRoom.hasSDoor()) {
				if (commandTest.equalsIgnoreCase("s")) {
					break;
				}
			} 
			if(curRoom.hasWDoor()) {
				if (commandTest.equalsIgnoreCase("w")) {
					break;
				}
			} 
			if (commandTest.equalsIgnoreCase("help")) {
				break;
			} 
			if (commandTest.equalsIgnoreCase("use")) {
				break;
			}
			if(commandTest.equalsIgnoreCase("exit")) {
				break;
			}
			if(curRoom.getClass() == NormalRoom.class) {  //found at http://stackoverflow.com/questions/4294844/check-if-an-object-belongs-to-a-class-in-java
				NormalRoom temp = (NormalRoom) curRoom;
				if(temp.hasChest()) {
					if(commandTest.equalsIgnoreCase("open")) {
						break;
					}
				}
			}
			if(curRoom.getClass() == DVineRoom.class) {
				if(commandTest.equalsIgnoreCase("down")) {
					break;
				}
			}
			if(curRoom.getClass() == UVineRoom.class) {
				if(commandTest.equalsIgnoreCase("up")) {
					break;
				}
			}
			System.out.println("You must enter a valid command.  Enter help if needed.\n");
		}
		return commandTest;
	}
	
	public void execute() {
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
			this.inventory.getParty().useItem();
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
		getCommand();
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
