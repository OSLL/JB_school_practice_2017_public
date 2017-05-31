package java_examples;

import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        System.out.println("Please, input your name");
        String userName = getUserName();
        System.out.println("Hello, " + userName);
    }

    public static String getUserName(){
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        return userName;
    }
}