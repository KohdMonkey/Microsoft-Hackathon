/*
@author Tuan A. Tran
*/
import java.util.*;
import java.io.*;
import java.util.Map;

public class Sample {
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader  = new BufferedReader(new FileReader("in.txt"));
		
		boolean end = false;
		
		
		String line = null;
		String toSubstitute = null;
		String[] lines = new String[200];
		int i = 0;
		
		while((line = reader.readLine()) != null){
			if(line.matches(".*\\|.*")){
				lines[i] = line;	
				i++;
			}else if(!line.matches("^$")){
				toSubstitute = line;
			}			
			
		}
		String[] temp = new String[2];
		
		System.out.println(toSubstitute);
		for(int j = 0; j < i; j++){	
			if(lines[j].matches(".*\\|$")){
				int index = lines[j].indexOf('|');
				temp[0] = lines[j].substring(0, index);
				temp[1] = "";
			}else{
				temp = lines[j].split("\\|");
			}
			
			toSubstitute = toSubstitute.replace(temp[0], temp[1]);
			System.out.println("To Replace: " + temp[0] + " Replace with: " + temp[1]);
		}
		System.out.println(toSubstitute);
	}
}













