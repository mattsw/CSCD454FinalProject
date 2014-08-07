/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package combat;

import character.Character;

import java.util.ArrayList;

import Party.*;

public class Combat {
	private Party goodGuys;
	private Party badGuys;
	private CombatQueue queue;
	
	public Combat(Party goodGuys, Party badGuys) {
		this.goodGuys = goodGuys;
		this.badGuys = badGuys;
		this.queue = new CombatQueue(this.goodGuys, this.badGuys);
	}
	
	public boolean fight() {
		ArrayList<Character> attackers;
		while(goodGuys.surviving() && badGuys.surviving()) {
			//tick combat queue then offer actions
			attackers = this.queue.tick();
			
			
		}
		
		if(goodGuys.surviving()) {
			return true;
		} else {
			return false;
		}
	}
}
