package task9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public void solution(String district, int fromYear, int toYear) throws IOException {
        district = district.trim();
        File file = new File("./src/task9/crop_volumes.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        File fileOut = new File(file.getParent() + "/data.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }

        Writer writer = new FileWriter(fileOut);
        writer.write("Part;"+fromYear+";"+toYear+"\n");

        Vector<Integer> dates = new Vector<>();
        boolean isFirstLine = true;
        String partLine = "";
        String districtLine = "";
        String regexHeader = "^([\\w\\s]+);([\\w\\s]+);";
        String regexNums = "(\\d+\\.?\\d+)";
        Pattern patternNums = Pattern.compile(regexNums);
        /**/
        Matcher matcher;
        /**/
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            String header = scanner.nextLine();
            {
                Pattern pattern = Pattern.compile(regexHeader);
                matcher = pattern.matcher(header);
            }
            if (!matcher.find()) {
                System.out.println("something wrong");
                return;
            }
            int cnt = matcher.groupCount();
            if (matcher.groupCount() != 2) {
                System.out.println("something wrong");
                return;
            }
            if (!isFirstLine) {
                partLine = matcher.group(1);
                districtLine = matcher.group(2).trim();
            }

            {
                String lineNums = header.substring(matcher.end());
                matcher = patternNums.matcher(lineNums);
            }

            Vector<Float> harvest = new Vector<>();
            while (matcher.find()) {
                String fnd = matcher.group();
                if (isFirstLine) {
                    int date = Integer.parseInt(fnd);
                    dates.add(date);
                    System.out.println("date = " + date);
                } else {
                    float data = Float.parseFloat(fnd);
                    harvest.add(data);
                    System.out.println("data = " + data);
                }
            }

            if (!isFirstLine){
                if (harvest.size()!=dates.size()){
                    System.out.println("something wrong");
                    continue;
                }

                if ( district.equals(districtLine) ){
                    float dlt = 0;
                    float start = -1;
                    float end = -1;
                    for (int i = 0; i < dates.size(); i++) {
                        if (dates.elementAt(i) == fromYear){
                            start = harvest.elementAt(i);
                        }
                        else if (dates.elementAt(i) == toYear){
                            end = harvest.elementAt(i);
                        }
                    }
                    /**/
                    if (start == -1 || end == -1){
                        System.out.println("period not found");
                        continue;
                    }
                    /**/
                    if ((end-start)>4){
                        System.out.println(partLine);
                        writer.write(partLine+";"+start+";"+end);
                    }
                }
            }

            isFirstLine = false;
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().solution(" South  ", 2017, 2020);
    }
}
