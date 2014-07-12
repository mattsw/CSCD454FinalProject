/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

public abstract class Good extends Character {
	protected int mana;
	
	public int getMana() {
		return this.mana;
	}
	public void setMana(int mana) {
		if(mana >= 0) {
			this.mana = mana;
		} else {
			this.mana = 0;
		}
	}
}
