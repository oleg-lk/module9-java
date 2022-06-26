package task13;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Map<Character, String> map = new HashMap<>();

    private void initMap()
    {
        map.put('A', "1000001");
        map.put('B', "1000010");
        map.put('C', "1000011");
        map.put('D', "1000100");
        map.put('E', "1000101");
        map.put('F', "1000110");
        map.put('G', "1000111");
        map.put('H', "1001000");
        map.put('I', "1001001");
        map.put('J', "1001010");
        map.put('K', "1001011");
        map.put('L', "1001100");
        map.put('M', "1001101");
        map.put('N', "1001110");
        map.put('O', "1001111");
        map.put('P', "1010000");
        map.put('Q', "1010001");
        map.put('R', "1010010");
        map.put('S', "1010011");
        map.put('T', "1010100");
        map.put('U', "1010101");
        map.put('V', "1010110");
        map.put('W', "1010111");
        map.put('X', "1011000");
        map.put('Y', "1011001");
        map.put('Z', "1011010");
        map.put('.', ".");
        map.put(',', ",");
        map.put('?', "?");
        map.put(' ', " ");
        map.put('\'', "'");
        map.put('!', "!");
    }

    public String translate() throws IOException {
        /**/
        initMap();
        /**/
        File file = new File("./src/task13/message.txt");
        if (!file.exists()) {
            System.out.println("file " + file.getAbsolutePath() + " not found");
        }

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        boolean isFirst = true;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!isFirst){
                stringBuilder.append("\n");
            }
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                String translateString = map.get(ch);
                stringBuilder.append(translateString);
            }
            isFirst = false;
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        new task13.Solution().translate();
    }
}
