/*
Programmer: Tuan A. Tran
*/
import java.util.*;
import java.text.*;
import java.io.*;


public class Sample {
		

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		
		PrintWriter writer = new PrintWriter("out.txt");		
		
	
		int N = Integer.parseInt(reader.readLine());
		double totalSeconds; 
		double hour, minute,second;
		String[] timeArr; 
		double hourAngle, minuteAngle, secondAngle, hourMinAngle, minSecAngle, hourSecAngle;
		
		writer.println(N);
		
	
		for(int i = 0; i < N; i++){
			totalSeconds = 0.0;
			hourAngle = minuteAngle = secondAngle = hourMinAngle = minSecAngle = hourSecAngle = 0.0;
			
			timeArr = reader.readLine().split(":");
			
			hour = Double.parseDouble(timeArr[0]);
			minute = Double.parseDouble(timeArr[1]);
			second = Double.parseDouble(timeArr[2]);
			
			//An hour has 3600 seconds, a minute has 60 seconds, and a second has... 1 second :O
			totalSeconds = ((hour * 3600) + (minute * 60) + second);
			
			
			//Hour hand moves at 360 / (12hours * 60minute * 60second) degree per second
			//So it moves at 1/120 degree per second			
			hourAngle = (totalSeconds / 120) % 360;
			
			//Minute hand moves at 360 / (60minute * 60second) degree per second
			//So it moves at 1/10 degree per second
			minuteAngle = (totalSeconds / 10) % 360;
						
			//The second hand itself moves at 6 degree per second
			secondAngle = (totalSeconds * 6) % 360;
			
			hourMinAngle = Math.abs(hourAngle - minuteAngle);
			//since the requirement is angle between 0 and 180, we have to subtract from 360.
			if(hourMinAngle > 180) hourMinAngle = 360 - hourMinAngle;
			
			hourMinAngle = Math.round(hourMinAngle * 100.0) / 100.0;
			
			hourSecAngle = Math.abs(hourAngle - secondAngle);
			if(hourSecAngle > 180) hourSecAngle = 360 - hourSecAngle;
			hourSecAngle = Math.round(hourSecAngle * 100.0) / 100.0;
			
			minSecAngle = Math.abs(minuteAngle - secondAngle);
			if(minSecAngle > 180) minSecAngle = 360 - minSecAngle;
			minSecAngle = Math.round(minSecAngle * 100.0) / 100.0;
			
			writer.printf("%.2f, %.2f, %.2f\n", hourMinAngle, hourSecAngle, minSecAngle);		
		}
		writer.close();
	}//end main
}//end class
