package Uppgift1;
/**
 * @author Henrik Klein
 */
public class ListNode {

	private Object data;
	private ListNode next;
	/**
	 * Konstruktor med två parametrar (dataValue, nextNode).
	 * Tilldelar dataValue till data och nextNode till next.
	 */
	public ListNode(Object dataValue, ListNode nextNode){
		this.data = dataValue;
		this.next = nextNode;
	}
	/**
	 * Returnerar objektets data.
	 */
	public Object getData(){
		return data;
	}
	/**
	 * Returneras ListNode.
	 */
	public ListNode getNext(){
		return next;
	}

}
