package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("verylongtext.txt"));
            String line;
            StringBuffer content = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                content.append(line); // không tạo nhiều đối tượng mới => tiết kiệm bộ nhớ
            }

            reader.close();
            System.out.println("Độ dài nội dung đọc được: " + content.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
