/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.*;

import Inventory.Consumables.Consumable;
import Inventory.Equipables.Armors.ArmorPiece;
import character.*;

public class GoodParty extends Party{
	protected ArrayList<Good> members;
	protected ArrayList<Consumable> consumables;
	protected ArrayList<ArmorPiece> equipables;
	
	public GoodParty(int [] choices){
		this.members = new ArrayList<Good>();
		this.consumables = new ArrayList<Consumable>();
		this.equipables = new ArrayList<ArmorPiece>();
		this.size = 3;
		addMembers(choices);
	}
	
	public void addEXP(int EXP){
		for(Good character: this.members){
			character.addEXP(EXP);
		}
	}
	
	private void addMembers(int [] choices){
		
		for(int i = 0; i < choices.length; i++){
			if(choices[i] == 1){
				this.members.add(new Warrior());
			}
			else if(choices[i] == 2){
				this.members.add(new Wizzard());
			}
			else if(choices[i] == 3){
				this.members.add(new Thief());
			}
			else if(choices[i] == 4){
				this.members.add(new Shaman());
			}
			else{
				this.members.add(new Paladin());
			}
		}
	}
}
