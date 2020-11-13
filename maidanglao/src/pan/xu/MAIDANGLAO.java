package pan.xu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAIDANGLAO extends JFrame{
    JTextField text1;//输出需要付的钱
    JTextField text2;//输入顾客付的钱
    JTextField text3;//输出找给顾客的钱
    JTextField text4;//打折默认为1.00
    JTextField text5;
    JTextField text6;
    JTextField text7;
    JTextField text8;

    public MAIDANGLAO(){
        //super();
        this.setTitle("麦当劳结算系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,600,400);
        this.setLayout(new BorderLayout());

        this.setBackground(Color.cyan);
        JPanel panel1=new JPanel();
        text1=new JTextField(13);
        text2=new JTextField(13);
        text3=new JTextField(13);
        text3.setEditable(false);
        text4=new JTextField(13);
        text5=new JTextField(13);
        text5.setEditable(false);

        text6=new JTextField(13);
        text6.setEditable(false);

        text7=new JTextField(13);
        text7.setEditable(false);

        text8=new JTextField(13);
        text8.setEditable(false);
        text4.setText("1.00");
        text5.setText("顾客需付钱");
        text6.setText("顾客付的钱");
        text7.setText("找给顾客的钱");
        text8.setText("折扣");
        this.setContentPane(panel1);
        panel1.add(text1);
        panel1.add(text2);
        panel1.add(text3);
        panel1.add(text4);
        panel1.add(text5);
        panel1.add(text6);
        panel1.add(text7);
        panel1.add(text8);
        String fuck="老老实实输折扣";
        Timer timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(("".equals(text1.getText())||"".equals(text2.getText())||"".equals(text4.getText()))){
                }
                else{
                    System.out.println("正常运行");
                    if(Double.parseDouble(text4.getText())>1.0){
                    }
                    else
                        text3.setText((Double.parseDouble(text4.getText()))*(Integer.parseInt(text2.getText())-Integer.parseInt(text1.getText()))+"");

                    }

            }
        });
        timer.start();
        ActionListener ac2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text3.setText("￥"+(Integer.parseInt(text2.getText())-Integer.parseInt(text1.getText()))+"￥");
            }
        };

        this.setVisible(true);


    }

    public static void main(String[]args){
        MAIDANGLAO a=new MAIDANGLAO();
    }
}
