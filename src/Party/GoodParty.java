/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.*;
import character.*;

public class GoodParty extends Party{
	
	//Will implement better inventory system soon
	
	public GoodParty(int [] choices){
		this.members = new ArrayList<character.Character>();
		this.size = 3;
		addMembers(choices);
	}
	
	public void addEXP(int EXP){
		for(character.Character character: this.members){
			character.addEXP(EXP);
		}
	}
	
	private void addMembers(int [] choices){
		Scanner input = new Scanner(System.in);
		String name;
		for(int i = 0; i < choices.length; i++){
			if(choices[i] == 1){
				System.out.print("Name your Warrior: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Warrior(name));
			}
			else if(choices[i] == 2){
				System.out.print("Name your Wizzard: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Wizzard(name));
			}
			else if(choices[i] == 3){
				System.out.print("Name your Thief: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Thief(name));
			}
			else if(choices[i] == 4){
				System.out.print("Name your Shaman: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Shaman(name));
			}
			else{
				System.out.print("Name your Paladin: ");
				name = input.nextLine();
				System.out.println();
				this.members.add(new Paladin(name));
			}
		}
	}
}
