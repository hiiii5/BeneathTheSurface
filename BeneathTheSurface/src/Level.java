
public class Level
{
	public static Object[] objectsInWorld;
	
	public Level()
	{
		populate();
	}
	
	private void populate()
	{
		objectsInWorld = new Object[5];
		objectsInWorld[0] = new Object(0, 0, 20, Runner.sHeight, true, false, "ground");
		objectsInWorld[1] = new Object(20, Runner.sHeight - 55, Runner.sWidth, 20, true, false, "ground");
		objectsInWorld[2] = new Object(100, 50, 100, 55, true, false, "ground");
		objectsInWorld[3] = new Object(100, 105, 20, 100, true, false, "pillar");
		objectsInWorld[4] = new Object(200, objectsInWorld[1].getY()-100, 100, 100, false, false, "seaweed");
	}
}
