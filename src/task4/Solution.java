package task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Solution {
    public void writeOrder() throws IOException {
        // write your code here
        File file = new File("./src/task4/numbers.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        File fileOut = new File(file.getParent() + "/output.txt");
        if (!fileOut.exists()){
            fileOut.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        Writer writer = new FileWriter(fileOut, false);
        int indLine = 1;
        String res = "0";
        while(scanner.hasNextInt())
        {
            int num = scanner.nextInt();
            if (num == indLine){
                if (res.equals("0")){
                    res = Integer.toString(num);
                }
                else {
                    res += " " + num;
                }

            }
            indLine += 1;
        }
        writer.write( res);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().writeOrder();
    }
}
