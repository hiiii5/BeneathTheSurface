
public abstract class Character
{
	int x, y, width, height;
	int health, defense, attack;
	
	/**
	 * 
	 * @return The current x location of the Character
	 */
	public abstract int getX();
	/**
	 * 
	 * @param x The new x of the Character
	 */
	public abstract void setX(int x);
	/**
	 * 
	 * @return The current y of the Character
	 */
	public abstract int getY();
	/**
	 * @param y The new y of the Character
	 */
	public abstract void setY(int y);
	/**
	 * @return The current width of the Character
	 */
	public abstract int getWidth();
	/**
	 * @param w The new width of the Character
	 */
	public abstract void setWidth(int w);
	/**
	 * @return The current Height of the Character
	 */
	public abstract int getHeight();
	/**
	 * @param h The new height of the Character
	 */
	public abstract void setHeight(int h);
	/**
	 * @return The current health of the Character
	 */
	public abstract int getHealth();
	/**
	 * @param hp The new health of the Character
	 */
	public abstract void setHealth(int hp);
	/**
	 * 
	 * @return The current defense of the Character
	 */
	public abstract int getDefense();
	/**
	 * 
	 * @param d The new defense of the Character
	 */
	public abstract void setDefense(int d);
	/**
	 * 
	 * @return The current attack of the Character
	 */
	public abstract int getAttack();
	/**
	 * 
	 * @param a The new attack of the Character
	 */
	public abstract void setAttack(int a);
}
