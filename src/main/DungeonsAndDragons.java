/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Party.Party;
import Party.PartyFactory;
import dungeon.Dungeon;
import dungeon.DungeonBuilderInterface;
import dungeon.EasyDungeonBuilder;
import dungeon.HardDungeonBuilder;
import dungeon.MediumDungeonBuilder;
import dungeon.NormalDungeonBuilder;

public class DungeonsAndDragons {

	public static void main(String[] args) {
		int difficulty = obtainDifficulty();
		Dungeon dungeon = createDungeon(difficulty);
		PartyFactory partyFactory = new PartyFactory();
		Party goodGuys = partyFactory.makeGoodParty();
		GameCore curGame = new GameCore(dungeon, goodGuys, partyFactory);
		
		curGame.play();
	}

	private static int obtainDifficulty() {
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		boolean cInput = false;
		int choice = 0;
		
		while(!cInput) {
			System.out.println("Enter a number associated with a difficulty from the list  below.");
			System.out.println("\n1. Easy\n2. Medium\n3. Normal\n4. Hard");
			try {
			choice = cin.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("You must enter a number corresponding to a listed difficulty!");
			}
			if(choice > 0 && choice < 5) {
				cInput = true;
			} else {
				System.out.println("You must enter a number corresponding to a listed difficulty!");
			}
		}
		return choice;
	}
	
	private static Dungeon createDungeon(int difficulty) {
		DungeonBuilderInterface dungeonBuilder = null;
		if(difficulty == 1) {
			dungeonBuilder = new EasyDungeonBuilder();
		} else if(difficulty == 2) {
			dungeonBuilder = new MediumDungeonBuilder();
		} else if(difficulty == 3) {
			dungeonBuilder = new NormalDungeonBuilder();
		} else {
			dungeonBuilder = new HardDungeonBuilder();
		} 
		dungeonBuilder.buildFloors();
		dungeonBuilder.placeEntrance();
		dungeonBuilder.placeLastBossPos();
		dungeonBuilder.verifyDungeon();
		return dungeonBuilder.getDungeon();
	}

}
