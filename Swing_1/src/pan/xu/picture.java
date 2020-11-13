package pan.xu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class picture extends JFrame {
    JLayeredPane layeredPane=new JLayeredPane();
    String path="C:\\Users\\10517\\Desktop\\java\\Swing_1\\src\\pan\\xu\\";
    public picture(){
        super();
        //this.setLayeredPane(layeredPane);

        this.setTitle("图片");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,400);
        ImageIcon image=new ImageIcon(path+"9.jpg");

        System.out.println(image.getIconHeight());
        this.setVisible(true);
        JPanel panel=new JPanel();
        //mypanel panel=new mypanel();
        panel.setBounds(0,0,image.getIconWidth(),image.getIconHeight());

        JLabel label=new JLabel();
        label.setIcon(image);
        //label.setBounds(0,0,60,30);
        panel.add(label);
        layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);
        //this.add(panel);
        this.setLayeredPane(layeredPane);
        this.setVisible(true);

    }
    public static void main(String []args){
        picture ee=new picture();
    }
}


class mypanel extends JPanel{
    Image image=null;
    public void paint(Graphics g){
        try{
            image= ImageIO.read(new File("C:\\Users\\10517\\Desktop\\9.jpg"));
            g.drawImage(image,0,0,600,300,null);
            //System.out.println(image.getWidth(null));

        }catch(Exception e){
            System.out.println("chuduole");
        }
    }
}
