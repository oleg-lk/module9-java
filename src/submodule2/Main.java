package submodule2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i += 1) {
            System.out.print(scanner.nextInt());
        }
    }
}
