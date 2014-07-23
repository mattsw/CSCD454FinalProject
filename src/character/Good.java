/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import Inventory.Equipables.Armors.*;

public abstract class Good extends Character {
	protected int level;
	protected double curHealth;
	protected double armorMultiplier;
	protected Helmet helmet = null;//Will set to most basic armor type when functionality is available
	protected ChestPiece chestPiece = null;//Will set to most basic armor type when functionality is available
	protected Gloves gloves = null;//Will set to most basic armor type when functionality is available
	protected Legs legs = null;//Will set to most basic armor type when functionality is available
	protected Boots boots = null;//Will set to most basic armor type when functionality is available
	
	public void setHelmet(Helmet helmet){
		this.helmet = helmet;
		updateArmorVal();
	}
	
	public void setChestPiece(ChestPiece chestPiece){
		this.chestPiece = chestPiece;
		updateArmorVal();
	}
	
	public void setGloves(Gloves gloves){
		this.gloves = gloves;
		updateArmorVal();
	}
	
	public void setLegs(Legs legs){
		this.legs = legs;
		updateArmorVal();
	}
	
	public void setBoots(Boots boots){
		this.boots = boots;
		updateArmorVal();
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void updateArmorVal(){
		armorVal = (this.helmet.getArmorValue()+this.chestPiece.getArmorValue()+this.gloves.getArmorValue()
				   +this.legs.getArmorValue()+this.boots.getArmorValue())*(this.armorMultiplier);
	}
	
	public abstract void levelUp();
}
