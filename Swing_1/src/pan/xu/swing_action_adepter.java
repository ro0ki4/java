package pan.xu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing_action_adepter extends JFrame {
    static JTextArea text1;
    static JTextArea text2;
    JButton button;
    Timer timer;
    public swing_action_adepter(String str){
        super();
        this.setTitle(str);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel pane=new JPanel();
        button=new JButton("交换");
        text1=new JTextArea(20,20);
        text1.setVisible(true);
        text2=new JTextArea(20,20);
        text2.setVisible(true);
        JMenuBar bar=new JMenuBar();
        this.setJMenuBar(bar);
        //MenuBar menuBar=new MenuBar();
        JMenu first=new JMenu("设置");
        JMenuItem tuchu=new JMenuItem("退出");
        first.add(tuchu);
        ////开始键盘事件的记录
        text1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //text1.append("徐攀\n");
                text1.append("键盘"+KeyEvent.getKeyText(e.getKeyCode())+"键\n");
                System.out.println("xupan");


            }
        });


        ////结束


        //定时器
       timer=new Timer(1000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               text2.append("xupan\n");
               text2.append(timer.getLogTimers()+"");

           }
       });
       timer.start();

        ///结束

        ///开始退出设置
        ActionListener actionListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getDefaultCloseOperation();
                //setDefaultCloseOperation(1);
                System.exit(1);

            }
        };
        tuchu.addActionListener(actionListener);
        ////结束



        JMenu second=new JMenu("彩蛋");
        second.add(new JMenuItem("没有彩蛋 "));
        //menuBar.add(first);
        //menuBar.add(second);
        bar.add(first);
        bar.add(second);
        pane.add(text1);
        pane.add(text2);
        pane.add(button);
        pane.setVisible(true);
        this.add(pane);



        //窗口控制开始
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("窗口关了");
            }
        });
        ///窗口控制结束


        this.setVisible(true);
    }
    void setText1(String str){
        text1.setText(str);
    }
    private void setText2(String str){
        text2.setText(str);
    }
    public static void main(String []args){
        swing_action_adepter xupan=new swing_action_adepter("徐攀");
        xupan.setSize(600,300);
        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mid=text1.getText();
                text1.setText(text2.getText());
                text2.setText(mid);

            }
        };
        xupan.button.addActionListener(ac);
    }
}
