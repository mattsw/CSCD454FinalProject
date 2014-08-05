/* Team: Larfleeze
 * Members: Nathan Graham, Matt Wilhelm, Brandon Fowler
 * Final project
 */

package character;

import combat.behaviors.*;

public abstract class Character {
	protected String name;
	protected double health;
	protected double curHealth;
	protected double attackPwr;
	protected double speed;
	protected double experianceWorth = 0;
	protected AttackBehavior attack;
	protected DefenseBehavior defend;
	
	public double getHealth() {
		return this.health;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public double getAttackPwr() {
		return this.attackPwr;
	}
	
	public double getCurHealth() {
		return this.curHealth;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getExperianceWorth() {
		return this.experianceWorth;
	}
	
	public void setCurHealth(double health) {
		if(health >= 0) {
			this.curHealth = health;
		} else {
			this.curHealth = 0;
		}
	}
	
	public void setHealth(int health) {
		if(health >= 0) {
			this.health = health;
		} else {
			this.health = 0;
		}
	}
	
	public void setAttackPwr(int attackPwr) {
		if(attackPwr >= 0) {
			this.attackPwr = attackPwr;
		} else {
			this.attackPwr = 0;
		}
	}
	
	public void setSpeed(int speed) {
		if(health >= 0) {
			this.speed = speed;
		} else {
			this.speed = 0;
		}
	}
	
	public boolean isAlive(){
		if(this.curHealth <= 0){
			return false;
		}
		return true;
	}
	
	public void attack(character.Character target){
		setAttackBehavior();
		boolean hasDefended = false;
		double damage = (this.attack.attack(this.attackPwr,this.getName(), target.getName()))- (target.getDefenceRating());
		if(damage > 0){
			hasDefended = target.defend();
		}
		if(!hasDefended && damage > 0){
			target.setCurHealth(target.getCurHealth() - damage);
			System.out.println("The attack is successful, dealing "+String.format( "%.2f", damage)+" damage!");
		}
	}
	public abstract void addEXP(int EXP);
	public abstract boolean defend();
	public abstract void setAttackBehavior();
	public abstract double getDefenceRating();
	public abstract void combatUseItem();
}
