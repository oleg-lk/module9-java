package task16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    class FileSystem {
        String name;
        String ext;
        int size;
        /*1-bytes, 1024-kbytes, 1024*1024-mbytes*/
        int unitSize;

        static public String getUnitName(int unit) {
            switch (unit) {
                case 1:
                    return " B\n";
                case 1024:
                    return " KB\n";
                case 1024 * 1024:
                    return " MB\n";
                default:
                    return "Er\n";
            }
        }

        public FileSystem(String name, String ext, int size, int unitSize) {
            this.name = name;
            this.ext = ext;
            this.size = size;
            this.unitSize = unitSize;
        }
    }
    public void getOutput() throws IOException {
        File file = new File("./src/task16/files.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }
        File fileOut = new File(file.getParent() + "/output.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        Vector<FileSystem> fileSystem = new Vector<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner scannerLine = new Scanner(line);
            String regexFile = "\\w+\\.(txt|zip|bmp)";
            if (!scannerLine.hasNext(regexFile)) {
                System.out.println("something wrong");
            }
            String fileName = scannerLine.next(regexFile);
            String fileExt = "";
            Pattern pattern = Pattern.compile(regexFile);
            Matcher matcher = pattern.matcher(fileName);
            if (matcher.find()) {
                fileExt = matcher.group(1);
            }
            if (!scannerLine.hasNextInt()) {
                System.out.println("something wrong");
            }
            int size = scannerLine.nextInt();
            String regexFileUnit = "(B|MB|KB)";
            if (!scannerLine.hasNext(regexFileUnit)) {
                System.out.println("something wrong");
            }
            String unitSizeStr = scannerLine.next(regexFileUnit);
            int unitSize = 1;
            if (unitSizeStr.equals("KB")) {
                size = size * 1024;
                unitSize = 1024;
            } else if (unitSizeStr.equals("MB")) {
                size = size * 1024 * 1024;
                unitSize = 1024 * 1024;
            }
            /**/
            fileSystem.add(new FileSystem(fileName, fileExt, size, unitSize));
        }
        fileSystem.sort(new Comparator<FileSystem>() {
            @Override
            public int compare(FileSystem o1, FileSystem o2) {
                int resExt = o1.ext.compareTo(o2.ext);
                if (resExt == 0) {
                    return o1.name.compareTo(o2.name);
                }
                return resExt;
            }
        });

        if (fileSystem.size() == 0) {
            return;
        }

        Writer writer = new FileWriter(fileOut);
        /**/
        int maxUnit = 1;
        int groupSize_bytes = 0;
        String currentGroup = fileSystem.elementAt(0).ext;
        for (FileSystem system : fileSystem) {
            if (!system.ext.equals(currentGroup)) {
                int summary = groupSize_bytes / maxUnit;
                writer.write("----------\n");
                writer.write("Summary: " + summary + FileSystem.getUnitName(maxUnit) );
                writer.write("\n");
                /**/
                currentGroup = system.ext;
                groupSize_bytes = 0;
                maxUnit = 1;
            }
            maxUnit = Math.max(system.unitSize, maxUnit);
            groupSize_bytes += system.size;
            writer.write(system.name + "\n");
        }
        /**/
        writer.write("----------\n");
        int summary = (int) Math.ceil((double)groupSize_bytes / maxUnit);
        writer.write("Summary: " + summary + FileSystem.getUnitName(maxUnit));
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        new task16.Solution().getOutput();
    }
}
