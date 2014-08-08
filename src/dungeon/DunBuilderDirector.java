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
		DunBuilderFactory factory = new DunBuilderFactory();
		DungeonBuilderInterface dungeonBuilder = factory.createBuilder(difficulty);
		
		dungeonBuilder.buildFloors();
		dungeonBuilder.placeEntrance();
		dungeonBuilder.placeLastBossPos();
		dungeonBuilder.verifyDungeon();
		return dungeonBuilder.getDungeon();
	}
}
