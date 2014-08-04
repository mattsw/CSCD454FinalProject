/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

public class Dungeon {
	Floor map[];
	Point entrance, lastBossPos;

	public Dungeon() {
	}

	public Floor[] getMap() {
		return this.map;
	}
	public void setMap(Floor[] map) {
		this.map = map;
	}
	public Point getEntrance() {
		return this.entrance;
	}
	public void setEntrance(Point entrance) {
		this.entrance = entrance;
	}
	public Point getLastBossPos() {
		return this.lastBossPos;
	}
	public void setLastBossPos(Point bossPos) {
		this.lastBossPos = bossPos;
	}
	public Room[][] getFloorArray(int floorNum) {
		return this.map[floorNum].getFloor();
	}
	public void replaceFloor(int floorSize, double chestMod, int floorNum) {
		this.map[floorNum] = new Floor(floorSize, chestMod);
	}
	public Floor getFloor(int floorNum) {
		return this.map[floorNum];
	}
}
