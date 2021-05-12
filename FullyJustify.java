package sixDay;

import java.util.ArrayList;
import java.util.Scanner;

//This is an example of Text Justification.

public class FullyJustify {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void spaceInsertion(ArrayList<String> line,int l) {
		int requiredSpace;
		String lastline = line.get(line.size()-1);
		for(String i:line) {
			requiredSpace=l-i.length();
			if(requiredSpace==0) {
				System.out.println(i);
				continue;
			}
			else if(lastline==i) {
				while(requiredSpace-->0) {
					System.out.print(" ");
				}
				System.out.println(i);
			}
			else {
				String[] word = i.split(" ");
				int size = word.length-1;
				requiredSpace+=size;
				int space;
				requiredSpace=(int)requiredSpace/size;
				StringBuilder str = new StringBuilder();
				for(int j=0;j<size;j++) {
					space = requiredSpace;
					str.append(word[j]);
					while(space-->0)
						str.append(" ");
				}
				str.append(word[size]);
				System.out.println(str);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<>();
		
		System.out.print("Enter the words:");
		String input = scan.nextLine();
		String[] word = input.split(" |,");
		int size = word.length;
		System.out.println("Enter the Number of character need to be in line:");
		int letters = scan.nextInt();
		
		int i;
		for(i=0;i<size;i++) {
			String line ="";
			int loopBreaker=letters;

			while(line.length()!=letters && i<size) {
				if(word[i].length()>loopBreaker) {
					i--;
					break;
				}
				else {
					loopBreaker-=(word[i].length()+1);
					line=line+word[i]+" ";
					word[i++]="";
				}
				
			}
			result.add(line);
		}
		for(int j=0;j<size;j++) {
			if(word[j]!="") {
				result.add(word[j]);
			}
		}
		spaceInsertion(result,letters);
	}
}
