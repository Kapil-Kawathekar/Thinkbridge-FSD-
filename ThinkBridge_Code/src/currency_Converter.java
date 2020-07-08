import java.util.InputMismatchException;
import java.util.Scanner;

public class currency_Converter {
	static String  unit_place [] = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ",
									"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ",
									"Seventeen ","Eighteen ","Nineteen "};
	
	
	
	static String tens_place [] = {"","","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	
	
	
	
	static String number_Into_Words(int number,String s) {
		String output="";
		if(number>19) {
			output+=tens_place[number/10]+unit_place[number%10];
		}else {
			output+=unit_place[number];
		}
		if(number!=0) {
			output+=s;
		}
		return output;
	}
	
	
	static String conversion_Into_Words(Double number) {
		
		String output="";
		
		output+=number_Into_Words((int)((number/100000)%100),"Lakh ");
		
		output+=number_Into_Words((int)((number/1000)%100),"Thousand ");
		
		output+=number_Into_Words((int)((number/100)%10),"Hundred ");
		
		if(number>100 && number%100>0) {
			output+="And ";
		}
		output+=number_Into_Words((int)(number%100),"");
		
		return output;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		System.out.println("------------------------------------------------");
		System.out.println("Welcome to Currency to Word Converter ..");
		System.out.println("------------------------------------------------\n");
		
		String choice="yes";
		while(choice.equals("yes")) {
			System.out.println("\nEnter the Currency Value :  ");
			double number=0.0,f=0.0;
			String temp;
			int indexOfDecimal=0;
		while(true) {
			try {
				sc = new Scanner(System.in);
				number=sc.nextDouble();
				while(number<0.0 || number >999999.99 ) {
					System.out.println("\nEnter the Valid currency Value..!! ( Number value must be in the range [ 0, 9,99,999.99 ] ) :"); 
					number=sc.nextDouble();
				}
				f = (double) (number-Math.floor(number));
				temp = String.valueOf(number);
				indexOfDecimal = temp.indexOf(".");
				break;
			}
			catch(InputMismatchException | NumberFormatException e) {
				System.out.println("\nEnter the number and not any Symbol/Character/String.. :");
				continue;
			}
		}
			
			if(number==0) {
				System.out.print("\nRs. Zero ONLY ");
			}else {
				String output=conversion_Into_Words(number);
				if(f>0) {
					System.out.print("\nRs. "+output);
					if(indexOfDecimal+3>temp.length()) {
						System.out.print(temp.substring(indexOfDecimal+1,indexOfDecimal+2));
						System.out.println("0/100 ONLY.");
					}else {
						System.out.print(temp.substring(indexOfDecimal+1,indexOfDecimal+3));
						System.out.println("/100 ONLY.");
					}
				
				}else {
					System.out.print("Rs. "+output+"ONLY.");
				}
			}
			System.out.println();
			System.out.println("\nWould you like to perform another conversion?(Yes/No) :");
			//String choice1=sc.nextLine();
			choice=sc.next().toLowerCase();
			while((!choice.equals("yes"))&&(!choice.equals("no"))) {
				System.out.println("\n"+choice+" is not a valid option. Try again....(--Type Yes /No--) : " ); 
				choice=sc.next().toLowerCase();
			}
			
		}
		System.out.println("------------------------------------------------");
		System.out.println("Thank You for Using Converter Application..!!!");
		System.out.println("------------------------------------------------");
		
	}

}
