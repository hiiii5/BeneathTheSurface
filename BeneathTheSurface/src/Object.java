import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Object
{
	private int x, y, width, height;
	private boolean canCollide, isAffectedByGravity;
	private String imageName;
	private Image image;
	
	public Object(int x, int y, int width, int height, boolean canCollide, boolean isAffectedByGravity, String imageName)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.canCollide = canCollide;
		this.isAffectedByGravity = isAffectedByGravity;
		this.imageName = imageName.toLowerCase();
		
		setImage();
	}
	
	public int getX() { return this.x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return this.y; }
	public void setY(int y) { this.y = y; }
	public int getWidth() { return this.width; }
	public void setWidth(int width) { this.width = width; }
	public int getHeight() { return this.height; }
	public void setHeight(int height) { this.height = height; }
	public boolean getCollide() { return this.canCollide; }
	public void setCollide(boolean canCollide) { this.canCollide = canCollide; }
	public boolean getGravity() { return this.isAffectedByGravity; }
	public void setGravity(boolean isAffectedByGravity) { this.isAffectedByGravity = isAffectedByGravity; }
	public String getImageName() { return this.imageName; }
	public void setImageName(String imageName) { this.imageName = imageName.toLowerCase(); setImage(); }
	
	private void setImage()
	{
		if(imageName.equals("pillar"))
		{
			try { this.image = ImageIO.read(new File("Img/Pillar.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
		else if(imageName.equals("ground"))
		{
			try { this.image = ImageIO.read(new File("Img/Ground.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
		else if(imageName.equals("seaweed"))
		{
			try { this.image = ImageIO.read(new File("Img/SeaWeed.png")); }
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public void render(Graphics2D g2)
	{
		g2.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
	
	public String toString()
	{
		return "(x: "+this.x+", y: "+this.y+", w: "+this.width+", h: "+this.height+")";
	}
}
