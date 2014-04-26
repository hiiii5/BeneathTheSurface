
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
	public static int checkCollision(int x, int y, int width, int height, Object[] objs)
	{
		for( int i=0; i<objs.length; i++ )
			if( objs[i].getCollide() == true )
				if( x < objs[i].getX() + objs[i].getWidth() && y < objs[i].getY() + objs[i].getHeight() && x + width > objs[i].getX() && y + height> objs[i].getY() )
					return i;

		return -1;
	}
	
	/**
	 * 
	 * @param objectsInWorld All the objects in the screen
	 */
	public void applyGravity(Object[] objectsInWorld)
	{
		for( Object obj : objectsInWorld )
			if( obj.getGravity() )
				if( checkCollision(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), objectsInWorld) == -1)
					obj.setY(obj.getY()+gravity);
	}
	
	/**
	 * 
	 * @return The current gravity for the world
	 */
	public static int getGravity() { return gravity; }
}
