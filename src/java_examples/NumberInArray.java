package java_examples;


public class NumberInArray {
    public static void main(String[] args) {
        int numbers[] = {50, -9, -10, 45, 20, -4, 10, 0, 20, 25, 10, 25};

        for (int element:numbers) {
            System.out.print(element + " ");
        }

        int length = numbers.length;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < length; i++) {
            if(sum >= 100)
                break;
            sum += numbers[i];
            count++;
        }

        System.out.println("\nЧтобы получить сумму 100, нужно сложить " + count + " чисел");
    }
}