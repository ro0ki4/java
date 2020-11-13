package pan.xu;
import java.sql.*;
import java.util.Properties;
public class JdbcTest {

    public static void main(String[] args) throws SQLException  {

        //连接数据库的URL
        String url = "http://localhost:801/phpmyadmin/db_structure.php?db=mysql";
        String user = "xupan";  //数据库用户名
        String password = "xupanshuai";  //密码
        //创建一个驱动程序的类对象
        Driver driver = new com.mysql.jdbc.Driver();  //新版本，推荐使用
        //Driver driver = new org.gjt.mm.mysql.Driver();  //旧版本，使用该类连接也是可行的


        //设置用户名和密码
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        //连接数据库
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);

    }

}