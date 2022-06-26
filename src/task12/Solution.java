package task12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public void findMerchant(String name) throws IOException {
        // write your code here
        File file = new File("./src/task12/outcome.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }

        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()){
            System.out.println("failed, file has no any line");
            return;
        }
        /*header*/
        System.out.println(scanner.nextLine());
        /**/
        String regex = "\\d+;(\\w+);(\\w+);(\\d+);(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        int allSumm = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher =  pattern.matcher(line);
            if (!matcher.find() || (matcher.groupCount() != 4)){
                System.out.println("failed, unknown format line," + line);
            }
            String nameTrader = matcher.group(1);
            if (name.equals(nameTrader)){
                String product = matcher.group(2);
                String quantity = matcher.group(3);
                String price = matcher.group(4);
                int sumPrice = Integer.parseInt(quantity) * Integer.parseInt(price);
                allSumm += sumPrice;
                System.out.println(product+','+quantity+','+price+','+sumPrice);
            }
        }
        if (allSumm != 0){
            float tax = allSumm * 0.15f;
            int iTax = (int)tax;
            int fTax = (int)((tax - iTax)*10) % 10;
            System.out.println("tax: " + iTax + '.' + fTax);
        }
    }

    public static void main(String[] args) throws IOException {
        new task12.Solution().findMerchant("Cherevik");
    }
}
