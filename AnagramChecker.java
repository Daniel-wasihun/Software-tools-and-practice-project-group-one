package tools;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
	
	 public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first word:");
	    String str1 = input.nextLine();
	    System.out.print("Enter the second word:");
	    String str2 = input.nextLine();
	    if(isAnagrams(str1,str2)) {
	    	System.out.println("they are anagram");
	    }else {
	    	System.out.println("they are not anagram");
	    }
	    }    

	public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    public  static boolean isAnagrams(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }
}
