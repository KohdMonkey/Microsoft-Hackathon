/*
@author Tuan A. Tran
*/
import java.util.*;
import java.io.*;
import java.util.Map;

public class Sample {
		
	public static int checkStrings(String str, String query){
		boolean identical = true;
		char[] arr1 = str.toCharArray();
		char[] arr2 = query.toCharArray();
		//we only need to search for however long the query is
		for(int i = 0; i < query.length(); i++){
			if(arr1[i] != arr2[i])
				identical = false;
		}
		
		return identical? 1 : 0;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt");		
		
		int N = Integer.parseInt(reader.readLine());
		writer.println(N);
		
		String query = ""; 
		String str = "";
		int result;
		
		for(int i = 0; i < N; i++){			
			result = 0;
			query = reader.readLine();
			str = reader.readLine();
			str = str.toLowerCase();
			query = query.toLowerCase();
			
			int index = str.indexOf(query.charAt(0));
			
			/*There are two possible situations:
			 * if theres a space in the string to match, we don't care if there's one
			 * in the query, therefore we erase spaces in both strings and match regularly
			 * For example: "Luke Johnston" is matched by "luke j" and "lukej"
			 * On the other hand, if there's no space in the matching string, but one
			 * exists in the query, then they would not match
			 * For example: "luke j" should not match "lukejohnston"
			 * Checking if the index of space is < query length is important because
			 * otherwise query would match since string might have spaces after
			 * */
			
			
			if(index >= 0 && (index == 0 || str.charAt(index - 1) == ' ')){
				String temp = str.substring(index);
				index = temp.indexOf(' ');
				if(index < query.length() - 1){
					temp = temp.replaceAll("\\s+", "");
					query = query.replaceAll("\\s+", "");
				}
				result = checkStrings(temp, query);				
			}
			writer.println(result);
		}
		writer.close();
	}
}
