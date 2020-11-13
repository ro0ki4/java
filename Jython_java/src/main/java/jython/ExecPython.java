package jython;

import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.util.Map;

import java.util.Map.Entry;
import java.util.Properties;

/**
 * java调用python
 */

public enum ExecPython
{
    INSTANCE;

    public void execute(String scriptFile, Map<String,String> properties)
    {
        //C:\Users\10517\AppData\Local\Programs\Python\Python37\Lib
        Properties props = new Properties();
        props.put("python.home", "C:\\Users\\10517\\AppData\\Local\\Programs\\Python\\Python37\\Lib");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        ///////////////////////////////////////////////
        //获取python解释器
        final PythonInterpreter inter = JythonEnvironment.getInstance().getPythonInterpreter();

        //设置python属性,python脚本中可以使用
        for (Entry<String,String> entry : properties.entrySet())
        {
            inter.set(entry.getKey(),entry.getValue().toString());
        }
        try
        {
            //通过python解释器调用python脚本
            inter.exec("print(\"hehe\")");
            inter.exec("import sys");
            inter.execfile(scriptFile);

            //inter.exec("import numpy");
        }
        catch (Exception e)
        {
            System.out.println("ExecPython encounter exception:" + e);
        }
    }
}

