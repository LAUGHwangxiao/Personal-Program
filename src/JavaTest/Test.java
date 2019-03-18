package JavaTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) throws IOException{
	BufferedReader bufferedReader=new BufferedReader(new FileReader("C:/text.txt"));
	BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("C:/result.txt"));
	
	String s;
	while((s=bufferedReader.readLine())!=null){
		Map<String, Integer> map=new TreeMap<String,Integer>();
		String[] words=s.split("[°æ°ø°¢.°£,\"!--;:?\'\\] ]");
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
		Comparator<Map.Entry<String, Integer>> valueComparator=new Comparator<Map.Entry<String,Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) { 
        		return o1.getKey().compareTo(o2.getKey());
       		}
        }; 
            List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list,valueComparator);
            System.out.println("-----------∞¥◊÷µ‰À≥–Ú≈≈–Ú»Áœ¬--------------");
            for(Map.Entry<String, Integer> entry:list){
            	System.out.println(entry.getKey()+"-------"+entry.getValue());
            	bufferedWriter.write(entry.getKey()+"-------"+entry.getValue()+"\r\n");
            }
		}
	bufferedWriter.newLine();
	bufferedReader.close();
	bufferedWriter.close();
		}
	}
	


