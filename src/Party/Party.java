/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package Party;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Party implements Iterable<character.Character>{
	protected int size;
	protected ArrayList<character.Character> members;
	protected PartyInventory inventory = PartyInventory.getInventory();
	
	ArrayList<character.Character> getParty(){
		return members;
	}
	
	public Iterator<character.Character> iterator(){
		return new PartyIterator(this.members, this.size);
	}
	
	public class PartyIterator implements Iterator<character.Character>{
		protected ArrayList<character.Character> pMembers;
		protected int cur;
		protected int size;
		
		public PartyIterator(ArrayList<character.Character> pMembers, int size){
			this.pMembers = pMembers;
			this.cur = 0;
			this.size = size;
		}
		
		public boolean hasNext(){
			return cur < this.size;
		}
		
		public character.Character next(){
			if(hasNext()){
				return pMembers.get(cur++);
			}
			else{
				return null;
			}
		}
		
		public void remove(){
			//Not supported
		}
	}
	
	public abstract void useItem();
	public abstract void addEXP(int EXP);
	public abstract double getEXP();
}
