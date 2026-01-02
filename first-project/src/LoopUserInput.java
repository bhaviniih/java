import java.util.Scanner;

public class LoopUserInput{
    public static void main(String[] args){
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

        System.out.println("You enterd: " + number);

        scanner.close();
    }
}