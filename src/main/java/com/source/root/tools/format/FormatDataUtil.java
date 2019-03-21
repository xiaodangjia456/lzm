package com.source.root.tools.format;

public class FormatDataUtil {

	public String arryToSting(String[] pramas) {
		String result = "";
		for (int i = 0; i < pramas.length; i++) {
			result = result + "," + pramas[i];
		}
		return result.substring(1, result.length());
	}
	
	public static String replaceString(String pramas){
		if(pramas!=null && !"".equals(pramas)){
			if(pramas.contains("[")){
				pramas = pramas.replace("[", "【");
			}
			if(pramas.contains("]")){
				pramas = pramas.replace("]", "】");
			}if(pramas.contains(":")){
				pramas = pramas.replace(":", "：");
			}if(pramas.contains("\"")){
				pramas = pramas.replace("\"", "‘");
			}if(pramas.contains("{")){
				pramas = pramas.replace("{", "");
			}if(pramas.contains("}")){
				pramas = pramas.replace("}", "");
			}if(pramas.contains(",")){
				pramas = pramas.replace(",", "，");
			}if(pramas.contains(".")){
				pramas = pramas.replace(".", "");
			}if(pramas.contains(" ")){
				pramas = pramas.replace(" ", "");
				pramas = pramas.trim();
			}if(pramas.contains(" ")){
				pramas = pramas.replace(" ", "");
				pramas = pramas.trim();
			}if(pramas.contains("\n")){
				pramas = pramas.replace("\n", "");
			}if(pramas.contains("'")){
				pramas = pramas.replace("'", "");
			}if(pramas.contains("\r")){
				pramas = pramas.replace("\r", "");
			}if(pramas.contains("\t")){
				pramas = pramas.replace("\t", "");
			}if(pramas.contains("\r\n")){
				pramas = pramas.replace("\r\n", "");
			}
			pramas = pramas.trim();
		}
		return pramas;
	}
	
	public static void main(String[] args){
		System.out.println(replaceString("爸爸讲成语“鹬蚌相争”时，说：“蚌把强的嘴夹上以后，蚌说我今天不松嘴，明天不松嘴。太阳就会把你晒死的！” 6岁的孩子听到这里．问爸爸；“蚌说话是不用嘴的吗？”		"));
	}

}
