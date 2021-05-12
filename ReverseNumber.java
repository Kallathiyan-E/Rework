package question;
//Question 1
import java.util.Scanner;
public class ReverseNumber{
	private static Scanner scan = new Scanner(System.in);
	
	public static void reverse(int num) {
		System.out.print("Reversed Number =");
		while(num!=0) {
			System.out.print(num%10);
			num/=10;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\t\tReversing Number");
		System.out.print("Enter Number =");
		int input = scan.nextInt();
		reverse(input);
	}
}
