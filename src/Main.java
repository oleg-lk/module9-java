import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;

public class Main {

    public static void copyFiles(File srcFile, File dstPath, int bufSize) throws IOException {
        if (!srcFile.exists()){
            System.out.println("files " + srcFile.getAbsoluteFile() + " not found");
        }
        var name = srcFile.getName();
        FileInputStream fileInput = new FileInputStream(srcFile);
        FileOutputStream fileOutput = new FileOutputStream(dstPath + name, false);
        byte [] buf = new byte[bufSize];
        int length;
        while ((length = fileInput.read(buf))>0){
            fileOutput.write(buf, 0, length);
        }
        fileInput.close();
        fileOutput.close();
    }

    public static void copyFormat(File srcFile, String srcEnc, File dst, String dstEnc) throws IOException {
        if (!srcFile.exists()){
            System.out.println("files " + srcFile.getAbsoluteFile() + " not found");
            return;
        }
        Charset srcCharset = Charset.forName(srcEnc);
        Reader reader = new FileReader(srcFile, srcCharset);
        Charset dstCharset = Charset.forName(dstEnc);
        Writer writer = new FileWriter(dst, dstCharset);
        char [] buf = new char[1024];
        int len;
        while ((len= reader.read(buf))>0){
            writer.write(buf, 0, len);
        }
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));

        copyFormat(new File("src/utf8.txt"), "utf-8", new File("src/win.txt"), "windows-1251");

//        int [] arrSize = {1024, 2048, 5000, 10000};
//        for (int i = 0; i < arrSize.length; i++) {
//            final var start = Calendar.getInstance().getTimeInMillis();
//            copyFiles(new File("big.dat"), new File("tmp"), arrSize[i]);
//            final var end = Calendar.getInstance().getTimeInMillis();
//            System.out.println("for size = " + arrSize[i]);
//            System.out.println("time ellapsed = " + (end-start));
//        }

    }
}
