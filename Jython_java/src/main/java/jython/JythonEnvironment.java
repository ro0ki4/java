package jython;

import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public final class JythonEnvironment {
    /**
     * jython环境,生成python解释器
     * 单例
     */
    private static volatile JythonEnvironment INSTANCE = new JythonEnvironment();

    private JythonEnvironment(){}

    public static JythonEnvironment getInstance(){
        if(INSTANCE == null)
            INSTANCE = new JythonEnvironment();
        return INSTANCE;
    }
    /**
     * 获取python的系统状态，需要指定classloader和一些sys模块
     * 用来帮助获取python的解释器
     */
    private PySystemState getPySystemState(){
        PySystemState.initialize();
        final PySystemState py = new PySystemState();
        py.setClassLoader(getClass().getClassLoader());
        return py;
    }

    /**
     * 获取python的解释器
     */
    public PythonInterpreter getPythonInterpreter(){
        return new PythonInterpreter(null, getPySystemState());
    }


}
