package icu.bleuweb.socket;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketTest {

    @Test
    public void testSocket() {
        try {
            Socket socket = new Socket("127.0.0.1", 5005);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是我的第一个socket";
            while (true) {
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
//            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
