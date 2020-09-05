import pkg.*;

public class starter implements InputKeyControl {
		
	static Face face;	
	static boolean lose;
	static int Score, lvl;
	//static int n = 4;
	//static Car[] traffic = new Car[n];
	//static Car[] tleft = new Car[n];
	//static int placeholder;
	static Text level;
	static int time = 8000;
	
        public static void main(String args[])
        {
			
			int n = 0;
			System.out.println("Easy, Medium, or Hard?");
			EasyReader read = new EasyReader();
			String difficulty = read.readLine();
			KeyController mC = new KeyController(Canvas.getInstance(),new starter());
			if(difficulty.equalsIgnoreCase("easy")){
				n=4;
				time = 6000;
			}
			if(difficulty.equalsIgnoreCase("medium")){
				n=5; 
				time = 5000;
			}
			if(difficulty.equalsIgnoreCase("hard")){
				n=6;
				time = 3000;
			}
			else{
				n =4 ;
				time = 6000;
			}
			
			time = time + 5000;
			
			int bgr = (int)((Math.random()*86)+94);			
			int bgb = (int)((Math.random()*86)+94);
		
			Rectangle bg = new Rectangle(0,0,600,600);
			bg.setColor(new Color(bgr,255,bgb));
			bg.fill();
			
			Rectangle lane1 = new Rectangle(0,100,600,50);
			lane1.setColor(new Color(120,120,120));
			lane1.fill();

			Rectangle lane2 = new Rectangle(0,200,600,50);
			lane2.setColor(new Color(120,120,120));
			lane2.fill();
			
			Rectangle lane3 = new Rectangle(0,300,600,50);
			lane3.setColor(new Color(120,120,120));
			lane3.fill();
			
			Rectangle lane4 = new Rectangle(0,400,600,50);
			lane4.setColor(new Color(120,120,120));
			lane4.fill();
						
			Rectangle lane5 = new Rectangle(0,500,600,50);
			lane5.setColor(new Color(120,120,120));
			lane5.fill();

			
			
			
			// int n = 6;
			Car[] traffic = new Car[n];
			Car[] tleft = new Car[n];
			
			int[] speedx  = new int[n];
			int[] leftspeedx  = new int[n];
			
			Score = 0;
			lvl = 1;
			level = new Text(10,10,new String("Level: "+lvl));
			level.draw();		
			
			Text info = new Text(10,30,new String("You can't move up"));
			info.draw();
			
			Text info2 = new Text(10,50,new String("Each level increases the speed of the cars"));
			info2.draw();
			
			//int y = 0;	
			
			for(int i = 0; i < n; i++)
			{
				speedx[i] = (int)((Math.random()*8)+4);	
			
				int r = (int)((Math.random()*256));
				int g = (int)((Math.random()*256));
				int b = (int)((Math.random()*256));
				
				int x = (int)((Math.random()*570));	 
				int y = (int)((Math.random()*5));	 
					
				
				y = 100 + y*100;
				
				traffic[i] = new Car(x,y);
				traffic[i].setColor(r,g,b);
				traffic[i].fill();			

				// y++;
			
			}
			
			//y = 0;
			
			for(int ii = 0; ii < n; ii++)
			{

				leftspeedx[ii] = (int)(-1*((Math.random()*8)+4));	
				
				
				int r = (int)((Math.random()*256));
				int g = (int)((Math.random()*256));
				int b = (int)((Math.random()*256));
				
				int x = (int)((Math.random()*570));	 
				int y = (int)((Math.random()*5));			
				
				y = 100 + y*100;		
				
				tleft[ii] = new Car(x,y);
				tleft[ii].setColor(r,g,b);
				tleft[ii].fill();
				tleft[ii].faceLeft();
			
				// y++;
			}

			
			face = new Face(285,20,7);			
			face.create();
			lose = true;
	
			int c = 0;
			
		int score = 0;	
	
		while(lose == true){
		
			if(time>0){
			Canvas.pause(time);
			}
			
			
			if(face.getY() > 600)
			{
				face.translate(0,-610);
			
				Score+=1;
				lvl+=1;
				level.setText("Level: "+lvl);
				
				bgr = (int)((Math.random()*86)+94);		
				bgb = (int)((Math.random()*86)+94);
				bg.setColor(new Color(bgr,255,bgb));
				
				
				time-=300;
				
			}
			
			for(int v = 0; v < n; v++)
			{
				traffic[v].translate(speedx[v],0);
				
				if(traffic[v].getX() > 600){
					traffic[v].translate(-710,0);
				}			
				if(traffic[v].getX() < -110){
					traffic[v].translate(710,0);
				}
				if(traffic[v].contains(face) == true){
					Text GameOver1 = new Text(275,250,"Game Over");
					Text Score1 = new Text(285,350,"Score: " + Score);
					GameOver1.grow(140,100);
					Score1.grow(40,30);
					GameOver1.draw();
					Score1.draw();
					
					// placeholder = v;
					
					// Text restart1 = new Text(285,400,"Press 'r' for restart");
					// restart1.grow(40,30);
					// restart1.draw();
					
					lose = false;
					break;
				}
				
				tleft[v].translate(leftspeedx[v],0);
				
				if(tleft[v].getX() > 600){
					tleft[v].translate(-710,0);
				}			
				if(tleft[v].getX() < -110){
					tleft[v].translate(710,0);
				}
				if(tleft[v].contains(face) == true){
					Text GameOver2 = new Text(275,250,"Game Over");
					Text Score2 = new Text(285,350,"Score: " + Score);
					GameOver2.grow(140,100);
					Score2.grow(40,30);
					GameOver2.draw();
					Score2.draw();
					
					// placeholder = v;
					
					
					// Text restart2 = new Text(285,400,"Press 'r' for restart");
					// restart2.grow(40,30);
					// restart2.draw();
					lose = false;
					break;
				}
			}
			

		}
		}
		
//////////////////////////////////////////		

		public void keyPress(String s)
		{
			if(lose == true){
				if(s.equals("d") && face.getX2() <= 600){
					face.translate(10,0);
				}
				
				
				if(s.equals("a") && face.getX() >= 10){
					face.translate(-10,0);
				}
				
				if(s.equals("s" )){
					face.translate(0,10);
				}
				
				// if(s.equals("r") && (lose == false)){
					// Score = 0;
					// lvl = 1;
					// level.setText("Level: " + lvl);
					
					// face.translate(face.getX()-face.getX(),face.getY()-face.getY());
					//traffic[placeholder].contains() = false;
					//tleft[placeholder].contains() = false;
				// }			
			}
				// if(s.equals("q")){
					// face.translate(-10,-10);
				// }
			
				
				// if(s.equals("e")){
					// face.translate(10,-10);
				// }
				
				// if(s.equals("z")){
					// face.translate(-10,10);
				// }
				
				// if(s.equals("c")){
					// face.translate(10,10);
				// }
		
		}

}



