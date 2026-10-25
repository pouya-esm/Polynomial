package Polynomial;

import java.util.Scanner;

public class mainClass {
	
	public static void main(String[] args) {
		String equation2="";
		Polynomial poly2=null;
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter equation: ");
		String equation1=inp.nextLine();
		Polynomial poly=new Polynomial(equation1);
		menuloop: while(true) {
		System.out.print("Which operation do you desire to choose?\n1)Addition\t2)Subtraction\t3)Multiply\t4)Division"
				+ "\t5)Evaluation\t6)Exit\nEnter your choice: ");
		int choice=inp.nextInt();
		if ((choice !=5) && (choice !=6)) {
		System.out.print("Enter another equation: ");
		inp.nextLine();
		equation2=inp.nextLine();
		poly2 = new Polynomial(equation2);
		}
		switch (choice) {
		case 1:	System.out.println("The result is: "+poly.addition(poly2));
		break;
		case 2: System.out.println("The result is: "+poly.subtraction(poly2));
		break;
		case 3: System.out.println("The result is: "+poly.multiply(poly2));
		break;
		case 4: System.out.println("The remainder is: "+poly.division(poly2));
		break;
		case 5:	System.out.print("Enter amount of x: ");
		double x=inp.nextDouble();
		System.out.println("The result is: "+ poly.evaluate(x));
		break;
		case 6: break menuloop;
		default: System.out.print("Invalid choice! Try again.\n");
		}
		}
		inp.close();
	}
}
