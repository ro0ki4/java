package pan.xu;

public class KYHUDUANSUODING {
  public static void main(String[] args) {
  	bank bank1=new bank();
  	Thread thread1=new Thread(bank1,"thread_1");
  	Thread thread2=new Thread(bank1,"thread_2");
  	Thread thread3=new Thread(bank1,"thread3");
  	thread3.start();
  	thread1.start();
  	thread2.start();
  }
}

class bank implements Runnable{
	private static volatile person out=new custom(100);
	private static volatile person in=new custom(100);
	private static Object obj1=new Object();
	private  static Object obj2=new Object();
	@Override
	public void run() {
		transfer(out,in,10);
	}
	private synchronized void transfer(person out,person in,int money){
    //synchronized (obj1) {
      out.minux_money(money);
      in.add_money(money);
		//}
    //synchronized (obj2) {
      out.show_money();
      in.show_money();
      person.show_num(out, in);
		//}
	}
}


interface person{
	public abstract void show_money();
	void add_money(int a);
	void minux_money(int a);
	int get_money();
	public static void show_num(person a,person b){
		System.out.println(a.get_money()+b.get_money());
	}
}

class custom implements person{
	private int money;
	public custom(){};
	public custom(int money){
		this.money=money;
	}
	@Override
	public void show_money(){
		System.out.println("用户拥有"+this.money);
	}
	@Override
	public void add_money(int money){
		this.money+=money;
	}
	@Override
	public void minux_money(int money){
		this.money-=money;
	}
	@Override
	public int get_money(){
		return money;
	}
}