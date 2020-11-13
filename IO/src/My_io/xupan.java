package My_io;



import java.io.*;

public class xupan {
	public static void main(String[] args) throws Exception{
		InputStream input = new FileInputStream(My_io.path + "\\hehe.txt");
		//OutputStream output = new FileOutputStream(My_io.path + "\\xumouren.txt");
		int len=0;
		byte[] buff = new byte[1024];
		len=input.read(buff);
		System.out.println(new String(buff, 0, len));

		BufferedReader ss = new BufferedReader(new InputStreamReader(new FileInputStream(My_io.path + "\\src\\各种流.txt")));
		BufferedWriter ww = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(My_io.path + "\\xumouren.txt")));
		while(true) {
			String ee=null;
			ee=ss.readLine();
			System.out.println(ee);
			if (ee.equals("made")) {
				break;
			}
		}
	}
}
