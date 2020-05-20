import java.util.Scanner;
public class studentDetails {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String[] nameArr = {"Peter", "Jane", "Lucy", "John", "Patrick"};
      int[] markArr = {67, 50, 77, 89, 34};
      String[] gradeArr = finalGrade(markArr);
      assignGrade(markArr, gradeArr);
      gradeArr = finalGrade(markArr);
      int option;
      do {
         option = displayMenu();
         switch (option) {
            case 1: displayStudentDetails(nameArr, markArr);
               break;
            case 2: calculateAverage(markArr);
               break;
            case 3: displayAboveAverage(nameArr, markArr);
               break;
            case 4: displayStudentDetailsWithGrade(markArr, gradeArr, nameArr);
               break;
            case 5: int i = findLowestMark(markArr);
               System.out.println("\nThe student with the lowest mark " + markArr[i] + " is " + nameArr[i]);
               break;
            case 6: System.out.print("\nEnter lower mark : ");
               int lowermark = input.nextInt();
               System.out.print("Enter upper mark : ");
               int uppermark = input.nextInt();
               displayStudentDetailsWithMarkRange(lowermark, uppermark, markArr, gradeArr, nameArr);
               break;
            case 0: System.out.print("Bye");
               break;
            default: System.out.println("You have input an invalid code...");
               break;
         } 
      } while (option != 0);
   }
   public static int displayMenu() {
      Scanner input = new Scanner(System.in);
      System.out.println("Main Menu");
      System.out.println("1) Display student names and marks");
      System.out.println("2) Calculate and display the average mark");
      System.out.println("3) Display students with marks above the average marks");
      System.out.println("4) Display student details with grade");
      System.out.println("5) Display student with the lowest mark");
      System.out.println("6) Display students with given mark range");
      System.out.println("0) Exit");
      System.out.print("Enter your option : ");
      int option = input.nextInt();
      return option;
   }
   public static void displayStudentDetails(String[] nameArr, int[] markArr) {
      System.out.println("S/No\tName\t\tMark");
      for (int i=1; i<=nameArr.length; i++)
         System.out.println(i+".\t" + nameArr[i-1] + "\t\t" + markArr[i-1]);
   }
   public static void calculateAverage(int[] markArr) {
      int sum = 0;
      for (int i=0; i<markArr.length; i++)
         sum = sum + markArr[i];
      double average = sum/5.0;
      System.out.println("The average mark is " + average);
   }
   public static void displayAboveAverage(String[] nameArr, int[] markArr) {
      System.out.println("Students who score above average:");
      int x=1;
      for (int i=0; i<markArr.length; i++) {
         if (markArr[i] > 63.4) {
            System.out.println(x+". "+nameArr[i]);
            x++;
         }
      }
   
   }
   public static String[] finalGrade(int[] markArr) {
      String[] grade = new String[5];
      for (int i=0; i<markArr.length; i++) {
         if (markArr[i]>=80)
            grade[i] = "A";
         else if (markArr[i]>=70)
            grade[i] = "B";
         else if (markArr[i]>=60)
            grade[i] = "C";
         else if (markArr[i]>=50)
            grade[i] = "D";
         else
            grade[i] = "F";
      }
      return grade;
   }
   public static void assignGrade(int[] markArr, String[] gradeArr) {
      gradeArr = finalGrade(markArr);
   }
   public static void displayStudentDetailsWithGrade(int[] markArr, String[] gradeArr, String[] nameArr) {
      System.out.println("S/No\tName\t\tMark\tGrade");
      System.out.println("----\t----\t\t----\t-----");
      for (int i=0; i<markArr.length; i++)
         System.out.println(i+1+".\t"+nameArr[i]+"\t\t"+markArr[i]+"\t"+gradeArr[i]);
   }
   public static int findLowestMark(int[] markArr) {
      int x=0;
      for (int i=1; i<markArr.length; i++)
         if (markArr[x]>markArr[i])
            x=i;
      return x;
   }
   public static void displayStudentDetailsWithMarkRange(int lowermark, int uppermark, int[] markArr, String[] gradeArr, String[] nameArr) {
      System.out.println("Student details for mark range " + lowermark + " to " + uppermark);
      System.out.println("S/No\tName\tMark\tGrade");
      for (int i=0; i<markArr.length; i++)
         if(markArr[i]<=uppermark && markArr[i]>=lowermark)
            System.out.println(i+1 + "\t" + nameArr[i] + "\t" + markArr[i] + "\t" + gradeArr[i]);
   }
}