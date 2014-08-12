/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

import dungeon.DungeonBuilderInterface;

public class DunBuilderDirector {
	public Dungeon construct(int difficulty) {
		DunBuilderFactory factory = new DunBuilderFactory();
		DungeonBuilderInterface dungeonBuilder = factory.createBuilder(difficulty);
		
		dungeonBuilder.buildFloors();
		dungeonBuilder.placeEntrance();
		dungeonBuilder.placeLastBossPos();
		dungeonBuilder.closeDoors();
		dungeonBuilder.verifyDungeon();
		Dungeon dungeon = dungeonBuilder.getDungeon();
		dungeon.setPlayerVertPos(0); //do this to update gameCore
		
		//printDungeon(dungeon); //test code
		
		return dungeon;
	}
	
	private void printDungeon(Dungeon dungeon) {
		for(int i = 0; i < dungeon.getMap().length; i++) {
			Room[][] temp = dungeon.getFloorArray(i);
			for(int x = 0; x < temp.length; x++) {
				for(int y = 0; y < temp.length; y++) {
					if(temp[x][y].eDoor) {
						System.out.println("east door");
					}
					if(temp[x][y].nDoor) {
						System.out.println("north door");
					}
					if(temp[x][y].wDoor) {
						System.out.println("west door");
					}
					if(temp[x][y].sDoor) {
						System.out.println("south door");
					}
					System.out.println();
				}
				System.out.println("new row");
			}
			System.out.println("new floor");
		}
	}
}
