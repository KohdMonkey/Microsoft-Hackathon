/*
@author Tuan A. Tran
*/
import java.util.*;
import java.text.*;
import java.io.*;


public class Sample {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		
		PrintWriter writer = new PrintWriter("out.txt");		
		
		String line = "";
		String[] strs = new String[2];
		int howMany = 0;
		
		Robot r = new Robot("North", 0, 0);
		
		while((line = reader.readLine()) != null){
			strs = line.split(" ");			
			
			if(strs[0].matches("Move")){	
				howMany = Integer.parseInt(strs[1]);								
				r.move(howMany);
			}else{
				r.changeDirection(strs[1]);
			}
		}//end read file	
		
		writer.println(r.getX() + "," + r.getY());		
		
		writer.close();
	}//end main
}//end class
