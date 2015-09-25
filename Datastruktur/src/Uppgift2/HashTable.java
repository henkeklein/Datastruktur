package Uppgift2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Henrik Klein
 *
 */
public class HashTable {
/**
 * Två instansvariabler, insertionOrder och table.
 */
	private LinkedList<Object> insertionOrder = new LinkedList<Object>();
	private LinkedList<Entry>[] table;
	/**
	 * Konstruktor med en parameter.
	 * Deklarerar en temporär länkad lista med storleken pch tilldelar den till table.
	 * Sedan initieras alla elementen i vektorn.
	 * @param size som är HashTables storlek.
	 */
	public HashTable(int size){
		table = (LinkedList<Entry>[]) new LinkedList<?>[size];
		for (int i = 0; i < size; i++){
			table[i] = new LinkedList<Entry>();
	}
	
	}
	/**
	 * Beräknar objektets värde.
	 * Sedan kontrolleras värdet så det inte går utanför vektorns storlek.
	 * @param Objektet key.
	 * @return Det positiva värdet.
	 */
	
	private int hashIndex(Object key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}
	
	/**
	 * hashIndex metoden tilldelar det nya hashIndex dess värde.
	 * Räknar ut nyckelns index med hashIndex metoden.
	 * Skapar en ny länkad lista av typen Entry.
	 * Skapar en ny Iterator av typen Entry.
	 * Loopar sedan igenom listan, om entry är lika med key så returneras värdet.
	 * @param Objekt key som är nyckeln.
	 * @return Objektets värde.
	 */
	public Object get(Object key){
		int hashIndex = hashIndex(key); //Räkna ut nyckels index
		LinkedList<Entry> entries = table[hashIndex];
		Iterator<Entry> it = entries.listIterator();// Hitta nyckeln genom att loopa eller iterera igenom er tabell
		// Nedanstående visar iteration
		while(it.hasNext()){
			Entry entry = it.next();
			if (entry.equals(key)){
				return entry.getValue(); //<----returnera värdet
			}
		}	
		return null;
	}
/**
 * hashIndex metoden tilldelar det nya hashIndex dess värde.
 * Anropar metoden get och skickar in parametern key.
 * Om den är lika med null så skapar jag en ny entry.
 * Lägger till entry som key i table.
 * Lägger till value i den länkade listan insertionOrder. 
 * @param Objekt key och objekt value som ska sparas i table.
 */
	
	public void put(Object key, Object value){
		int hashIndex = hashIndex(key);
		if(get(key) == null){
			Entry entry = new Entry(key, value);
			table[hashIndex(key)].add(entry);
			insertionOrder.add(value);
		} 
	}
/**
 * hashIndex metoden tilldelar det nya hashIndex dess värde.
 * Skapar en ny länkad lista av typen Entry.
 * Skapar en ny Iterator av typen Entry.
 * Medans där finns fler element så returneras nästa element om e är lika key så anropas remove med Entry e value.
 * @param Objekt key som ska tas bort från table.
 */
	public void remove (Object key){
		int hashIndex = hashIndex(key);
		LinkedList<Entry> entry = table[hashIndex];
		Iterator<Entry> iter = entry.listIterator();
		
		while (iter.hasNext()){
			Entry e = iter.next();
			if(e.equals(key)){
				insertionOrder.remove(e.getValue());
				iter.remove();
			}
			
		}
}
	
	/**
	 * @return Den länkade listans storlek.
	 */
	public int count(){
		return insertionOrder.size();
	}
	/**
	 * @return Den länkade listan insertionOrder.
	 */
	public LinkedList<Object> getInsertionOrder(){
		return insertionOrder;
		
	}
}
