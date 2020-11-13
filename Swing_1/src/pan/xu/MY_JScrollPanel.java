package pan.xu;

import javax.swing.*;
import java.awt.*;

public class MY_JScrollPanel extends JFrame {
    public MY_JScrollPanel(){
        //super();

        //this.setSize(100,50);
        JPanel my_panel=new JPanel();
        JPanel my_panel2=new JPanel();
        my_panel.setPreferredSize(new Dimension(100,50));
        //my_panel.setSize(100,40);
        JTextField text1=new JTextField(10);
        JTextField text2=new JTextField(10);
        JTextField text3=new JTextField(10);
        JTextField text4=new JTextField(10);
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setSize(100,50);
        //my_panel2.add(scrollPane);
        my_panel.add(text1);
        my_panel.add(text2);
        my_panel.add(text3);
        my_panel.add(text4);
        scrollPane.setViewportView(my_panel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setContentPane(scrollPane);
        this.setSize(100,40);
        this.setLocation(100,100);
        this.setTitle("fuck");
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

    }
    public static void main(String[]args){
        MY_JScrollPanel xupan=new MY_JScrollPanel();
        xupan.setSize(100,50);

    }
}
