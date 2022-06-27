package task15;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public Set<String> getVariantIndex(String[] arr) {
        Set<String> res = new HashSet<>();
        int size = arr.length;
        int d2 = 2;
        int d3 = 3;
        int dSize = size / d2 + 1;
        Integer[] dVec = new Integer[dSize];
        Arrays.fill(dVec, d2);
        for (int it = 0; it < 100; it++) {
            int dNext = 0;
            String s = "";
            int itDVec = 0;
            for (int i = 0; i < size; ) {
                int d = dNext;
                s += arr[i]+" ";
                dNext = dVec[itDVec];
                itDVec += 1;
                i += dNext;
            }
            res.add(s);
            boolean isAll = true;
            for (int i = 0; i < dVec.length; i++) {
                if (dVec[i] != d3) {
                    isAll = false;
                    break;
                }
            }
            if (isAll){
                break;
            }
            int pLast = dVec.length - 1;
            while (dVec[pLast]==d3){
                dVec[pLast]=d2;
                pLast -= 1;
            }
            dVec[pLast]=d3;
        }

        return res;
    }

    int getMax(Collection<String> setStr)
    {
        int maxSumm = 0;
        for (String s : setStr) {
            Scanner scannerTrees = new Scanner(s);
            int tmpSumm = 0;
            while(scannerTrees.hasNextInt())
            {
                int value = scannerTrees.nextInt();
                tmpSumm += value;
            }
            maxSumm = Math.max(maxSumm, tmpSumm);
        }
        return maxSumm;
    }

    public void solution() throws IOException {
        File file = new File("./src/task15/trees.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }

        Scanner scanner = new Scanner(file);
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Vector<String> treesFromFile = new Vector<>();
        {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String val = matcher.group();
                    treesFromFile.add(val);
                }
            }
        }
        if (treesFromFile.size()<=3){
            int maxSumm = getMax(treesFromFile);
            System.out.println(maxSumm);
            return;
        }

        List<String> listTrees1 = treesFromFile.subList(0, treesFromFile.size()-1);
        List<String> listTrees2 = treesFromFile.subList(1, treesFromFile.size());
        String []arrTrees1 = listTrees1.toArray(new String[listTrees1.size()]);
        String []arrTrees2 = listTrees2.toArray(new String[listTrees2.size()]);
        Set<String> index1 = getVariantIndex(arrTrees1);
        Set<String> index2 = getVariantIndex(arrTrees2);

        int maxSumm1 = getMax(index1);
        int maxSumm2 = getMax(index2);
        int maxSumm = Math.max(maxSumm1, maxSumm2);

        System.out.println(maxSumm);
    }

    public static void main(String[] args) throws IOException {
        new task15.Solution().solution();
    }
}
