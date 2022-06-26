package task14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    final int size = 10;
    int[][] forest = new int[size][size];
    int getRight(int i, int j)
    {
        if ((j+1)>=size)
            return -1;
        return forest[i][j+1];
    }
    int getDown(int i, int j)
    {
        if ((i+1)>=size)
            return -1;
        return forest[i+1][j];
    }

    public int findMaxQuantity() throws IOException {
        File file = new File("./src/task14/forest.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        {
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                int j = 0;
                while (matcher.find()) {
                    String val = matcher.group();
                    forest[i][j++] = Integer.parseInt(val);
                }
                i += 1;
            }
        }
        /**/
        class Vec {
            int i, j;
            int num;
            public Vec(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        ;

        Vec[] vec = new Vec[size + size - 1];
        int indJ = size - 1;
        int indI = size - 1;
        for (int ind = 0; ind < vec.length; ind += 1) {
            vec[ind] = new Vec(indI, indJ);
            if (indJ > 0) {
                vec[ind].num = size - indJ;
                indJ -= 1;
            } else {
                vec[ind].num = indI + 1;
                indI -= 1;
            }
        }

        int cnt = 0;
        for (int i1 = 1; i1 < vec.length-1; i1++) {
            for (int d = 0; d < vec[i1].num; d++) {
                int i = vec[i1].i - d;
                int j = vec[i1].j + d;
                /**/
                int valR = getRight(i, j);
                int valD = getDown(i, j);
                forest[i][j] += Math.max(valR, valD);
                cnt += 1;
            }
        }
        int valR = getRight(0, 0);
        int valD = getDown(0, 0);
        return Math.max(valR, valD) + forest[0][0];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().findMaxQuantity());
    }
}
