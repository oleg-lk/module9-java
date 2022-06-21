package submodule2;

import java.io.IOException;
import java.io.InputStream;

public class OneZeroStream extends InputStream {
    private int cnt = 0;
    private boolean isOne = true;

    @Override
    public int read() throws IOException {
        cnt += 1;
        if (cnt % 3 == 0) {
            cnt = 0;
            isOne = !isOne;
            return -1;
        }
        int curByte = cnt == 1 ? (isOne ? '1' : '0') : ' ';
        return curByte;
    }

}
