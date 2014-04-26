import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
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
		
		setImage(0);
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
		
		setImage(0);
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
	
	private void setImage(int frame)
	{
		if(frame == 0)
		{
			try { this.image = ImageIO.read(new File("Img/Player.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
		if(frame == -1)
		{
			try { this.image = ImageIO.read(new File("Img/Player_backward.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
		if(frame == 1)
		{
			try { this.image = ImageIO.read(new File("Img/Player_forward.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public void update()
	{
		boolean canMove = true;
		
		if(this.dx == 0)
			setImage(0);
		if(this.dx == 1)
		{
			canMove = (Logic.checkCollision(new Point(this.x+(this.width+1), this.y), new Point(this.x+(this.width+1), this.y+this.height)) > -1) ? true : false;
			setImage(1);
		}
		if(this.dx == -1)
		{
			canMove = (Logic.checkCollision(new Point(this.x-1, this.y), new Point(this.x, this.y+this.height)) > -1) ? true : false;
			setImage(-1);
		}

		if(!canMove)
			this.x += this.dx;
	}
	
	public void render(Graphics2D g2)
	{
		g2.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
}
