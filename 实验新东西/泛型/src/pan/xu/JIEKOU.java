package pan.xu;

import java.nio.file.attribute.AclEntry;

public class JIEKOU {
  public static void main(String[] args) {
  	yi one=new yi(5);//
	  er two=new er(5);
	  System.out.println(two.equals(one));
  }
}

class yi{
	public int length;
	public yi(){};
	public yi(int length){
		this.length= length;
	}
}

class er extends yi{
	public er(){};
	public er(int length){
		super(length);
	}
	@Override
	public boolean equals(Object object){
		 yi object1=(yi)object;
		if(this.length==(object1.length))
			return true;
		else
			return false;
	}
}
