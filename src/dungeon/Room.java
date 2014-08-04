/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

import java.util.Random;

public class Room {
	TreasureChest chest;
	boolean nDoor;
	boolean eDoor;
	boolean sDoor;
	boolean wDoor;
	
	public Room(double chestMod) {
		generateDoors();
		generateChest(chestMod);
	}

	private void generateChest(double chestMod) {
		Random rand = new Random();
		
		if(rand.nextDouble() <= chestMod) {
			this.chest = new TreasureChest();
		} else {
			this.chest = null;
		}
	}

	private void generateDoors() {
		Random rand = new Random();	
		
		if(rand.nextInt(100) < 95) 
			this.nDoor = true;
		if(rand.nextInt(100) < 95) 
			this.eDoor = true;
		if(rand.nextInt(100) < 95) 
			this.sDoor = true;
		if(rand.nextInt(100) < 95) 
			this.wDoor = true;
	}

	public boolean hasNDoor() {
		return nDoor;
	}

	public void setNDoor(boolean nDoor) {
		this.nDoor = nDoor;
	}

	public boolean hasEDoor() {
		return eDoor;
	}

	public void setEDoor(boolean eDoor) {
		this.eDoor = eDoor;
	}

	public boolean hasSDoor() {
		return sDoor;
	}

	public void setSDoor(boolean sDoor) {
		this.sDoor = sDoor;
	}

	public boolean hasWDoor() {
		return wDoor;
	}

	public void setWDoor(boolean wDoor) {
		this.wDoor = wDoor;
	}
	
}
