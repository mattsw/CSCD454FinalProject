/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.ArrayList;

public abstract class Party {
	protected int size;
	protected ArrayList<character.Character> members;
	protected PartyInventory inventory = PartyInventory.getInventory();
	
	ArrayList<character.Character> getParty(){
		return members;
	}
	
	public abstract void useItem();
}
