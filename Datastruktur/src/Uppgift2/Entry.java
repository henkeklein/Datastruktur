package Uppgift2;
/**
 * 
 * @author Henrik Klein
 *
 */
public class Entry {

	private Object key;
	private Object value;
	/**
	 * Tilldelar värdet som entry får till key och value.
	 * @param key och value.
	 */
	public Entry (Object key, Object value){
		this.key = key;
		this.value = value;
	}
	/**
	 * 
	 * @return Objektet som ska returneras.
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * 
	 * @return Objektet som ska returneras.
	 */
	public Object getKey(){
		return key;
	}

	/**
	 * Jämför två nycklar med varandra.
	 * @param Objektet som ska jämföras.
	 */
	public boolean equals(Object obj) {
		Entry keyToCompare = new Entry(obj, null);
		return key.equals(keyToCompare.key);
	}

}
