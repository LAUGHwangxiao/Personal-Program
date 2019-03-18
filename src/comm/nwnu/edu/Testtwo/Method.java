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
   
//1.�û�������Ӹ��ı�����Ҫ���Ҵ�Ƶ��һ����������Ӣ�ĵ��ʣ����г����ͳ�ƹ��ܿ���ʾ��Ӧ�������ı��г��ֵĴ�������״ͼ��
	static Scanner in = new Scanner(System.in);
	Map<String,Integer> Map = new LinkedHashMap<String, Integer>(); 
    //��ʾ��Ƶ����״ͼ
    public void Frequency(Map<String, Integer> map){
        System.out.println("��������Ҫ��ѯ�ĵ��� :");
        String string = in.nextLine();
        String[] word= string.split(" ");
        float sum;
        for(int i=0; i<word.length; i++) {
        	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        		if(word[i].equals(w.getKey()))
        		{  
        			System.out.println("����"+w.getKey() + "����" + w.getValue()+"��");
        			sum=(float)(w.getValue())/200; 
        			for(int j=0;j<sum;j++){
        				System.out.print("#"+"\n");
        			}
        			System.out.println(w.getKey());
        		}  
            } 
        }
    }
//2.�û��Ӽ��������Ƶ������ĸ���k�����г���ͳ�ƹ��ܣ��ɰ��ı��д�Ƶ��������ʾǰk�����ʵĴ�Ƶ������
    public void ReCount() throws IOException{
 	System.out.println("��������ߵ�ǰk������");
	    Scanner sc=new Scanner(System.in);
	    int k=sc.nextInt();
     Word word=new Word();                                      //���ʵ���ͷ
     Word lian,xin;                                             
     String str="";
     FileReader f=new FileReader("src/Harrypotter.txt");                //��ȡӢ���ļ�
     char[] c=new char[1];                                 //ÿ�ζ�ȡһ����ĸ
     int b=0;
     boolean exist=false;                              //�жϵ����Ƿ������  word ����
     while((b=f.read(c))!=-1)                              //ÿ�ζ�ȡһ����ĸֱ�����
     {
         //����ַ�Ϊ  ���С��ո񡢵����š�˫���š����š����  ��Ϊһ�����ʵĽ�������һ�����ʵĿ�ʼ||String.valueOf(c).equals("'")
         if(String.valueOf(c).equals("\r")||String.valueOf(c).equals("\n")||String.valueOf(c).equals(" ")||String.valueOf(c).equals(",")||String.valueOf(c).equals(".")||String.valueOf(c).equals("\""))
         {
             lian=word;
             while(lian!=null)            
             {
                 if(lian.value.equalsIgnoreCase(str))           //��������ڵ������д��ڣ��򵥴ʸ���++
                 {
                     lian.num++;exist=true;
                     break;
                 }
                 else
                 {
                     lian=lian.next;
                 }
             }
             if(exist==false)                        //��������ڣ����ڵ����������
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
         else                                      //����
         {
             str+=String.valueOf(c);
         }
     }
     //   ѭ��10��
     for(int i=1;i<=k;i++)                   
     {
         xin=new Word("",0);
         lian=word.next;
         //�ҵ��������и�������
         while(lian!=null)
         {
             if(lian.num>xin.num)
             {
                 xin=lian;
             }
             lian=lian.next;
         }
         //����������и�������
         System.out.println("��"+i+"�� :"+xin.value+"������"+xin.num);
         lian=word;
         //ɾ���������е��ʸ�������
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
       
       
//3.ͳ�Ƹ��ı����е�����������Ƶ�������ܽ����ʼ���Ƶ�����ֵ�˳��������ļ�result.txt��
       public void selectWordCount() throws IOException{
    		File file=new File("src/Harrypotter.txt");
  			if(!file.exists())
  			{
  				System.out.println("�ļ�������");
  				return;
  			}
  			Scanner scanner=new Scanner(file);
  			//���ʺ�����ӳ���
  			HashMap<String, Integer > hashMap=new HashMap<String,Integer>();
  			//System.out.println("����-----------------------------------");
  			while(scanner.hasNextLine())
  			{
  				String line=scanner.nextLine();
  				//System.out.println(line);
  				//\w+ : ƥ�����еĵ���
  				//\W+ : ƥ�����зǵ���
  				String[] lineWords=line.split("\\W+");//�÷ǵ��ʷ������ָ�ָ�����ľ���һ��������
  				
  				Set<String> wordSet=hashMap.keySet();
  				for(int i=0;i<lineWords.length;i++)
  				{
  					//����Ѿ�����������ˣ�
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
  			System.out.println("ͳ�Ƶ��ʣ�------------------------------");
  			Iterator<String> iterator=hashMap.keySet().iterator();
  			while(iterator.hasNext())
  			{
  				String word=iterator.next();
  				System.out.printf("����:%-12s ���ִ���:%d\n",word,hashMap.get(word));
  			}
        }
          
       
//4.ͳ��ÿһ�е��ʵ����������������
       public void SortWords() throws IOException{
    	    System.out.println("�������result.txt��");
        	BufferedReader bufferedReader=new BufferedReader(new FileReader("src/Harrypotter.txt"));
        	BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/result.txt"));
        	String s;
        	while((s=bufferedReader.readLine())!=null){
        		Map<String, Integer> map=new TreeMap<String,Integer>();
        		String[] words=s.split("[������.��,\"!--;:?\'\\] ]");
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
