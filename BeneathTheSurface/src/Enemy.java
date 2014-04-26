
public class Enemy extends Character
{
	//Over-loader for bad creation
		/**
		 * The over loader for the Enemy class
		 */
		public Enemy()
		{
			this.width = 0;
			this.height = 0;
			this.health = 0;
		}
		
		//Primary Creation
		/**
		 * 
		 * @param x The x location of the Enemy
		 * @param y The y location of the Enemy
		 * @param w The width of the Enemy
		 * @param h The height of the Enemy
		 * @param hp The health of the Enemy
		 */
		public Enemy(int x, int y, int w, int h, int hp)
		{
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
			this.health = hp;
			this.defense = (int)(hp/2);
			this.attack = (int)Math.sqrt(defense*3);
		}
		
		/**
		 * @return The current x location of the Enemy
		 */
		public int getX() { return this.x; }
		/**
		 * @param x The new x location of the Enemy
		 */
		public void setX(int x) { this.x = x; }
		/**
		 * @return The current y location of the Enemy
		 */

		public int getY() { return this.y; }
		/**
		 * @param The new y location of the Enemy
		 */
		public void setY(int y) { this.y = y; }
		/**
		 * @return The current width of the Enemy
		 */

		public int getWidth() { return this.width; }
		/**
		 * @param w The new width of the Enemy
		 */
		public void setWidth(int w) { this.width = w; }
		
		/**
		 * @return The current Height of the Enemy
		 */
		public int getHeight() { return this.height; }
		/**
		 * @param h The new height of the Enemy
		 */
		public void setHeight(int h) { this.height = h; }
		
		/**
		 * @return The current health of the Enemy
		 */
		public int getHealth() { return this.health; }
		/**
		 * @param hp The new health of the Enemy
		 */
		public void setHealth(int hp) { this.health = hp; }
		
		/**
		 * @return The current defense of the Enemy
		 */
		public int getDefense() { return this.defense; }
		/**
		 * @param d The new defense of the Enemy
		 */
		public void setDefense(int d) { this.defense = d; }
		
		/**
		 * @return The current attack of the Enemy
		 */
		public int getAttack() { return this.attack; }
		/**
		 * @param a The new attack of the Enemy
		 */
		public void setAttack(int a) { this.attack = a; }
}
