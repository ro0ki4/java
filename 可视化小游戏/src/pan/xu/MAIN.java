package pan.xu;

import javax.swing.*;
import java.awt.*;

public class MAIN extends JFrame {

    public MAIN(){
        super();
        this.setTitle("五子棋");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLocation(500,200);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        this.setVisible(true);
    }
    public static void main(String[]args){
        MAIN e=new MAIN();
    }
}
