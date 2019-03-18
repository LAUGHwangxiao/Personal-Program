package JavaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordQuery {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true) {
        System.out.println("������Ҫ��ѯ��Ӣ�ĵ���,�����Ҫ����������ending");
        String wordin=sc.nextLine();
        if(wordin.equals("ending")){break;}
        else {
		Map<Integer,List<Word>> dic=readDictionary();
		Word word=findWord(wordin,dic);
		if(word==null) {
			System.out.println("û�����������������룡����");
		}
		else
		System.out.println(word);
		}
		}
		sc.close();
	}
	//��txt�����ֵ䲢�����ȷ���
	public static Map<Integer,List<Word>> readDictionary() throws IOException{
	    File file=new File("src/Harrypotter.txt");
    	List<Word> list=new ArrayList<Word>();
    	list=read(file);
    	Map<Integer,List<Word>> wordmap=dividMap(list);
    	return wordmap;
    }
	//��txt�����ֵ� 
	public static List<Word> read(File file) throws IOException{
		 List<Word> list=new ArrayList<Word>();
		 BufferedReader in=new BufferedReader(new FileReader(file));
		 String words;
		 while((words=in.readLine())!=null) {
			 //System.out.println(words);
			 String[] str=words.trim().split(" ");
			 Word wordObject=new Word(str[0],str[1],str[2]);
			 list.add(wordObject);
		 }
		 in.close();
		 return list;
	 }
	//�����ʳ��̽��з��飬������һ������������ʡ�ƴ���������ԡ�����
		public static Map<Integer,List<Word>> dividMap(List<Word> possibleWord){
			Map<Integer,List<Word>> wordmap=new TreeMap<Integer,List<Word>>();
			for(int i=0;i<possibleWord.size();i++) {
				Word wordObject =possibleWord.get(i);
				int len=wordObject.getWord().length();
				if(wordmap.get(len)==null) {
					List<Word> lset=new ArrayList<Word>();
					lset.add(wordObject);
					wordmap.put(len, lset);
				}
				else
				{
					List<Word> set=wordmap.get(len);
					set.add(wordObject);
				}
				
			}
			Map<Integer,List<Word>> words=new TreeMap<Integer,List<Word>>();
			for(Map.Entry<Integer, List<Word>> entry:wordmap.entrySet()) {
				Integer length=entry.getKey();
				List<Word> set=entry.getValue();
				List<Word> list=new ArrayList<Word>(set);
				words.put(length, list);
			}
			return words;
		}
		//�ڵ��ʿ���Ѱ�ҵ��ʶ���������
		public static Word findWord(String word,Map<Integer,List<Word>>dic) {
			Integer len=word.length();
			List<Word> list=dic.get(len);
			for(Word wordtemp:list) {
				if(word.equalsIgnoreCase(wordtemp.getWord())) {
					return wordtemp;
				}
			}
			return null;
		}
}
