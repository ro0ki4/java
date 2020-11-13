package pan.xu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String []args){
        main_windows xu=new main_windows();
        xu.show_windows();
    }
}
class main_windows{
    static JTextField l=new JTextField(20);
    static JTextField m=new JTextField(20);
    public void show_windows(){
        JFrame jf=new JFrame("徐攀");
        jf.setSize(600,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时自动停止程序
        jf.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));//层次结构
        /////////////////////////////////////////
        /*
        Button bt1=new Button("1");
        Button bt2=new Button("2");
        Button bt3=new Button("3");
        ////////////////////////////////////////
        JTextPane jt1=new JTextPane();///////
        JTextArea ja1=new JTextArea();//////
        jt1.setBackground(Color.blue);

*/
        ////////////////////////////////////
        JPanel pane=new JPanel();
        //pane.setLayout(new BorderLayout());
        jf.setContentPane(pane);
        JButton b=new JButton("清空文本框中的信息");
        pane.add(b,"South");
        pane.add(l,"North");
        pane.add(m);
        //jf.setContentPane(pane);
        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=new main_windows().l.getText();
                new main_windows().l.setText("傻逼");
                new main_windows().m.setText(str);

            }
        };
        b.addActionListener(ac);
        //jf.setContentPane(pane);
        //////////////////////////////////

        /*
        JPanel jp=new JPanel();
        jp.add(ja1);
        jp.add(jt1);
        Button bt=new Button("anniu");

        //jp.add(bt);//将按钮组件添加到中将容器中
        JMenuBar jm=new JMenuBar();
        JMenu menu1=new JMenu("文件");
        JMenu menu2=new JMenu("设置");
        JMenuItem it1=new JMenuItem("打开");
        JMenuItem it2=new JMenuItem("不设置了");
        menu1.add(it1);
        menu2.add(it2);
        jm.add(menu1);
        jm.add(menu2);
        jf.setJMenuBar(jm);
        jp.add(bt1);
        jp.add(bt);
        jp.add(bt2);
        jp.add(bt3);
        jf.setContentPane(jp);//易得

         */
        jf.setVisible(true);//窗口可见
    }
}
/*
class ActionHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
        new main_windows().l.setText("");
    }
}

 */