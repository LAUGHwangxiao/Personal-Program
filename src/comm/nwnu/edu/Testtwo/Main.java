package comm.nwnu.edu.Testtwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws IOException{
		// 读取要处理的文件
			BufferedReader b = new BufferedReader(new FileReader("src/HarryPotter.txt"));
	       //<单词:词频>
	    	Map<String, Integer> map = new TreeMap<String, Integer>();
	            String value= b.readLine();
	            while (value!= null) {
	            	//处理标点符号
	            	String[] words = value.split("[【】、.。,\"!--;:?\'\\] ]"); 
	            	for (int i = 0; i < words.length; i++) {
	            		//将大写字母转换为小写字母
	                      String key = words[i].toLowerCase();
	                		if (key.length() > 0) {
	                      		if (!map.containsKey(key)) {
	                          		map.put(key, 1);
	                          		} 
	                      		else { 
	                      			int k = map.get(key)+1;// 如果不是第一次出现，就把k值++
	                                map.put(key, k);
	                          		}
	                      		}
	                  		} 
	                value = b.readLine();
	            }
		  Method me=new Method();
		  System.out.println("Please choose the following method:");
		  System.out.println("method:one,给出单词，查询的单词频数，输出柱状图");
		  System.out.println("method:two,查询的排名前k的单词及个数");
		  System.out.println("method:three，统计该文本所有单词数量及词频数");
		  System.out.println("method:four,统计每一行单词的数量，并按序输出");
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
		  //用户从键盘输入高频词输出的个数k，运行程序统计功能，可按文本中词频数降序显示前k个单词的词频及单词
		  //me.ReCount();
		  
		  //统计该文本所有单词数量及词频数，并能将单词及词频数按字典顺序输出到文件result.txt。
		  //me.SortWords();
		  
          //用户可输入从该文本中想要查找词频的一个或任意多个英文单词，运行程序的统计功能可显示对应单词在文本中出现的次数和柱状图。
		  //me.selectWordCount();
     }
	}
}
