package hack.psu.engine;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameEngine {
	
	int pbt;
	public ArrayList<Entity> ents;
	public LightsBuffer lb;
	
	public GameEngine(int periodbetweenticks, ArrayList<Entity> e, LightsBuffer lbuf)
	{
		pbt = periodbetweenticks;
		ents = e;
		lb=lbuf;
		
		giveYourselfToYourEntities();
		
		//startTicker();
	}
	
	public void init()
	{
		startTicker();
	}
	
	public void giveYourselfToYourEntities()
	{
		for(Entity e:ents)
			e.setGameEngine(this);
	}
	
	public void startTicker()
	{
		Timer t = new Timer();
		TimerTask ttask = new TimerTask()
		{

		@Override
		public void run() {
				// TODO Auto-generated method stub
				tick();
		}
			
		};
	t.scheduleAtFixedRate(ttask, 0, 1000/pbt);
	}
	
	public void tick()
	{

		lb.clear();
		for(Entity e: ents)
			e.tick();
		updateBuffer();
		
		
		/*for(int i = 0; i < 7; i++)
			System.out.println();
		for(int i = 0; i <lb.getSize();i++)
		{
			if(i%(lb.getWidth())==0)
				System.out.println();
			if(lb.getColorIndex(i)==lb.COLOR_BALL)
				System.out.print("b");
			else if(lb.getColorIndex(i) == lb.COLOR_PADDLE)
				System.out.print("p");
			else if(lb.getColorIndex(i) == lb.COLOR_WALL)
				System.out.print("w");
			else if(lb.getColorIndex(i) == Color.WHITE)
				System.out.print("x");
			else
				System.out.print("y");
			//System.out.print(lb.getIntIndex(i));
		
		}*/
		
	}
	
	
	public void updateBuffer()
	{
		for(Entity ent:ents)
		{
			setIndex(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight(), ent.getColor());
			
			/*if(ent.getType()=="Wall")
			{
				setIndex(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight(), lb.COLOR_WALL);
			}
			else if(ent.getType()=="Paddle")
			{
				setIndex(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight(), lb.COLOR_PADDLE);
			}
			else if(ent.getType()=="Ball")
				setIndex(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight(), lb.COLOR_BALL);
			else
				System.out.println("woops");*/
			 
		}
	}
	
	public void setIndex(int x,int y,int w,int h, Color color)
	{
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{	
				lb.setIndex((x%lb.getWidth()) + (y*lb.getWidth()) + j + (i*lb.getWidth()), color);
			}
		}
	}
	
	public ArrayList<Entity> checkForCollisions(Entity e)
	{		
		ArrayList<Entity> collisionList = new ArrayList<Entity>();
		
		Rectangle myBox=new Rectangle(e.x,e.y,e.width,e.height);
		
		for(Entity ent: ents)
		{
			if(ent!=e)
			{
				boolean collision=false;
				Rectangle otherBox=new Rectangle(ent.x,ent.y,ent.width,ent.height);
				/*for(int i=0;i<e.height;i++)
					for(int j=0;j<e.width;j++)
						if(ent.getX() == e.getX() && ent.getY() == e.getY())
							collision=true;*/
				if(myBox.intersects(otherBox))
					collisionList.add(ent);
			//	if(ent.getY() == e.getY())
				//	yCollisions.add(ent);
			}
		}
		return collisionList;
	}
}
