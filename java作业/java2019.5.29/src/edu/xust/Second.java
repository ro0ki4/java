package edu.xust;

import java.io.*;

public class Second {
	static String path = System.getProperty("user.dir");
	public static void main(String[] args) throws Exception{
		InputStream input = new FileInputStream(path + "\\1.txt");
		byte[] data = new byte[1024];
		input.read(data);
		System.out.println(new String(data));
		FileReader input1 = new FileReader(path + "\\1.txt");
		char[] shuju = new char[100];
		input1.read(shuju);
		System.out.println(shuju);
		input.close();
		input1.close();
		OutputStream output = new FileOutputStream(path + "\\1.txt");
		String string="e";
		output.write(string.getBytes());
		output.close();
		FileWriter output1 = new FileWriter(path + "\\1.txt");
		output1.write(string);
		output1.close();
	}
}
