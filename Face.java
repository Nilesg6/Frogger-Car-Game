import pkg.*;

public class Face {
		
	private Ellipse skin;	
	private double x,y,x2,y2;
	private double MX,MY;
	private double GFACTOR;
	
	private Rectangle smile1;
	private Rectangle smile2;
	private Rectangle smile3;
	private Rectangle smile4;
	private Rectangle smile5;
 	
	
	public Face(double x, double y, double GFACTOR){
			
			skin = new Ellipse(x,y,110/GFACTOR,110/GFACTOR);
			skin.setColor(Color.RED);
			
			smile1 = new Rectangle(x+25/GFACTOR,y+25/GFACTOR,10/GFACTOR,30/GFACTOR);			
			smile1.setColor(Color.BLACK);
		
			smile2 = new Rectangle(x+75/GFACTOR,y+25/GFACTOR,10/GFACTOR,30/GFACTOR);			
			smile2.setColor(Color.BLACK);
			
			smile3 = new Rectangle(x+25/GFACTOR,y+75/GFACTOR,10/GFACTOR,10/GFACTOR);			
			smile3.setColor(Color.BLACK);
			
			smile4 = new Rectangle(x+35/GFACTOR,y+85/GFACTOR,40/GFACTOR,10/GFACTOR);			
			smile4.setColor(Color.BLACK);
		
			smile5 = new Rectangle(x+75/GFACTOR,y+75/GFACTOR,10/GFACTOR,10/GFACTOR);			
			smile5.setColor(Color.BLACK);
		
		x = skin.getX();
		y = skin.getX();
		x2 = skin.getWidth();
		y2 = skin.getHeight();
	}
	
	public void create(){
		skin.fill();
		smile1.fill();
		smile2.fill();
		smile3.fill();
		smile4.fill();
		smile5.fill();
	}
	
		public void translate(double MX, double MY){
		skin.translate(MX,MY);
		smile1.translate(MX,MY);
		smile2.translate(MX,MY);
		smile3.translate(MX,MY);
		smile4.translate(MX,MY);
		smile5.translate(MX,MY);
	}
	
	public int getX(){
			return skin.getX();
	}

	public int getY(){
			return skin.getY();
	}

	public int getX2(){
			return (skin.getWidth() + skin.getX());
	}

	public int getY2(){
			return (skin.getHeight() + skin.getY());
	}
	
	public int getWidth(){
			return (skin.getWidth() + skin.getY());
	}

	public int getHeight(){
			return (skin.getHeight() + skin.getY());
	}
	
	// public boolean contains(Rectangle b)
	// {
		
		// if((x < b.getX();
	// }
	
}



