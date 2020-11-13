package My_io;

/**
 * 多线程下的客户端和服务端的交互
 * inputstreamreader和outputstreamwriter是用来转换字节流和字符流的。
 * bufferedreader(new outputstreamreader(s.getinputstream()))
 * 层次分别是字节流--字节字符转换流--缓冲流--打印流
 * 比如fileinputstream--inputstreamreader--bufferedreader
 *
 * fileoutputstream--outputstreamwriter--bufferedwriter--printwriter
 * 缓冲流还有字节流
 * bufferedinputstream    bufferedoutputstream
 */

import java.io.*;

public class My_io {
	static String path = System.getProperty("user.dir");
	public static void main(String[] args) throws Exception{
		System.out.println(System.getProperty("user.dir"));
		/*
		OutputStream xumouren=new FileOutputStream(path+"\\hehe.txt",true);
		String str="徐攀";
		xumouren.write(str.getBytes());
		xumouren.close();
		 */
		InputStream input = new FileInputStream(path + "\\hehe.txt");
		byte[]data=new byte[100];
		input.read(data);
		System.out.println(new String(data,0,100));
	}
}


