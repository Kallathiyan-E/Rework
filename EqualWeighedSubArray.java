package question;
//Question2
//1,0,1,1,1,0,0,0
//1,0,1,1,0,1,0,0,0,1
//1,0,1,1,0,1,0,0,0,0,1
import java.util.Scanner;
public class EqualWeighedSubArray {

	public static void equalizedWeight(int[] array,int zero,int one) {
		int startIndex=0;
		int endIndex=array.length;
		while(zero!=one) {
			if(zero>one && array[startIndex]==0) {
				startIndex++;
				zero--;
			}		
			else if(zero>one && array[endIndex-1]==0) {
				endIndex--;	
				zero--;
			}			
			else if(one>zero && array[startIndex]==1) {
				startIndex++;
				one--;
			}	
			else if(one>zero && array[endIndex-1]==1) {
					endIndex--;	
					one--;
			}
			else if(array[startIndex]==1 && array[endIndex-1]==1) {
				one--;
				endIndex--;
			}
			else if(array[endIndex]==0 && array[endIndex-1]==0) {
				zero--;
				endIndex--;
			}
		}
		System.out.println("Output: "+startIndex+"to"+(endIndex-1));
	}
	
	public static void subArray(int[] array,int zero,int one) {
		if(zero==0 || one==0)
			System.out.println("No sub-array found");
		else if(zero==one) {
			System.out.println("Output:0 to "+(array.length-1));
		}
		else {
			equalizedWeight(array,zero,one);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size=0;
		int oneCount =0;
		int zeroCount =0;
		int element;
		System.out.print("Input:");
		String input = scan.next();
		String[] inputChar = input.split(",");
		int[] array = new int[inputChar.length];
		for(String i:inputChar) {
			element= Integer.parseInt(i);
			array[size++] =element;
			if(element==0)
				zeroCount++;
			else
				oneCount++;
		}
		subArray(array,zeroCount,oneCount);
		scan.close();
	}

}
