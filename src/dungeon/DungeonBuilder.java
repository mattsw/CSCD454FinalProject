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
			temp = new Floor(floorSize, chestMod);
			placeVines(temp, i);
			
			map[i] = temp;
		}
		this.dungeon.setMap(map);
		closeOutterDoors();
	}
	//helper for buildFloors
	private void placeVines(Floor temp, int floorNum) {
		Random rand = new Random();
		
		if(floorNum != 0 && floorNum != this.numFloors - 1) {
			temp.setDVine(new Point(rand.nextInt(this.floorSize), rand.nextInt(this.floorSize)));
			temp.setUVine(new Point(rand.nextInt(this.floorSize), rand.nextInt(this.floorSize)));
		} else if(floorNum == 0) {
			temp.setUVine(new Point(rand.nextInt(this.floorSize), rand.nextInt(this.floorSize)));
		} else { //top floor
			temp.setDVine(new Point(rand.nextInt(this.floorSize), rand.nextInt(this.floorSize)));
		}
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
		
		int x = rand.nextInt(this.floorSize);
		int y = rand.nextInt(this.floorSize);
		
		this.dungeon.setEntrance(new Point(x,y));
	}

	public void placeLastBossPos() {
		Random rand = new Random();
		
		int x = rand.nextInt(this.floorSize);
		int y = rand.nextInt(this.floorSize);
		
		this.dungeon.setLastBossPos(new Point(x,y));
	}
	
	public void verifyDungeon() {
		Point start, end;
		start = end = null;
		
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
