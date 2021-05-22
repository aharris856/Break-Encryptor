//create a file "overload.txt" to make my encryptor struggle
//args[0] = max number to find prime, args[1] = number of lines for "overload.txt"
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class overloader{
	
	public static void main(String[]args)throws Exception
	{
		//USER INPUT && FIND PRIME SECTION ---------------------------------------------------------------
		int maxValue = -1;
		int numLines = -1;
		String maxValueStr = "";
		String numLinesStr = "";
		//if no cmd line input use scanner for input, otherwise use first 2 entries for args
		if(args.length < 2){
			//retrieve values from scanner input
			Scanner kb = new Scanner(System.in);
			System.out.println("Enter a value to use to find the largest prime below this number:");
			maxValueStr = kb.nextLine();
			System.out.println("Enter a value for the number of lines for the 'overload.txt' file:");
			numLinesStr = kb.nextLine();
			kb.close();
		}else{
			maxValueStr = args[0];
			numLinesStr = args[1];
		}

		//convert string input to int values
		try{
			maxValue = Integer.parseInt(maxValueStr);
			numLines = Integer.parseInt(numLinesStr);
		}catch(NumberFormatException e){
			System.out.println("Invalid input... Exitting.");
			System.exit(0);
		}
		if(maxValue == 0 || numLines == 0){
			System.out.println("Input cannot be 0 ... Exitting.");
			System.exit(0);
		}

		//find size of each line which will be the largest prime under maxValue
		int prime = largestPrime(maxValue);
		if(prime == -1){
			System.out.println("Unknown Error in: largestPrime(int max) Method... Exitting.");
			System.exit(0);
		}
		//FILE INPUT SECTION ---------------------------------------------------------------------
		//generate str to print into file
		String content = "";
		for(int i = 0; i < prime; i++)
			content = content+"0";

		File f = new File("overload.txt");
		if(f.exists())f.delete();
		//write into file using print writer
		FileWriter fw = new FileWriter("overload.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		for(int i = 0; i < numLines;i++)
			pw.println(content);

		pw.close();
		bw.close();
		fw.close();
	}

	//returns largest prime below 'int max'
	static int largestPrime(int max)
	{
		if(max < 0)max = -max;
		if(max == 1 || max == 2)return max;	
		//check all numbers below and including max to see if they are prime. return largest val.
		for(int i = max; i > 0; i--)
			if(isPrime(i))return i;
		return -1;//should never reach this point but if there is an error in my calculations -1 will be returned and system will exit.
	}

	//returns if input is prime or not
	static boolean isPrime(int n)
	{
		if(n == 0 || n == 1)return false;
		if(n == 2)return true;
		if(n%2 == 0)return false;//even => not prime

		//min val is 3 since 0 1 and 2 are all rulled out
		//max needed to check is sqrt(n)
		//increasing by 2 because we only need to check odds since we know evens aren't prime
		for(int i = 3; i <= Math.sqrt(n); i+=2)
			if(n%i == 0)return false;//not prime
		//prime if passed all checks
		return true;
	}

}
