package jython2;

import org.python.util.PythonInterpreter;

import java.util.Properties;

public class motherfuck {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("python.home", "C:\\maven\\apache-maven-3.6.1-bin\\apache-maven-3.6.1\\conf\\repository\\org\\python\\jython\\2.7.1b3");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        ///////////////////////////////////////
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("print(\"mother,fucker\")");
    }
}
