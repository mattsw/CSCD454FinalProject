/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

public class Dungeon {
	Room map[][][];
	
	public Dungeon(int x, int y, int z) {
		this.map = new Room[x][y][z];
	}
}
