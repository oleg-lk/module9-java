package submodule2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File f = new File("./asciitable.txt");
        FileInputStream fs = new FileInputStream(f);

        int cntNum = 0;
        int b = 0;
        while ((b=fs.read())!=-1){
            if ((b >= '0') && (b <= '9')){
                cntNum ++;
            }
        }

        System.out.println(cntNum);

        //for (int i = 0; i < f.list().length; i++) {
        //    System.out.println(f.list()[i]);
        //}
    }
}
