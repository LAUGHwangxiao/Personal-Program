package comm.nwnu.edu.Testtwo;

public class Word {
	String value;                                  //具体的单词
	    int num;                                     //出现的个数
	    Word next;                                     //将单词链起来
	    public Word(String value,int geshu)            //带参构造函数
	     {
	         this.value=value;
	         this.num=geshu;
	         next=null;
	    }
	    public Word()                                   //空构造函数
	    {
	        this.value="";
	        this.num=0;
	        next=null;
	    }
}
