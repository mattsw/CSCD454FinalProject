/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

import java.util.Random;

public abstract class DungeonBuilder implements DungeonBuilderInterface {
	protected Dungeon dungeon;
	protected int numFloors;
	protected int floorSize;
	protected double chestMod;

	public DungeonBuilder() {
		this.dungeon = new Dungeon();
	}
	
	public void buildFloors() {
		Floor[] map = new Floor[numFloors];
		Floor temp;
		for(int i = 0; i < this.numFloors; i++) {
			temp = new Floor(floorSize, chestMod, dungeon);
			placeVines(temp, i);
			
			map[i] = temp;
		}
		this.dungeon.setMap(map);
	}
	//helper for buildFloors.  places DVine rooms on even coordinates
	//and UVine rooms on odd coordinates.
	private void placeVines(Floor temp, int floorNum) {
		Room[][] tempRooms = temp.getFloor();
		
		if(floorNum != 0 && floorNum != this.numFloors - 1) {
			int dVineX = makeDVineX();
			int dVineY = makeDVineY();
			int uVineX = makeUVineX();
			int uVineY = makeUVineY();
			
			tempRooms[dVineX][dVineY] = new DVineRoom(this.chestMod, dungeon);
			tempRooms[uVineX][uVineY] = new UVineRoom(this.chestMod, dungeon);
			temp.setDVine(new Point(dVineX, dVineY));
			temp.setUVine(new Point(uVineX, uVineY));
		} else if(floorNum == 0) {
			int uVineX = makeUVineX();
			int uVineY = makeUVineY();
			
			tempRooms[makeUVineX()][makeUVineY()] = new UVineRoom(this.chestMod, dungeon);
			temp.setUVine(new Point(uVineX, uVineY));
		} else { //top floor
			int dVineX = makeDVineX();
			int dVineY = makeDVineY();
			
			tempRooms[makeDVineX()][makeDVineY()] = new DVineRoom(this.chestMod, dungeon);
			temp.setDVine(new Point(dVineX, dVineY));
		}
	}
	//will ensure x is an even number
	private int makeDVineX() {
		Random rand = new Random();
		int dVineX = rand.nextInt(this.floorSize);
		
		if(dVineX % 2 == 1) {
			dVineX--;
		}
		
		return dVineX;
	}
	//will ensure x is an odd number
	private int makeUVineX() {
		Random rand = new Random();
		int UVineX = rand.nextInt(this.floorSize);
		
		if(UVineX % 2 == 0) {
			if(UVineX > 0) {
				UVineX--;
			} else {
				UVineX++;
			}
		}
		
		return UVineX;
	}
	//will ensure y is an even number
	private int makeDVineY() {
		Random rand = new Random();
		int dVineY = rand.nextInt(this.floorSize);
		
		if(dVineY % 2 == 1) {
			dVineY--;
		}
		
		return dVineY;
	}
	//will ensure y is an odd number
	private int makeUVineY() {
		Random rand = new Random();
		int UVineY = rand.nextInt(this.floorSize);
		
		if(UVineY % 2 == 0) {
			if(UVineY > 0) {
				UVineY--;
			} else {
				UVineY++;
			}
		}
		
		return UVineY;
	}
	
	private void closeOutterDoors() {
		for(int i = 0; i < this.numFloors; i++) {
			Room[][] curFloor = this.dungeon.getFloorArray(i);
			for(int j = 0; j < this.floorSize; j++) {
				for(int k = 0; k < this.floorSize; k++) {
					if(j == 0) {
						curFloor[j][k].setWDoor(false);
					}
					if(k == 0) {
						curFloor[j][k].setNDoor(false);
					}
					if(j == this.floorSize - 1) {
						curFloor[j][k].setEDoor(false);
					}
					if(k == this.floorSize - 1) {
						curFloor[j][k].setSDoor(false);
					}
				}
			}
		}
	}
	
	public void placeEntrance() {
		Random rand = new Random();
		Room[][] temp = this.dungeon.getFloorArray(0);
		
		int x = rand.nextInt(this.floorSize);
		int y = rand.nextInt(this.floorSize);
		
		while(temp[x][y] instanceof UVineRoom) {
			x = rand.nextInt(this.floorSize);
			y = rand.nextInt(this.floorSize);
		}
		
		temp[x][y] = new StartRoom(this.chestMod, dungeon);
		this.dungeon.setEntrance(new Point(x,y));
		this.dungeon.setPlayerPos(new Point(x,y));
		this.dungeon.setPlayerFloor(0);
	}

	public void placeLastBossPos() {
		Random rand = new Random();
		Room[][] temp = this.dungeon.getFloorArray(0);
		
		int x = rand.nextInt(this.floorSize);
		int y = rand.nextInt(this.floorSize);
		
		while(temp[x][y] instanceof DVineRoom) {
			x = rand.nextInt(this.floorSize);
			y = rand.nextInt(this.floorSize);
		}
		
		temp[x][y] = new FinalBossRoom(this.chestMod, dungeon);
		this.dungeon.setLastBossPos(new Point(x,y));
	}
	
	public void verifyDungeon() {
		Point start, end;
		start = end = null;
		
		closeOutterDoors();
		
		for(int i = 0; i < this.numFloors; i++) {
			if(i != 0 && i != this.numFloors - 1) {
				start = this.dungeon.getFloor(i).getDVine();
				end = this.dungeon.getFloor(i).getUVine();
			} else if(i == 0) {
				start = this.dungeon.getEntrance();
				end = this.dungeon.getFloor(i).getUVine();
			} else {
				start = this.dungeon.getFloor(i).getDVine();
				end = this.dungeon.getLastBossPos();
			}
			if(!floorIsValid(this.dungeon.getFloorArray(i), start, end)) {
				this.dungeon.replaceFloor(this.floorSize, this.chestMod, i);
			}
		}
	}
	
	private boolean floorIsValid(Room[][] curFloor, Point start, Point end) {
		boolean visited[][] = new boolean[curFloor.length][curFloor.length];
		int curX = start.getX();
		int curY = start.getY();
		int endX = end.getX();
		int endY = end.getY();
		
		return recursiveSearch(curFloor, visited, curX, curY, endX, endY);
	}
	
	private boolean recursiveSearch(Room[][] curFloor, boolean[][] visited, int curX, int curY, int endX, int endY) {
		visited[curX][curY] = true;
		
		if(curX == endX && curY == endY) {
			return true;
		}
		if (curFloor[curX][curY].hasNDoor() && !visited[curX][curY-1]) { //try north
            if(recursiveSearch(curFloor, visited, curX, curY-1, endX, endY)) {
                return true;
            }
        }
        if (curFloor[curX][curY].hasEDoor() && !visited[curX+1][curY]) { //try east
            if (recursiveSearch(curFloor, visited, curX+1, curY, endX, endY)) {
                return true;
            }
        }
        if (curFloor[curX][curY].hasSDoor() && !visited[curX][curY+1]) { //try south
            if (recursiveSearch(curFloor, visited, curX, curY+1, endX, endY)) {
                return true;
            }
        }
        if (curFloor[curX][curY].hasWDoor() && !visited[curX-1][curY]) { //try west
            if (recursiveSearch(curFloor, visited, curX-1, curY, endX, endY)) {
                return true;
            }
        }
        visited[curX][curY] = false; //update visited
        return false;
	}

	public Dungeon getDungeon() {
		return this.dungeon;
	}
}
