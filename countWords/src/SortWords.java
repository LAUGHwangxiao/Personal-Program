

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortWords {
	//4.统计每一行单词的数量，并按序输出
    public void SortWords() throws IOException{
 	    System.out.println("已输出到result2.txt中");
     	BufferedReader bufferedReader=new BufferedReader(new FileReader("src/Harrypotter.txt"));
     	BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/result2.txt"));
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
