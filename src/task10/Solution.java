package task10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
    public double findSquare() throws IOException {
        File file = new File("./src/task10/points.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }

        class Vec {
            int x, y;

            @Override
            public String toString() {
                return "(" + x +", " + y + ')';
            }
        }
        ;
        int iVec = 0;
        Vector<Vec> vector = new Vector<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner scannerPoints = new Scanner(line);
            Vec vec = new Vec();
            if (!scannerPoints.hasNextInt()) {
                System.out.println("point x not found");
                return 0;
            }
            vec.x = scannerPoints.nextInt();
            if (!scannerPoints.hasNextInt()) {
                System.out.println("point y not found");
                return 0;
            }
            vec.y = scannerPoints.nextInt();
            System.out.println("vec[" + (iVec++) + "] = " +  vec);
            vector.add(vec);
        }

        if (vector.size() <= 1) {
            System.out.println("vector size = " + vector.size() + ", fail");
            return 0;
        }

        double square = 0;
        for (int i = 1; i < vector.size(); i++) {
            Vec vec1 = vector.elementAt(i-1);
            Vec vec2 = vector.elementAt(i);
            /**/
            square += ((vec1.y+vec2.y)/2.)* (vec2.x-vec1.x);
        }

        System.out.println("square = " + square);
        return square;
    }

    public static void main(String[] args) throws IOException {
        new task10.Solution().findSquare();
    }
}
