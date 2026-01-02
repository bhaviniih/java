public class EnhancedForLoop{
    public static void main(String[] args) {

        int[] numbers = {5, 10, 15, 20};

        System.out.println("Array Enhanced For Loop elements:");

        int sum = 0;

        for (int n : numbers) {
            sum += n;
            System.out.println(n);
        }

        System.out.println("Array Enhanced For Loop sum: " + sum);
    }
}