package comm.nwnu.edu.Testtwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException{
		// ��ȡҪ������ļ�
			BufferedReader b = new BufferedReader(new FileReader("src/HarryPotter.txt"));
	       //<����:��Ƶ>
	    	Map<String, Integer> map = new TreeMap<String, Integer>();
	            String value= b.readLine();
	            while (value!= null) {
	            	//���������
	            	String[] words = value.split("[������.��,\"!--;:?\'\\] ]"); 
	            	for (int i = 0; i < words.length; i++) {
	            		//����д��ĸת��ΪСд��ĸ
	                      String key = words[i].toLowerCase();
	                		if (key.length() > 0) {
	                      		if (!map.containsKey(key)) {
	                          		map.put(key, 1);
	                          		} 
	                      		else { 
	                      			int k = map.get(key)+1;// ������ǵ�һ�γ��֣��Ͱ�kֵ++
	                                map.put(key, k);
	                          		}
	                      		}
	                  		} 
	                value = b.readLine();
	            }
		  Method me=new Method();
		  System.out.println("Please choose the following method:");
		  System.out.println("method:one,�������ʣ���ѯ�ĵ���Ƶ���������״ͼ");
		  System.out.println("method:two,��ѯ������ǰk�ĵ��ʼ�����");
		  System.out.println("method:three��ͳ�Ƹ��ı����е�����������Ƶ��");
		  System.out.println("method:four,ͳ��ÿһ�е��ʵ����������������");
		  Scanner sc=new Scanner(System.in);
		  String method=sc.nextLine();
    while(method!=null){	  
		  switch (method) {
		case "one":
			  me.Frequency(map);
			break;
        case "two":
			  me.ReCount();
			break;
        case "three":
			  me.selectWordCount();
			break;
        case "four":
			me.SortWords();
			break;
		default:
			break;
		}
		  method=sc.nextLine();
		  //�û��Ӽ��������Ƶ������ĸ���k�����г���ͳ�ƹ��ܣ��ɰ��ı��д�Ƶ��������ʾǰk�����ʵĴ�Ƶ������
		  //me.ReCount();
		  
		  //ͳ�Ƹ��ı����е�����������Ƶ�������ܽ����ʼ���Ƶ�����ֵ�˳��������ļ�result.txt��
		  //me.SortWords();
		  
          //�û�������Ӹ��ı�����Ҫ���Ҵ�Ƶ��һ����������Ӣ�ĵ��ʣ����г����ͳ�ƹ��ܿ���ʾ��Ӧ�������ı��г��ֵĴ�������״ͼ��
		  //me.selectWordCount();
     }
	}
}
