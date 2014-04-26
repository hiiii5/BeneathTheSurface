import java.awt.Point;


public class Logic
{
	private final static int gravity = 1;
	
	public int getDamage(Character c1, Character c2)
	{
		return (int)(c1.getAttack()/c2.getDefense());
	}
	
	/**
	 * 
	 * @param object Object to check
	 * @param objectsInWorld Array of objects in view
	 * @return Whether or not the object is colliding
	 */
	public static boolean checkCollision(Object object, Object[] objectsInWorld)
	{
		for( Object obj : objectsInWorld )
			if( obj.getCollide() )
				if( obj.getX() + obj.getWidth() < object.getX() && obj.getY() + obj.getHeight() < object.getY() && obj.getX() > object.getX() + object.getWidth() && obj.getY() > object.getY() + object.getHeight() )
					return true;

		return false;
	}
	
	/**
	 * 
	 * @param x Location to start from in x
	 * @param y Location  to start from in y
	 * @param width Width of the object
	 * @param height Height of the object
	 * @param objectsInWorld Array of objects in view
	 * @return Whether or not the object is colliding
	 */
	public static int checkCollision(Point pt1, Point pt2)
	{
		for(int i=0; i<Level.objectsInWorld.length; i++)
			if(Level.objectsInWorld[i].getCollide())
				if(Level.objectsInWorld[i].contains(pt1) || Level.objectsInWorld[i].contains(pt2))
					return i;

		return -1;
	}
	
	/**
	 * 
	 * @param x Location to start from in x
	 * @param y Location  to start from in y
	 * @param width Width of the object
	 * @param height Height of the object
	 * @param objectsInWorld Array of objects in view
	 * @return Whether or not the object is colliding
	 */
	public static int checkCollision(int x, int y, int width, int height, Object[] objs)
	{
		for( int i=0; i<objs.length; i++ )
			if( objs[i].getCollide() == true )
				if(objs[i].contains(new Point(x, y)) || objs[i].contains(new Point(x+width, y)))
					return i;

		return -1;
	}
	
	/**
	 * 
	 * @param objectsInWorld All the objects in the screen
	 */
	public void applyGravity(Object[] objs)
	{
		for( int i=0; i<objs.length; i++ )
			if( objs[i].getGravity() )
				if( checkCollision((int)objs[i].getX(), (int)objs[i].getY(), (int)objs[i].getWidth(), (int)objs[i].getHeight(), objs) == -1)
					objs[i].setY((int)objs[i].getY()+gravity);
	}
	
	/**
	 * 
	 * @return The current gravity for the world
	 */
	public static int getGravity() { return gravity; }
}
