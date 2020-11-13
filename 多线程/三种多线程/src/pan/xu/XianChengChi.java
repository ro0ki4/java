package pan.xu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XianChengChi {
	public static final int thread_num=10;

	public static void main(String[] args) {
		XianChengChiguanli ee=new  XianChengChiguanli();
		/*
		String string;
		while(true) {

			Scanner scan = new Scanner(System.in);
			string = scan.nextLine();
			if(string.equals(""))
				break;
			else{
				System.out.println("ewfwfewwafeawf");
				ee.start_thread();
			}
		}*/
		for(int i=0;i<10;i++){
			ee.start_thread();
		}

	}
}
class XianChengChiguanli{
	private static final int num=XianChengChi.thread_num;//线程池最大线程数量
	private static int currentnum=0;//当前线程池中已激活线程的数量
	private static List<mythread> list;
	public XianChengChiguanli(){
		list=new ArrayList<>();

		for (int i = 0; i < num; i++) {

			mythread xu=new mythread(i+1);
			System.out.println(xu.getName()+"22222222222222222222");
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			list.add(xu);
			xu.start();
		}
	}
	public synchronized void start_thread(){
		if(currentnum>=num){
			System.out.println("线程池满了");
			return;
		}
		for(int i=0;i<num;i++){
			if (!(list.get(i).isrunning())) {
				list.get(i).set_running();//将该线程的状态设置为运行状态
				currentnum++;
				break;
			}
		}
	}

}

class mythread extends Thread{
	private int code;
	private boolean status=false;
	public mythread(int code){
		this.code=code;
		start();
	}
	@Override
	public synchronized void run() {
		System.out.println(status+""+code);
		while(true) {
			if (status) {
				setName("-----------线程" + code);
				System.out.println("线程" + getName() + "正在运行");
				break;
			} else {
				try {
					this.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public boolean isrunning(){
		return status;
	}
	public synchronized void set_running(){
		this.status=true;
		this.notify();
		System.out.println("已经Notify了");
	}
}