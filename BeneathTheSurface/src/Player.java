import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public class Player extends Character
{
	private int x, y;
	public int dx = 0, dy = Logic.getGravity();
	private int jumpSpeed = 0;
	private boolean isJumping = false, isFalling = false, isStanding = false;
	private Image image;
	
	//Over-loader for bad creation
	/**
	 * The over loader for the Player class
	 */
	public Player()
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.health = 0;
		this.defense = 0;
		this.attack = 0;
		
		setImage();
	}
	
	//Primary Creation
	/**
	 * @param x The current x location of the Player
	 * @param y The current y location of the Player
	 * @param w The width of the Player
	 * @param h The height of the Player
	 * @param hp The health of the Player
	 */
	public Player(int x, int y, int w, int h, int hp)
	{
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.health = hp;
		this.defense = (int)(hp/2);
		this.attack = (int)Math.sqrt(defense*3);
		
		setImage();
	}
	
	/**
	 * @return The current x location of the Player
	 */
	public int getX() { return this.x; }
	/**
	 * @param x The new x location of the Player
	 */
	public void setX(int x) { this.x = x; }
	/**
	 * @return The current y location of the Player
	 */

	public int getY() { return this.y; }
	/**
	 * @param The new y location of the Player
	 */
	public void setY(int y) { this.y = y; }
	
	/**
	 * @return The current width of the Player
	 */
	public int getWidth() { return this.width; }
	/**
	 * @param w The new width of the Player
	 */
	public void setWidth(int w) { this.width = w; }
	
	/**
	 * @return The current Height of the Player
	 */
	public int getHeight() { return this.height; }
	/**
	 * @param h The new height of the Player
	 */
	public void setHeight(int h) { this.height = h; }
	
	/**
	 * @return The current health of the Player
	 */
	public int getHealth() { return this.health; }
	/**
	 * @param hp The new health of the Player
	 */
	public void setHealth(int hp) { this.health = hp; }
	
	/**
	 * @return The current defense of the Player
	 */
	public int getDefense() { return this.defense; }
	/**
	 * @param d The new defense of the Player
	 */
	public void setDefense(int d) { this.defense = d; }
	
	/**
	 * @return The current attack of the Player
	 */
	public int getAttack() { return this.attack; }
	/**
	 * @param a The new attack of the Player
	 */
	public void setAttack(int a) { this.attack = a; }
	
	private void setImage()
	{
		try { this.image = ImageIO.read(new File("Img/Player.png")); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	public void jump()
	{
		if(this.isJumping == false)
		{
			this.dy = -10;
			this.isJumping = true;
		}
	}
	
	public void update()
	{
		int collision = Logic.checkCollision(this.x, this.y, this.width, this.height, Level.objectsInWorld);
		if(isJumping == true)
		{
			this.dy += Logic.getGravity();
			this.y += dy;
			
			if(collision > -1)
			{
				this.dy = 0;
				this.isJumping = false;
				this.y = Level.objectsInWorld[collision].getY() - this.height;
			}
		}

		this.x += this.dx;
		if(collision == -1)
		{
			this.y += dy;
		}
	}
	
	public void render(Graphics2D g2)
	{
		g2.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
}
