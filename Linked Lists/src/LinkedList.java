
public class LinkedList {
	
	ListNode start;
	
	public LinkedList() {
		start = null;
	}
	
	public void add(Object val) {
		ListNode valNode = new ListNode(val, null);
		
		if(start == null) {
			start = valNode;
		} else {
			ListNode current = start;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(valNode);
		}
	}
	
	public String toString() {
		if(start == null)
			return "";
		
		String output = "";
		ListNode current = start;
		
		while(current.getNext() != null) {
			output += current.getVal().toString() + "\n";
			current = current.getNext();
		}
		output += current.getVal().toString() + "\n";
		
		return output;
	}
}
