public class Robot {
	String direction = "";
	int xPos;
	int yPos;
	
	/**
	  Constructor with 3 parameters
	  @param dir the starting position
	  @param x the starting x coordinate
	  @param y the starting y coordinate
	*/
	public Robot(String dir, int x, int y){
		direction = dir;
		xPos = x;
		yPos = y;
	}
	
	//Accessors
	public String getDir(){ return direction; }
	public int getX(){ return xPos; }
	public int getY(){ return yPos; }
	
	
	/**
	  Changes the direction of the robot
	  @param turn left or right from where the robot is standing
	*/
	public void changeDirection(String turn){
		turn = turn.toLowerCase();
		direction = direction.matches("North") ? turn.matches("left")  ? "East"  : "West"  :
			    direction.matches("South") ? turn.matches("left")  ? "West"  : "East"  :
	                    direction.matches("East")  ? turn.matches("left")  ? "South" : "North" :
			 			         turn.matches("left")  ? "North" : "South";		
	}//end changeDirection
	
	
	/**
	  Move the robot after changing direction
	  @param howMany the number of steps to take
	*/
	public void move(int howMany){
		//If we are facing north. Simply add to the y-position. 
		if(direction.matches("North")){
			yPos += howMany;
		}else if(direction.matches("South")){
		//If we are facing South. Subtract from y-position. If moving negative spaces, 
		//the subtraction cancles out and we end up moving north, which is what we want
				yPos -= howMany;
		}else if(direction.matches("East")){
				xPos -= howMany;
		}else{
			xPos += howMany;			
		}			
	}//end move
	
	
}//end robot
