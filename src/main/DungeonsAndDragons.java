/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DungeonsAndDragons {

	public static void main(String[] args) {
		int difficulty = obtainDifficulty();
		//create dungeon based on diff
		//initialize and handoff to game core
	}

	private static int obtainDifficulty() {
		Scanner cin = new Scanner(System.in);
		boolean cInput = false;
		int choice = 0;
		
		while(!cInput) {
			System.out.println("Enter a number associated with a difficulty from the list  below.");
			System.out.println("\n1. Easy\n2. Medium\n3. Normal\n4. Hard\n5. Korean");
			try {
			choice = cin.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("You must enter a number corresponding to a listed difficulty!");
			}
			if(choice > 0 && choice < 6) {
				cInput = true;
			} else {
				System.out.println("You must enter a number corresponding to a listed difficulty!");
			}
		}
		
		
		return choice;
	}

}
