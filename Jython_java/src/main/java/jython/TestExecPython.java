package jython;


import org.python.util.PythonInterpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum TestExecPython
{
    INSTANCE;

    public void test()
    {   Properties props = new Properties();
        //C:\Users\10517\AppData\Local\Programs\Python\Python37\Lib
//        props.put("python.home", "C:\\maven\\apache-maven-3.6.1-bin\\apache-maven-3.6.1\\conf\\repository\\org\\python\\jython\\2.7.1b3");
//        props.put("python.console.encoding", "UTF-8");
//        props.put("python.security.respectJavaAccessibility", "false");
//        props.put("python.import.site", "false");
//        Properties preprops = System.getProperties();
//        PythonInterpreter.initialize(preprops, props, new String[0]);

        ///////////////////////////////////////
        String path = System.getProperty("user.dir")+"\\src\\main\\java\\wowo.py";
        System.out.println(path);
        String scriptFile = path;
        Map<String,String> properties = new HashMap<String,String>();
        properties.put("userName", "Demo");

        ExecPython.INSTANCE.execute(scriptFile, properties);
    }
}
