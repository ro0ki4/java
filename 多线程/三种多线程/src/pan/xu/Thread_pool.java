package pan.xu;
/**
 * 要创建一个线程池
 * 线程池的作用是里面存在一定的数量的线程，里面的线程都处在等待（wait）的状态。
 * 如果有需求，则唤醒一个线程。notify（）；
 * 当然，在判断用户事件时，通过调用某个方法来调用notify（）方法。
 * 线程的动态调整
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Thread_pool {
	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(
					new InputStreamReader(System.in)
			);
			String s;
			Thread_pool_manage manage=new Thread_pool_manage(10);
			while((s=br.readLine())!=null){
				manage.process(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Thread_pool_manage{
	private int threadnum;
	public ArrayList<Simple_Thread> list;
	public Thread_pool_manage(int threadnum){
		this.threadnum=threadnum;
		System.out.println("开始初始化");
		list=new ArrayList<>();
		for(int i=0;i<threadnum;i++){
			Simple_Thread thread=new Simple_Thread(i);
			list.add(thread);
			thread.start();
		}
	}
	public void process(String arg){
		int i;
		for(i=0;i<threadnum;i++){
			Simple_Thread currentthread=list.get(i);
			if(!currentthread.isrunning()){
				System.out.println("thread" + (i + 1) + "is processing");
				currentthread.setArg(arg);
				currentthread.setrunning(true);
				return;
			}
		}
	}
}

class Simple_Thread extends Thread {
	private boolean flag;
	private String arg;
	public boolean isrunning(){
		return flag;
	}
	public synchronized void setrunning(boolean flag){
		this.flag=flag;
		if(flag){
			this.notify();//将该线程唤醒
		}
	}
	public String getarg(){
		return this.arg;
	}
	public void setArg(String arg){
		this.arg = arg;
	}

	public Simple_Thread(int i) {
		flag=false;
		System.out.println("thread" + Thread.currentThread().getName() + "开始了");
	}
	@Override
	public synchronized void run(){
		try{
			while(true){
				if(!flag){
					this.wait();
				}
				else{
					System.out.println("processing" + getarg() + "...done");
					//sleep(5000);
					System.out.println("thread is running");
					break;
					//setrunning(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}