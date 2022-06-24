package task5;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public boolean arePalindromes() throws IOException {
        File file = new File("./src/task5/strings.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
           Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            line = line.toLowerCase();
            line = line.replaceAll("\\s+", "");
            System.out.println("line = " + line);
            int len = line.length();
            int len_2 = len / 2;
            for (int i = 0; i < len_2; i++) {
                if (line.charAt(i)!=line.charAt(len-1-i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(new Solution().arePalindromes());
    }
}
