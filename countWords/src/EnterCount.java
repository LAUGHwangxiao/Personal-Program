

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class EnterCount {
	public void enterCount() throws IOException{
    {
        File file = new File("src/Harrypotter.txt");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        
        String line;
        
        // Initializing counters
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int paragraphCount = 1;
        int whitespaceCount = 0;
        
        try{
    		if(file.exists()){
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
    		    int lineNum = 0;
    	            while (lnr.readLine() != null){
    	            lineNum++;
    	            }
    	            System.out.println("该文本文档的总行数为 : " + lineNum);
    	            lnr.close();
    		}else{
    			 System.out.println("File does not exists!");
    		}
    	}catch(IOException e){
    		e.printStackTrace();
    	}

        
        
        // Reading line by line from the 
        // file until a null is returned
        while((line = reader.readLine()) != null)
        {
            if(line.equals(""))
            {
                paragraphCount++;
            }
            if(!(line.equals("")))
            {
                
                characterCount += line.length();
                
                // \s+ is the space delimiter in java
                String[] wordList = line.split("/s+");
                
                countWord += wordList.length;
                whitespaceCount += countWord -1;
                
                // [!?.:]+ is the sentence delimiter in java
                String[] sentenceList = line.split("[!?.:]+");
                
                sentenceCount += sentenceList.length;
            }
            
        }
             
        //System.out.println("单词的总数量为= " + countWord);
       // System.out.println("句子的总数量为= " + sentenceCount);
        System.out.println("字符的总数量为 " + characterCount);
        //System.out.println("段落的总数量为 = " + paragraphCount);
        //System.out.println("空格的数量为 = " + whitespaceCount);
    }
}
}
