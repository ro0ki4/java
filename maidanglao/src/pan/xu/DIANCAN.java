/*
package pan.xu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class DIANCAN extends JFrame implements ActionListener {
    ArrayList<JTextField> text=new ArrayList<>();
    JTextField text1;//汉堡15/
    JLabel label1;
    JTextField text2;//鸡腿12/
    JLabel label2;
    JTextField text3;//可乐5/
    JLabel label3;
    JTextField text7;//鸡翅/4
    JLabel label7;
    JTextField text4;//应付价钱
    JLabel label4;
    JTextField text5;//顾客付的价钱
    JLabel label5;
    JTextField text6;//找零
    JLabel label6;
    //////////////////是否有优惠卷//8折
    String path=System.getProperty("user.dir")+"\\src\\pan\\xu\\";
    public DIANCAN(){
        super();
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("麦当劳结算系统");
        center();
        GridBagLayout layout=new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints constraints=new GridBagConstraints();
        text1=init_text(text1);
        text2=init_text(text2);
        text3=init_text(text3);
        text4=init_text(text4);
        text5=init_text(text5);
        text6=init_text(text6);
        text6.setEditable(false);
        text7=init_text(text7);
        label1=new JLabel("汉堡/15");
        label2=new JLabel("鸡腿/12");
        label3=new JLabel("可乐/5");
        label7=new JLabel("鸡翅/4");
        label4=new JLabel("应付价钱");
        label5=new JLabel("实付价钱");
        label6=new JLabel("找零");
        add_to_constratints(label1,constraints,0,0,1,1);
        add_to_constratints(label2,constraints,6,0,1,1);
        add_to_constratints(text1,constraints,1,0,1,1);
        JLabel label11=new JLabel();
        ImageIcon icon11=new ImageIcon(path+"汉堡.png");
        label11.setIcon(icon11);
        add_to_constratints(label11,constraints,2,0,2,2);

        add_to_constratints(text2,constraints,7,0,1,1);
        JLabel label22=new JLabel();
        ImageIcon icon22=new ImageIcon(path+"鸡腿.png");
        label22.setIcon(icon22);
        add_to_constratints(label22,constraints,8,0,2,2);

        add_to_constratints(label3,constraints,0,2,1,1);
        add_to_constratints(label7,constraints,6,2,1,1);
        add_to_constratints(text3,constraints,1,2,1,1);
        ImageIcon icon33=new ImageIcon(path+"可乐.png");
        JLabel label33=new JLabel();
        label33.setIcon(icon33);
        add_to_constratints(label33,constraints,2,2,2,2);

        add_to_constratints(text7,constraints,7,2,1,1);
        ImageIcon icon77=new ImageIcon(path+"鸡翅.png");
        JLabel label77=new JLabel();
        label77.setIcon(icon77);
        add_to_constratints(label77,constraints,8,2,2,2);

        add_to_constratints(label4,constraints,0,4,1,1);
        add_to_constratints(label5,constraints,6,4,1,1);
        add_to_constratints(text4,constraints,1,4,1,1);
        add_to_constratints(text5,constraints,7,4,1,1);
        add_to_constratints(label6,constraints,1,6,1,1);
        add_to_constratints(text6,constraints,2,6,2,1);
        Timer timer=new Timer(1000,this);
        timer.start();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int num1=0,num2=0,num3=0,num4=0,num5=0,num6=0;
            if("".equals(text1.getText()))
                num1=0;
            else
                num1=Integer.parseInt(text1.getText());
            if("".equals(text2.getText()))
                num2=0;
            else
                num2=Integer.parseInt(text2.getText());
            if("".equals(text3.getText()))
                num3=0;
            else
                num3=Integer.parseInt(text3.getText());
            if("".equals(text7.getText()))
                num4=0;
            else
                num4=Integer.parseInt(text7.getText());
            if("".equals(text5.getText()))
                num5=0;
            else
                num5=Integer.parseInt(text5.getText());
            text4.setText((15*num1+12*num2+5*num3+4*num4)+"");
            if(num5==0)
                ;
            else {
                num6 = num5 - (15 * num1 + 12 * num2 + 5 * num3 + 4 * num4);
                if(num6>0)
                    text6.setText(num6+"");
            }
            if(num5!=0){
                File file=new File(path+"doc.txt");
                try{
                    OutputStream stream=new FileOutputStream(file);
                    String str="汉堡 ----------15/个"+num1+"\n鸡腿 ----------12/个"+num2+"\n可乐 ----------5/杯"+num3+"\n鸡翅 ----------4/个"+num4+
                            "\n应付钱 ----------"+(15*num1+12*num2+5*num3+4*num4)+"\n实付钱 ----------"+num5+
                            "\n找零 ----------"+num6;
                    byte[]data=str.getBytes();
                    stream.write(data);

                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
    }

    void add_to_constratints(Component component,GridBagConstraints constraints,int x,int y,int w,int h){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        this.add(component,constraints);
    }

    void center(){//将窗口放于屏幕中间
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension size=kit.getScreenSize();
        this.setLocation(size.width/2-300,(size.height/2-300));
    }

    JTextField init_text(JTextField text){
        text=new JTextField(10);
        return text;
    }

    public static void main(String[]args){
        DIANCAN e=new DIANCAN();
    }
}

interface PRODUCT{
    public abstract JTextField create_name();
    public abstract JLabel create_picture(String string);
}

class init_text implements PRODUCT{
    @Override
    public JTextField create_name() {
        return new JTextField(10);
    }

    @Override
    public JLabel create_picture(String string) {
        return new JLabel(string);
    }
}

 */