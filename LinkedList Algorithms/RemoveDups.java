import java.util.HashSet;

public class RemoveDups {
	static class Node {
		int data;
		Node next;
	}
	void deleteDups(Node n) {
		HashSet<Integer> set = new HashSet<>();
		Node prev = null;
		Node curr = n;
		while(curr != null) {
			if (!(set.contains(curr.data))) {
				set.add(curr.data);
				prev = curr;
			} else {
				prev.next = curr.next;
			} 
			curr = curr.next;
		}
	}
	
	void deleteDupsNoBuffer(Node n) {
		
		Node curr = n;
		
		while(curr != null) {
			Node runner = curr;
			
			while(runner.next != null) {
				if(curr.data == runner.next.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			curr = curr.next;
		}
	}
}
