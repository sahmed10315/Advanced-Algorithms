import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionIntoAnagrams {

 	public static ArrayList<String> partitionIntoAnagrams(String[] str) {
 		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

 		for(String s : str) {
 			char[] word = s.toCharArray();
 			Arrays.sort(word);
 			if(hashMap.containsKey(new String(word)) == true) {
 				ArrayList<String> anagramList = hashMap.get(new String(word));
 				anagramList.add(s);
 			} else {
 				ArrayList<String> sInList = new ArrayList<String>();
 				sInList.add(s);
 				hashMap.put((new String(word)), sInList);
 			}
 		}

 		ArrayList<String> outputList = new ArrayList<String>();
 		for(Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet() ) {
 			String key = entry.getKey();
 			ArrayList<String> val = entry.getValue();
 			outputList.addAll(val);
 		}
 		return outputList;

 	}
}
