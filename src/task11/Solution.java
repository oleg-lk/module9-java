package task11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Solution {
    public void solve() throws IOException {
        File file = new File("./src/task11/arithmetic.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        File fileOut = new File(file.getParent() + "/answers.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }

        Writer writer = new FileWriter(fileOut);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner scannerLine = new Scanner(line);
            if (!scannerLine.hasNextInt()) {
                System.out.println("left opperand not found");
                continue;
            }
            int left = scannerLine.nextInt();
            if (!scannerLine.hasNext("[\\*+-]")) {
                System.out.println("opperation not found");
                continue;
            }
            String op = scannerLine.next("[\\*+-]");
            if (!scannerLine.hasNextInt()) {
                System.out.println("right opperand not found");
                continue;
            }
            int right = scannerLine.nextInt();
            int res = 0;
            switch (op) {
                case "+" :
                    res = left + right;
                    break;
                case "-" :
                    res = left - right;
                break;
                case "*" :
                    res = left * right;
                break;
            };
            String resLine = line + " = " + res;
            System.out.println(resLine);
            writer.write(resLine + "\n");
        }
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        new task11.Solution().solve();
    }
}

/*
There was 1 failure:
1) test(FinderTest)
java.lang.AssertionError: Your answer is:
'5 + 3 = 8
2 * 8 = 16
13 - 7 = 6
20 * 5 = 100
'
Correct answer is:
'5 + 3 = 8
2 * 8 = 16
13 - 7 = 6
20 * 5 = 100'
* */