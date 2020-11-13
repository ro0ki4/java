package pan.xu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class REALLY_BIRD_GAME extends JFrame implements ActionListener {
    //
    //
    //
    @Override
    public void actionPerformed(ActionEvent e){

    }
    ///////////////////////////////////////////////////////
    public REALLY_BIRD_GAME(){
        super();
        this.setTitle("hehe");
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //content=this.getContentPane();

        //JLayeredPane layeredPane=new JLayeredPane();
        //this.setLayeredPane(layeredPane);
        //System.out.println(this.getContentPane().toString());

        my_JPanel panel2=new my_JPanel("background.png",0,0,900,600);

        //layeredPane.add(panel2,200);
        this.add(panel2);
        //this.add(panel2);

        my_JPanel panel1=new my_JPanel("bird.png",50,50,30,30);
        this.add(panel1);
        panel1.setOpaque(false);
        this.getRootPane().setOpaque(false);
        //layeredPane.add(panel1,0);

        this.setVisible(true);
    }
    public static void main(String[]args){
        new REALLY_BIRD_GAME();
    }
}

class my_JPanel extends JPanel{
    private static final String path="C:\\Users\\10517\\Desktop\\java\\really_bird_game\\src\\pan\\xu\\";
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    public my_JPanel(){
    }
    public my_JPanel(String string,int x,int y,int width,int height){
        //image=new ImageIcon(path+string).getImage();
        this.name=string;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public void paint(Graphics g){
        super.paint(g);
        Image image=new ImageIcon(path+name).getImage();
        g.drawImage(image,x,y,width,height,null);
    }
}