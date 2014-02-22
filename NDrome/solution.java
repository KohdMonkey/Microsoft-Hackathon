/*
@author Tuan A. Tran
*/
import java.util.*;
import java.io.*;
import java.util.Map;

public class Sample {
	
	public static int checkPalindrome(String str){
		boolean isPalindrome = true;
		char[] myArr = str.toCharArray();
		int end = myArr.length - 1;		
		for(int i = 0; i <= end; i++){
			if(myArr[i] != myArr[end])
				isPalindrome = false;
			end--;
		}		
		return isPalindrome ? 1 : 0;
	}
	
	public static int checkStrings(char[] arr, int i, int j, int N){
		boolean isValid = true;
		for(int x = 0; x < N ;x++){
			if(arr[i] != arr[j])
				isValid = false;
		}
		return isValid? 1 : 0;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader  = new BufferedReader(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt");
		
		boolean end = false;
		
		
		String line = null;
		String[] temp = new String[2]; 
		int i = 0;//variable to walk from beginning of string
		int j = 0;//variable to walk from end of the string
		int result;//result for each line
		char[] myArr; //array to store each string
				
		while((line = reader.readLine()) != null){
			result = 0;
			temp = line.split("\\|");	
			
			int N = Integer.parseInt(temp[1]);
			
			//if N is one, do a normal palindrome check
			if(N == 1){
				result = checkPalindrome(temp[0]);
			}else{
				//Since N drome checks N characters, if the length has left over
				//then the string is uneven resulting in unequal parts.
				if(temp[0].length() % N != 0){
					result = 0;				
				}else{
					i = 0;//set the starting position
					myArr = line.toCharArray(); //convert the string into a character array
					/*The first check we want to position j correctly.
					 * abc abc abc abc ->to check this we want to position at the first and last a
					 * after the first round we only need to subtract/add N to move the positions
					 * For the above string, [length]12 - ([N]3 - 1) - 1) = 6. Which is different
					 * from [length]12 - ([N]3 - 2) = 11. 
					 * The main idea is to check each N characters to see if they match
					 * */				
					j = (temp[0].length() - (N - 1) - 1);
					for(i = 0; i < j; i += N){
						result = checkStrings(myArr, i, j, N);
						j -= N;
					}				
				}
			}
			String out = line + "|" + result + "\n";
			writer.write(out);				
		}
		writer.close();
	}
}
