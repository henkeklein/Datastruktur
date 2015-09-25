package Uppgift1;

/**
 * @author Henrik Klein
 */
public class Stack {
	
	private ListNode firstNode = null;
	private int size = 0;
	
	/**
	 * returnerar stackens storlek.
	 */
	public int Count() {
		return size;
	}
	/**
	 * Har ett Objekt som parameter.
	 * Om firstNode är tom så skapas en ny ListNode med objektet och lägger det i stacken.
	 * Om där redan finns ett element i stacken så läggs det nya elementet ovanpå det gammla och newNode tilldelar dess data till firstNode.
	 * Sedan ökar storleken i stacken med 1.
	 */
	public void Push(Object obj) {
		if (firstNode == null) {
			firstNode = new ListNode(obj, null);
		} else {
			ListNode newNode = new ListNode(obj, firstNode);
			firstNode = newNode;
			
		}
		size++;
	}
	/**
	 * Kollar om firstNode = null så är stacken tom och null ska returneras.
	 * Annars skapas en temporär ListNode och firstNodes getNext hämtar det översta elementet i stacken och tilldelar till firstNode.
	 * Storleken minskar med 1 för vaje gång man använder Pop.
	 * Sedan returneras den temporära ListNode med dess data.
	 */
	public Object Pop() {
		if (firstNode == null){
			return null;
		} else{
			ListNode temp = firstNode;
			firstNode = firstNode.getNext();
			size--;
			return temp.getData();
		}
		
	}
	/**
	 * Kollar om firstNode = null så är stacken tom och null ska returneras.
	 * Annars ska firstNodes data returneras.
	 * Detta för att titta om stacken är tom eller inte.
	 */
	public Object Peek(){
		if (firstNode == null){
			return null;
		} else {
			return firstNode.getData();
		}
	}
	/**
	 * Kollar om storleken är 0 så returneras true annars returneras false.
	 * Detta för att kolla om där finns något i stacken eller ej.
	 */
	public boolean isEmpty() {
		if (size == 0){
			return true;
		} else {
			return false;
		}
	}

}
