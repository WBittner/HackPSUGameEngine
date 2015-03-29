
public abstract class Entity {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected GameEngine ge;
	String type;
	
	public Entity(int startx, int starty, int w, int h, String t)
	{
		x = startx;
		y = starty;
		width = w;
		height = h;
		type = t;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void updateLocation(int newx, int newy)
	{
		x = newx;
		y = newy;
	}
	
	public void setGameEngine(GameEngine g)
	{
		ge = g;
	}
	//gets
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
	//sets
	public void setX(int newx)
	{
		x = newx;
	}
	public void setY(int newy)
	{
		y = newy;
	}
	
	public abstract void tick();
}
