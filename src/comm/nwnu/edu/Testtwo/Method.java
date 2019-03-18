package comm.nwnu.edu.Testtwo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Method {
   
//1.用户可输入从该文本中想要查找词频的一个或任意多个英文单词，运行程序的统计功能可显示对应单词在文本中出现的次数和柱状图。
	static Scanner in = new Scanner(System.in);
	Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); 
    //显示词频和柱状图
    public void Frequency(Map<String, Integer> map){
        System.out.println("请输入需要查询的单词 :");
        String string = in.nextLine();
        String[] word= string.split(" ");
        float sum;
        for(int i=0; i<word.length; i++) {
        	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        		if(word[i].equals(w.getKey()))
        		{  
        			System.out.println("单词"+w.getKey() + "出现" + w.getValue()+"次");
        			sum=(float)(w.getValue())/200; 
        			for(int j=0;j<sum;j++){
        				System.out.print("#"+"\n");
        			}
        			System.out.println(w.getKey());
        		}  
            } 
        }
    }
//2.用户从键盘输入高频词输出的个数k，运行程序统计功能，可按文本中词频数降序显示前k个单词的词频及单词
    public void ReCount() throws IOException{
 	System.out.println("请输入最高的前k个单词");
	    Scanner sc=new Scanner(System.in);
	    int k=sc.nextInt();
     Word word=new Word();                                      //单词的链头
     Word lian,xin;                                             
     String str="";
     FileReader f=new FileReader("src/Harrypotter.txt");                //读取英文文件
     char[] c=new char[1];                                 //每次读取一个字母
     int b=0;
     boolean exist=false;                              //判断单词是否存在于  word 链中
     while((b=f.read(c))!=-1)                              //每次读取一个字母直到最后
     {
         //如果字符为  换行、空格、单引号、双引号、逗号、句号  则为一个单词的结束及另一个单词的开始||String.valueOf(c).equals("'")
         if(String.valueOf(c).equals("\r")||String.valueOf(c).equals("\n")||String.valueOf(c).equals(" ")||String.valueOf(c).equals(",")||String.valueOf(c).equals(".")||String.valueOf(c).equals("\""))
         {
             lian=word;
             while(lian!=null)            
             {
                 if(lian.value.equalsIgnoreCase(str))           //如果单词在单词链中存在，则单词个数++
                 {
                     lian.num++;exist=true;
                     break;
                 }
                 else
                 {
                     lian=lian.next;
                 }
             }
             if(exist==false)                        //如果不存在，则在单词链中添加
             {
                 xin=new Word(str,1);
                 xin.next=word.next;
                 word.next=xin;
                 str="";
             }
             else
             {
                 exist=false;
                 str="";
             }
         }
         else                                      //单词
         {
             str+=String.valueOf(c);
         }
     }
     //   循环10次
     for(int i=1;i<=k;i++)                   
     {
         xin=new Word("",0);
         lian=word.next;
         //找到单词链中个数最多的
         while(lian!=null)
         {
             if(lian.num>xin.num)
             {
                 xin=lian;
             }
             lian=lian.next;
         }
         //输出单词链中个数最多的
         System.out.println("第"+i+"个 :"+xin.value+"个数："+xin.num);
         lian=word;
         //删除单词链中单词个数最多的
         while(lian.next!=null)
         {
             if(lian.next.value.equalsIgnoreCase(xin.value))
             {
                 lian.next=lian.next.next;
                 break;
             }
             lian=lian.next;
         }
     }
 }   
       
       
//3.统计该文本所有单词数量及词频数，并能将单词及词频数按字典顺序输出到文件result.txt。
       public void selectWordCount() throws IOException{
    		File file=new File("src/Harrypotter.txt");
  			if(!file.exists())
  			{
  				System.out.println("文件不存在");
  				return;
  			}
  			Scanner scanner=new Scanner(file);
  			//单词和数量映射表
  			HashMap<String, Integer > hashMap=new HashMap<String,Integer>();
  			//System.out.println("文章-----------------------------------");
  			while(scanner.hasNextLine())
  			{
  				String line=scanner.nextLine();
  				//System.out.println(line);
  				//\w+ : 匹配所有的单词
  				//\W+ : 匹配所有非单词
  				String[] lineWords=line.split("\\W+");//用非单词符来做分割，分割出来的就是一个个单词
  				
  				Set<String> wordSet=hashMap.keySet();
  				for(int i=0;i<lineWords.length;i++)
  				{
  					//如果已经有这个单词了，
  					if(wordSet.contains(lineWords[i]))
  					{
  						Integer number=hashMap.get(lineWords[i]);
  						number++;
  						hashMap.put(lineWords[i], number);
  					}
  					else 
  					{
  						hashMap.put(lineWords[i], 1);
  					}
  				}
  				
  			}
  			System.out.println("统计单词：------------------------------");
  			Iterator<String> iterator=hashMap.keySet().iterator();
  			while(iterator.hasNext())
  			{
  				String word=iterator.next();
  				System.out.printf("单词:%-12s 出现次数:%d\n",word,hashMap.get(word));
  			}
        }
          
       
//4.统计每一行单词的数量，并按序输出
       public void SortWords() throws IOException{
    	    System.out.println("已输出到result.txt中");
        	BufferedReader bufferedReader=new BufferedReader(new FileReader("src/Harrypotter.txt"));
        	BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/result.txt"));
        	String s;
        	while((s=bufferedReader.readLine())!=null){
        		Map<String, Integer> map=new TreeMap<String,Integer>();
        		String[] words=s.split("[【】、.。,\"!--;:?\'\\] ]");
        		for(int i=0;i<words.length;i++){
        			String key=words[i].toLowerCase();
        			if(key.length()>0){
        				if(!map.containsKey(key)){
        					map.put(key, 1);
        				}else{
        					int value=map.get(key);
        					value++;
        					map.put(key, value);
        				}
        			}
        		}
        		Set<Map.Entry<String, Integer>> entrySet=map.entrySet();
        		for(Map.Entry<String, Integer> entery:entrySet){
        			bufferedWriter.write(entery.getKey()+"---"+entery.getValue()+"\r\n");
        		}
        		bufferedWriter.newLine();
        		}
        	bufferedReader.close();
        	bufferedWriter.close();
 }
   	    
}
