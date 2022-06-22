package submodule3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Root/files/request.txt");
        FileOutputStream fileOut = new FileOutputStream(file, false);

        fileOut.write("GIVE ME THE CODE, PLEASE".getBytes(StandardCharsets.UTF_8));
    }
}
