package comm.nwnu.edu.Testtwo;

public class Word {
	String value;                                  //����ĵ���
	    int num;                                     //���ֵĸ���
	    Word next;                                     //������������
	    public Word(String value,int geshu)            //���ι��캯��
	     {
	         this.value=value;
	         this.num=geshu;
	         next=null;
	    }
	    public Word()                                   //�չ��캯��
	    {
	        this.value="";
	        this.num=0;
	        next=null;
	    }
}
