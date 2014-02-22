
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
		if(direction.matches("North")){
			if(turn.matches("left"))
				direction = "East";
			else
				direction = "West";			
		}else if(direction.matches("South")){ 
			if(turn.matches("left"))
				direction = "West";
			else
				direction = "East";			
		}else if(direction.matches("East")){
			if(turn.matches("left"))
				direction = "South";
			else
				direction = "North";
		}else{
			if(turn.matches("left"))
				direction = "North";
			else
				direction = "South";
		}		
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
