/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.ArrayList;
import character.*;

public class BossParty extends Party{

	protected ArrayList<Bad> members;
	
	public BossParty(int floorMod, String type){
		this.size = 1;
		type = type.toLowerCase();
		if(type.compareTo("giant") == 0){
			members.add(new Giant(floorMod));
		}
		else{
			members.add(new Dragon(floorMod));
		}
	}
	
	public void useItem(){
		//Not currently Implemented
	}
	
	public void addEXP(int EXP){
		//Not currently Implemented
	}
	
	public double getEXP(){
		double exp = 0;
		for(character.Character creature:this.members){
			exp = exp + creature.getExperienceWorth();
		}
		return exp;
	}
}
