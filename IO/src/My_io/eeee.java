package My_io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class eeee {
    static final String path = System.getProperty("user.dir");
    public static void main(String[] args) throws Exception{
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path + "\\hehe.txt"));
        int len=0;
        byte[] data=new byte[1024];
        len=reader.read(data);
        System.out.println(new String(data, 0, len));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path + "\\hehe.txt")));
        String string;
        string=reader1.readLine();
        System.out.println(string);
    }
}
