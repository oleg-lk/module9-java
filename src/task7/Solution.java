package task7;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public void dance() throws IOException {
        // write your code here
        File file = new File("./src/task7/dance.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        String[] test = new File("Root/src/").list();
        for (String s : test) {
            System.out.println(s);
        }

        File fileOut = new File(file.getParent() + "/rhythm.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()){
            return;
        }
        int rythm = Integer.parseInt(scanner.nextLine());
        //Writer writer = new FileWriter(fileOut);

        FileOutputStream fos = new FileOutputStream(fileOut);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int steps = Integer.parseInt(line);
            int intNum = steps/ rythm;
            int dev = steps % rythm;
            writer.write(String.valueOf(intNum)+" " + dev);
            writer.newLine();
          }
        writer.close();
    }

    public static void main(String[] args) throws IOException{
        new Solution().dance();
    }
}
