package task6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
    public void solution() throws IOException {
        File file = new File("./src/task6/data.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        File fileOut = new File(file.getParent() + "/output.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }

        Scanner scanner = new Scanner(file);
        if (!scanner.hasNextLine()) {
            System.out.println("faile first int");
            return;
        }
        int maxDeltaLen = Integer.parseInt(scanner.nextLine());
        System.out.println("maxDeltaLen = " + maxDeltaLen);
        Vector<String> vecLines = new Vector<>();
        int allLen = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            allLen += line.length();
            vecLines.add(line);
        }
        if (vecLines.size() == 0) {
            return;
        }
        int midLen = allLen / vecLines.size();
        Writer outWriter = new FileWriter(fileOut);
        outWriter.write(String.valueOf(midLen)+"\n");
        for (String vecLine : vecLines) {
            if (Math.abs(vecLine.length() - midLen) <= maxDeltaLen) {
                outWriter.write(vecLine);
            }
        }
        outWriter.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}
