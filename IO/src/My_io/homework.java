package My_io;

import java.io.*;

public class homework {
    public static void main(String[] args) throws Exception{
        /*
        FileInputStream input = new FileInputStream(My_io.path + "\\hehe.txt");
        FileOutputStream output = new FileOutputStream(My_io.path + "\\haha.txt", true);
        int b=0;
        byte[] ee=new byte[1024];
        
        while((b=input.read())!=-1){
            output.write(b);
        }
        
        
        b=input.read(ee);
        output.write(ee,0,b);
        output.close();
    
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(My_io.path + "\\hehe.txt"));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(My_io.path + "\\haha.txt"));
        int b=0;
        while((input.read())!=-1){
            output.write(b);
        }
        output.close();
        FileReader reader = new FileReader(My_io.path + "\\hehe.txt");
        FileWriter writer = new FileWriter(My_io.path + "\\haha.txt");
        int b=0;
        while((b=reader.read())!=-1){
            writer.write(b);
        }
        writer.close();*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        while (!(s = reader.readLine()).equals("")) {
            System.out.println(s);
        }
    }
}
