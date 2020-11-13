package jython;


import com.sun.xml.internal.ws.api.message.stream.InputStreamMessage;
import org.python.util.PythonInterpreter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Main
{
    public static void main(String[] args)
    {
//        Properties props = new Properties();
//        props.put("python.home", "C:\\maven\\apache-maven-3.6.1-bin\\apache-maven-3.6.1\\conf\\repository\\org\\python\\jython\\2.7.1b3");
//        props.put("python.console.encoding", "UTF-8");
//        props.put("python.security.respectJavaAccessibility", "false");
//        props.put("python.import.site", "false");
//        Properties preprops = System.getProperties();
//        PythonInterpreter.initialize(preprops, props, new String[0]);
        TestExecPython.INSTANCE.test();

        try {
            Process process = Runtime.getRuntime().exec("python fuckyou.py");
            BufferedInputStream in = new BufferedInputStream(process.getInputStream());
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
//            while((line = in.readLine())!=null){
//                System.out.println(line);
//            }
            byte[] pool = new byte[1024];
            in.read(pool);
            System.out.println(new String(pool));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}