/**
 * @author Dr.Wayne
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Runner extends JPanel implements KeyListener
{
	private Image vMem;
	private Image background;
	private Graphics2D gBuf;
	private boolean isRunning = false;
	
	public static final int sWidth = 900, sHeight = 600;
	
	public static final int FPS = 60/1000;
	
	public Level level = new Level();
	public Player player = new Player(40, 100, 20, 60, 100);
	
	public Runner()
	{
		addKeyListener(this);
		new java.util.Timer().schedule(new java.util.TimerTask()
		{
			public void run()
			{
				update();
			}
		}, FPS, 10);
		
		requestFocus();
	}
	
	public void init()
	{
		vMem = createImage(sWidth, sHeight);
		gBuf = (Graphics2D)vMem.getGraphics();
		
		try { background = ImageIO.read(new File("Img/Background.jpg")); }
		catch(Exception e) { e.printStackTrace(); }

		isRunning = true;
	}
	
	public void update()
	{
		player.update();
		repaint();
	}
	
	public static void main(String[] args)
	{
		Runner canvas = new Runner();
		
		JFrame frame = new JFrame("Beneath the surface!");
		frame.setSize(sWidth, sHeight);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas.init();
	}
	
	public void paint(Graphics g)
	{
		if(isRunning)
		{
			gBuf.clearRect(0, 0, sWidth, sHeight);
			
			gBuf.drawImage(background, 0, 0, null);
			
			for(Object obj : Level.objectsInWorld)
				obj.render(gBuf);
			
			player.render(gBuf);
			
			g.drawImage(vMem, 0, 0, null);
		}
	}

	public void keyPressed(KeyEvent evt)
	{
		int key = evt.getKeyCode();
		
		switch(key)
		{
			case KeyEvent.VK_D: player.dx = 1;
			break;
			case KeyEvent.VK_A: player.dx = -1;
			break;
			case KeyEvent.VK_SPACE: player.jump();
			break;
			default: System.out.println("Error, no key");
		}
	}

	public void keyReleased(KeyEvent evt)
	{
		int key = evt.getKeyCode();
		
		switch(key)
		{
			case KeyEvent.VK_D: player.dx = 0;
			break;
			case KeyEvent.VK_A: player.dx = 0;
			break;
			case KeyEvent.VK_SPACE: /*do nothing*/;
			break;
			default: System.out.println("Error, no key");
		}
	}

	public void keyTyped(KeyEvent evt) {}
	
	public boolean isFocusable() { return true;	}
}
