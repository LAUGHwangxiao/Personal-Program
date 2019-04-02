

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// 读取文件
		String filename = "src/harrypotter.txt";
		FileReader fk = new FileReader(filename);
		BufferedReader br = new BufferedReader(fk);
		// 用列表存储过滤后单词
		List<String> ls = new ArrayList<String>();
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			// 过滤出只含有字母的
			String[] correctword = readLine.split("[^a-zA-Z]");
			for (String word : correctword) {
				// 去除长度为0的行
				if (word.length() != 0) {
					ls.add(word);
				}
			}
		}
		br.close();
		// 存储单词计数信息，key值为单词，value为单词数并对单词的词频统计
		Map<String, Integer> wordsCount = new TreeMap<String, Integer>();
		for (String li : ls) {
			if (wordsCount.get(li) != null) {
				wordsCount.put(li, wordsCount.get(li) + 1);
			} else {
				wordsCount.put(li, 1);
			}
		}
		// Map按键排序(sort by key)
		Map<String, Integer> resMap = sortMapByKey(wordsCount);
		for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		// 
		// for (Map.Entry<String, String> entry : resultMap.entrySet()) {
		// System.out.println(entry.getKey() + " " + entry.getValue()); }
		//
		//(Map<key,value>)
		File file = new File("result.txt");
		try {
			if (file.exists()) {
				file.createNewFile();
			}
			// 讲结果输出到绝对路劲下
			// FileWriter ff = new FileWriter(file.getAbsoluteFile());
			// 讲结果输出到src下
			FileWriter ff = new FileWriter(file.getCanonicalFile());
			for (Entry<String, Integer> entry : resMap.entrySet()) {
				ff.write(entry.getKey() + "/" + entry.getValue() + "    " + "\n");
			}
			ff.close();
			System.out.println("统计完成");
			// System.out.println(file.getAbsoluteFile());
			// System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("总单词数为：" + file.length());
		System.out.println("已经输出所有单词及词频到result.txt");
		System.out.println("选择以下你想了解的");
		System.out.println("1:请输入想要查询的单词词频:");
		System.out.println("2:输出词频最高的前N个单词:");
		System.out.println("3:统计每行的每个单词的数量:");
		System.out.println("4:统计该文本文档的行数:");
		int num = in.nextInt();
		while (num != 0) {
			switch (num) {
			case 1:
				long startTime1=System.currentTimeMillis();
				Find rs = new Find();
				rs.find(wordsCount);
				long endTime1=System.currentTimeMillis();
				double time1=(endTime1-startTime1)/1000;
				//long time1=endTime1-startTime1;
				System.out.println("功能1实现的运行的时间为："+time1+"秒");
				break;
			case 2: 
				long startTime2=System.currentTimeMillis();
				Valuesort vs = new Valuesort();
				vs.valuesort(wordsCount);
				long endTime2=System.currentTimeMillis();
				long time2=endTime2-startTime2;
				System.out.println("功能2实现的运行的时间为："+time2+"毫秒");
				break;
			case 3: 
				//实现统计每一行的单词数量
				long startTime3=System.currentTimeMillis();
				SortWords sortword=new SortWords();
				sortword.SortWords();
				long endTime3=System.currentTimeMillis();
				long time3=endTime3-startTime3;
				System.out.println("功能3实现的运行的时间为："+time3+"毫秒");
				break;
			case 4: 
				//实现统计文本文档的行数
				long startTime4=System.currentTimeMillis();
				//EnterCount ec=new EnterCount();
				//ec.
				EnterCount entercount=new EnterCount();
				entercount.enterCount();
				long endTime4=System.currentTimeMillis();
				long time4=endTime4-startTime4;
				System.out.println("功能4实现的运行的时间为："+time4+"毫秒");
				break;
			}
			System.out.println("再次选择想要了解的：");
			num = in.nextInt();
			if (num > 2) {
				System.out.println("请输入正确问题序号");
			}
		}

	}

	// 让 Map按key进行排序
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;

	}
	private void sort(Map<String, Integer> map, int i) {
	}

}
//实现一个比较器类

class MapKeyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2); // 从小到大排序
		//将排序好的单词及对应的词频放到文件中    
}		
}