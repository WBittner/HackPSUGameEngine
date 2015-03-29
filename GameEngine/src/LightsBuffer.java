import java.awt.Color;
import java.util.ArrayList;


public class LightsBuffer {
		
	private int width;
	private int height;
	private int size;
	private int[] buf;
	private ArrayList<Color> colorBuf;
	
	final Color COLOR_BALL = Color.RED;
	final Color COLOR_PADDLE = Color.BLUE;
	final Color COLOR_WALL = Color.GREEN;
	
	/*
	 * @params 	width = width of light array in units of a singular light 
	 * 			height = height of light array in units of a singular light
	 */
	public LightsBuffer(int w, int h)
	{
		width = w;
		height = h;
		size = width * height;
		buf = new int[size];
		colorBuf = new ArrayList<Color>();
		
		for(int i = 0; i < size; i++)
			colorBuf.add(Color.BLACK);
	}
	
	public void clear()
	{
		for(int i = 0; i < size; i++)
			setIndex(i, Color.BLACK);
	}
	
	public int getIntIndex(int i)
	{
		return buf[i];
	}
	
	public Color getColorIndex(int i)
	{
		return colorBuf.get(i);
	}
	
	public void setIndex(int index, int value)
	{
		if(index<size&& index>=0)
		{
			buf[index]= value;
			colorBuf.set(index, new Color(value));
		}
		//else
			//System.out.print("q");
	}
	
	public void setIndex(int index, Color color)
	{
		if(index<size&& index>=0)
		{
			colorBuf.set(index, color);
			buf[index] = color.getRGB();
		}
		//else
			//System.out.println("OOB");
	}
	
	
	public int[] getIntBuffer()
	{
		return buf;
	}
	
	public ArrayList<Color> getColorBuffer()
	{
		return colorBuf;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	

}
