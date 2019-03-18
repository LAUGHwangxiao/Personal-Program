package JavaTest;

public class Word {
	//µ¥´Ê µ¥´ÊÆ´¶Á µ¥´ÊÊôÐÔ
		private String word;
		private String spell;
		private String properties;
		public Word(String wordin,String spellin,String propertiesin){
			word=wordin;
			spell=spellin;
			properties=propertiesin;
		}
		public String toString() {
			return (word+"  "+spell+"  "+properties);
		}
		public String getWord() {
			return word;
		}
		public String getWordSpell() {
			return spell;
		}
		public String getWordProperties() {
			return properties;
		}
		public String addProperties(String proper) {
			StringBuffer buffer=new StringBuffer(properties);
			buffer.append(proper);
			properties=new String(buffer);
			return properties;
		}
}
