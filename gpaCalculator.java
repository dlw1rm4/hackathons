package gpaCalc;
import java.util.Scanner;
import java.util.ArrayList;

public class gpaCalculator {
	public static double unweighted(ArrayList<Integer> arr) {
		int UWclasses = classes(arr);
		int UWpoints = points(arr);
		return (double) UWpoints / UWclasses;
	}
	public static double weighted(Integer ep, ArrayList<Integer> arr) {
		int Wclasses = classes(arr);
		int Wpoints = points(arr) + ep;
		return (double) Wpoints / Wclasses;
	}
	public static int points(ArrayList<Integer> arr) {
		int totalPoints = 0;
		for(int inc = 0; inc < arr.size(); inc++) {
			if (inc == 0) {
				totalPoints += (4 * arr.get(inc));
			}
			else if (inc == 1) {
				totalPoints += (3 * arr.get(inc));
			}
			else if (inc == 2) {
				totalPoints += (2 * arr.get(inc));
			}
			else if (inc == 3) {
				totalPoints += (1 * arr.get(inc));
			}
		}
		return totalPoints;
	}
	public static int classes(ArrayList<Integer> arr) {
		int totalClasses = 0;
		for(int inc = 0; inc < arr.size(); inc++) {
			totalClasses += arr.get(inc);
		}
		return totalClasses;
	}
	public static void main(String args[]) {
		ArrayList<Integer> gradeYear = new ArrayList<>();
		Scanner c = new Scanner(System.in);
		
		System.out.println("Grade Calculator:\n\nGrades: A, B, C, D, F\nEnter Q to quit");
		
		System.out.print("\nDid you take any weighted classes? If so, how many? --> ");
		int weightClass = c.nextInt();
		
		System.out.print("\nEnter the amount of As --> ");
		gradeYear.add(c.nextInt());
		System.out.print("\nEntered succesfully. Enter the amount of Bs --> ");
		gradeYear.add(c.nextInt());
		System.out.print("\nEntered successfully. Enter the amount of Cs --> ");
		gradeYear.add(c.nextInt());
		System.out.print("\nEntered successfully. Enter the amount of Ds --> ");
		gradeYear.add(c.nextInt());
		System.out.print("\nEntered successfully. Enter the amount of Fs --> ");
		gradeYear.add(c.nextInt());
		System.out.println("\nEntered succesfully.");
		
		while(true) {
			System.out.print("\n\nWhat would you like to do?\n\tCalculate Unweighted GPA (Enter 1)\n\tCalculate Weighted GPA (Enter 2)\n\tQuit (Enter Q)\n\nEnter choice --> ");
			String choice = c.next();
			if(choice.equals("1")) {
				System.out.print("\n\nYour unweighted GPA is: " + unweighted(gradeYear));
			}
			else if(choice.equals("2")) {
				System.out.print("\n\nYour weighted GPA is: " + weighted(weightClass, gradeYear));
			}
			else if(choice.equals("Q") || choice.equals("q")) {
				System.out.println("Successfully quit.");
				break;
			}
			else {
				System.out.println("Error. Try again.");
			}
		}
	}
}
