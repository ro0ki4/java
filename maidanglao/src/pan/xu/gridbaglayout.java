package pan.xu;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class gridbaglayout extends JPanel {
    static final int width=300;
    static final int height=150;
    JFrame frame=new JFrame();
    public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=w;
        constraints.gridheight=h;
        add(c,constraints);

    }
    gridbaglayout(){
        frame = new JFrame("测试");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout lay=new GridBagLayout();
        this.setLayout(lay);
        frame.add(this,BorderLayout.WEST);
        frame.setSize(width,height);
        Toolkit kit=Toolkit.getDefaultToolkit();//将容器设置为屏幕居中
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-this.width)/2;
        int y=(height-this.height)/2;
        frame.setLocation(x,y);
        JButton ok=new JButton("确认");
        JButton cancle=new JButton("退出");
        JLabel title=new JLabel("窗口");
        JLabel name=new JLabel("用户名");
        JLabel password=new JLabel("密码");
        final JTextField nameinput=new JTextField(15);
        nameinput.setText("xupan");
        final JTextField passwordinput=new JTextField(15);
        passwordinput.setText("123");
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.EAST;
        constraints.weightx=3;
        constraints.weighty=4;
        //add(title,constraints,0,0,4,1);
        add(name,constraints,0,1,1,1);
        add(password,constraints,0,2,1,1);
        add(nameinput,constraints,2,1,1,1);
        add(passwordinput,constraints,2,2,1,1);
        add(ok,constraints,0,3,1,1);
        add(cancle,constraints,2,3,1,1);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[]args){
        gridbaglayout a=new gridbaglayout();
    }
}
