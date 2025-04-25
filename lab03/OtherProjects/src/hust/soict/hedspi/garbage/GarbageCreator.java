package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("verylongtext.txt"));
            String line;
            String content = "";

            while ((line = reader.readLine()) != null) {
                content += line; // mỗi lần nối tạo ra 1 đối tượng String mới => tạo nhiều "rác"
            }

            reader.close();
            System.out.println("Độ dài nội dung đọc được: " + content.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
