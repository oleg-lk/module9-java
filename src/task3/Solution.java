package task3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
    public static int getMul() throws IOException {
        // write your code here
        int res = 1;
        File file = new File("./src/task3/data.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            Vector<Integer> div = new Vector<Integer>();
            while (scanner.hasNextInt()) {
                int tmp = scanner.nextInt();
                div.add(tmp);
            }
            if (div.size() == 0) {
                System.out.println("some error");
            } else {
                for (int i = 1; i <= num; i++) {
                    for (Integer integer : div) {
                        if (i % integer == 0) {
                            res *= i;
                            break;
                        }
                    }
                }

            }
        } else {
            System.out.println("some error");
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getMul());
    }
}
