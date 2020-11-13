package com.xustedu;

public class HANNUOTA {
	static int num=0;
  public static void main(String[] args) {
  	char A='A',B='B',C='C';
	int n=3;
	function(A,B,C,n);  
  	//int[][]queen=new int[8][8];
  	//function(A,B,C,n);
	//eight_queen(queen,0);
  }

  static void function(char a, char b, char c, int n) {//将a上的n个通过b移动到c

    if(n==1){
    	System.out.println(a+"第一个移动到"+c);
    	return;
    }
    else{
		function(a,c,b,n-1);
		function(a,b,c,1);
    	//System.out.println(a+"第一个移动到"+c);
    	function(b,a,c,n-1);
    }
  }

  static void eight_queen(int[][]queen,int m){
  	if(m>=8){
  		num++;
	    show(queen);
	    System.out.println("---------------"+num);
  		return;
    }
  	else{
  		for(int i=0;i<queen[m].length;i++){
  			if(_judge(m,i,queen)){
  				queen[m][i]=1;
  				eight_queen(queen,m+1);
  				queen[m][i]=0;
		    }
	    }
    }
  }
  static void show(int[][]a){
  	for(int i=0;i<a.length;i++){
  		for(int j=0;j<a[i].length;j++){
  			System.out.print(a[i][j]+" ");
	    }
  		System.out.println();
    }
  }
  static boolean _judge(int i,int j,int[][]queen){
  	for(int ii=0;ii<queen.length;ii++){
  		for(int jj=0;jj<queen[ii].length;jj++){
  			if(((ii-i)==(jj-j)||(ii-i)==(j-jj))&&(queen[ii][jj]==1))
  				return false;
  			else if((ii==i||jj==j)&&queen[ii][jj]==1)
  				return false;
	    }
    }
  	return true;
  }
}
