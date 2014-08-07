/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package dungeon;

import dungeon.DungeonBuilderInterface;
import dungeon.EasyDungeonBuilder;
import dungeon.HardDungeonBuilder;
import dungeon.MediumDungeonBuilder;
import dungeon.NormalDungeonBuilder;

public class DunBuilderDirector {
	public Dungeon construct(int difficulty) {
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
