package pan.xu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing_action_1 extends JFrame {
    JButton b;
    static int flag=1;
    public swing_action_1(String str){
        super(str);
        b=new JButton("确定");
        JPanel pane=new JPanel();
        this.setSize(600,200);

        pane.setLayout(new BorderLayout());
        this.add(pane);
        pane.add(b);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                flag++;
                if(flag%2==0)
                    b.setText("麻美了");
                else
                    b.setText("把没了");
            }
        });
    }
    public static void main(String []args){
        swing_action_1 xupan=new swing_action_1("xupan");

    }
}
