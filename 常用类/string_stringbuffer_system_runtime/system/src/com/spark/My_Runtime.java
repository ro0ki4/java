package com.spark;

import java.io.IOException;

public class My_Runtime {
  public static void main(String[] args) {
	  Runtime xupan=Runtime.getRuntime();//
	  try {
		  xupan.exec("notepad.exe");//相当于打开一个dos窗口的命令。
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
  }
}
