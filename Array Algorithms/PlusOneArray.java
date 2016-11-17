
import java.util.ArrayList; 
import java.util.List; 

public class PlusOneArray {

	public static List<Integer> plusOne(List<Integer> arrList) {
		int lastElemIndex = arrList.size() - 1;
		arrList.set(lastElemIndex, arrList.get(lastElemIndex) + 1);
		for (int i = lastElemIndex; i > 0 && arrList.get(i) == 10; --i) {
			arrList.set(i, 0);
			arrList.set(i - 1, arrList.get(i - 1) + 1);
		}
		if (arrList.get(0) == 10) {
			// Need additional digit as the most significant digit (i.e.,
			// A.get(0)) has a carry-out.
			arrList.set(0, 0);
			arrList.add(0, 1);
		}
		return arrList;
	} 
 
	public static void main(String[] args) {  
		List<Integer> arrList = new ArrayList<Integer> ();
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9); 
		System.out.println(arrList);
		List<Integer> result = plusOne(arrList);
		System.out.println(result);
	}
}
