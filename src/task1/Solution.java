package task1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static String getReceipt() throws IOException {
        // write your code here
        File file = new File("files/receipt.txt");
        if (!file.exists()) {
            System.out.println("file %s not found".formatted(file.getPath()));
        }

        System.out.println(Arrays.toString(new File("./").list()));
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("[а-яА-Я]+;(\\d+);(\\d+.?\\d*)");
        float res = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                final var g0 = matcher.group(0);
                final var number = Integer.parseInt(matcher.group(1));
                final var price = Float.parseFloat(matcher.group(2));
                /**/
                System.out.println("number = %d".formatted(number));
                System.out.println("price = %f".formatted(price));
                res += number * price;
            }
        }
        //<Продукт>;<Количество>;<Цена за 1 шт>.

        return Float.toString(res);
    }

    public static void main(String[] args)  throws IOException{
        System.out.println(getReceipt());
    }
}
