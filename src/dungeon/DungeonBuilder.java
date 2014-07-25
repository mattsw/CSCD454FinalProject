/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

public interface DungeonBuilder {
	public void buildFloors();
	public void buildRooms();
	public void buildHalls();
	public void placeEntrance();
	public void placeExit();
	public void placeVines(); //aka ladders
	public void placeChests();
}
