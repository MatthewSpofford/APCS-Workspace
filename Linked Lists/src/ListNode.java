
public class ListNode {
	
	private Object val;
	private ListNode next;
	
	public ListNode(Object val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	public Object getVal() {
		return val;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}
	
	public void setNext(ListNode val) {
		this.next = val;
	}
}
