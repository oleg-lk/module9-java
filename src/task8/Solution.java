package task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public void solution(double n) throws IOException {
        File file = new File("./src/task8/EGE.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()){
            return;
        }
        scanner.nextLine();/*skip*/
        String regex = "(\\w+);(\\d+);(\\d+.?\\d*);(\\d+.?\\d*)";
        Pattern pattern = Pattern.compile(regex);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()){
                continue;
            }
            int count = matcher.groupCount();
            if (count!=4){
                continue;
            }
            String g0 = matcher.group(1-1);
            String subject = matcher.group(2-1); /*Subject*/
            String quantity = matcher.group(3-1); /*Quantity*/
            String passed = matcher.group(4-1);
            String g4 = matcher.group(5-1);
            float passedFloat = Float.parseFloat(passed);
            if (passedFloat > n){
                System.out.println(subject);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new Solution().solution(80);
    }
}
