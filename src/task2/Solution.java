package task2;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static int getCountWords() throws IOException {
        File file = new File("src/task2/text.txt");
        if (!file.exists()){
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        Scanner scaner = new Scanner(file);
        Pattern pattern = Pattern.compile("\\b\\w+\\S+");
        while (scaner.hasNextLine()){
            final String line = scaner.nextLine();
            Matcher matcher = pattern.matcher(line);
            long cnt = 0;
            while(matcher.find()) {
                cnt++;
            }
            System.out.println(cnt);
        }
        return 1;
        // write your code here
    }

    public static void main(String[] args) throws IOException{
        getCountWords();
    }
}
