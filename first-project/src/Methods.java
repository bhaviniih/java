import java.util.Scanner;

public class Methods{
    // Method 1: ask user for a positive number
    public static int getPositiveNumber(){
        Scanner scanner = new Scanner(System.in);

        int number = 0;

        while(number <= 0){
            System.out.println("Enter a positive number: ");

            if(scanner.hasNextInt()){
                number = scanner.nextInt();
            } else {
                System.out.println("❌ Numbers only!");
                scanner.next();
            }

            // OR

            // String input = scanner.nextLine();
            // try{
            //     number = Integer.parseInt(input);
            // } catch (NumberFormatException e) {
            //     System.out.println("❌ Please enter numbers only!");
            // }
        }

        // System.out.println("You enterd: " + number);

        // scanner.close();
        return number;
    }

    // Method 2: print numbers from 1 to n
    public static void printNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int number = getPositiveNumber();
        printNumbers(number);
    }
}