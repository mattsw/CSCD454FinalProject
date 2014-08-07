package combat;

import java.util.ArrayList;
import java.util.Iterator;

import Party.Party;
import character.Character;

public class CombatQueue {
	private ArrayList<SpeedCountWrapper> combatCharacters;
	private ArrayList<Character> attackingChars;
	
	public CombatQueue(Party goodParty, Party badParty) {
		fillChars(goodParty, badParty);
	}
	//helper for constructor
	private void fillChars(Party goodParty, Party badParty) {
		Iterator<Character> goodIterator = goodParty.iterator();
		Iterator<Character> badIterator = badParty.iterator();
		
		while(goodIterator.hasNext()) {
			this.combatCharacters.add(new SpeedCountWrapper(goodIterator.next()));
		}
		while(badIterator.hasNext()) {
			combatCharacters.add(new SpeedCountWrapper(badIterator.next()));
		}
	}
	
	private void addAttackingChar(Character character) {
		this.attackingChars.add(character);
	}
	
	public ArrayList<Character> tick() {
		this.attackingChars.clear();
		for(int i = 0; i < this.attackingChars.size(); i++) {
			this.combatCharacters.get(i).incrementSpeedCount();
		}
		return this.attackingChars;
	}
	
	private class SpeedCountWrapper {
		private Character character;
		private int speedCount;
		private SpeedCountWrapper(Character character) {
			this.character = character;
			this.speedCount = 0;
		}
		
		private void incrementSpeedCount() {
			this.speedCount += this.character.getSpeed();
			if(this.speedCount > 100) {
				this.speedCount = speedCount % 100;
				CombatQueue.this.addAttackingChar(this.character);
			}
		}
	}
}
