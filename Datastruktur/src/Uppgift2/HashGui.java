package Uppgift2;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * @author Henrik Klein
 */
public class HashGui {
	/**
	 * Klassen skapar en ny hashtable.
	 * Klassen använder två variabler, number och name.
	 * För att först skriva ut alla values som finns lagrade i table så skapar jag en ny linkedlist och tilldelar den
	 * värdet som table.getInsertionOrder hämtar till mig.
	 * Skapar en ny iterator som sedan går igenom hela table och printar ut de olika värdena i konsolen.
	 * 
	 * Sedan skapar jag en array med olika val som man kan göra.
	 * Skapar sedan en switch sats med de ovannämnda valen.
	 * Om man vill lägga till personer så tilldelas name och number värdet från JOptionPane.
	 * Sedan anropar put metoden i table som lägger till name och number.
	 * I case 1 så tilldelas name värdet fån JOptionPane sedan anropas table put metod som tilldelar värdet till number.
	 * I case 2 så tilldelas name värdet fån JOptionPane sedan anropas table remove metod som tar bort värdena name och number.
	 * I case 3 så kollar jag först om table.getInsertionOrder är lika med null så skrivs fel meddelande ut.
	 * Annars skriver jag ut alla values som finns lagrade.
	 * Case 4 avslutar programmet.
	 */

	public static void main (String [] args){
		HashTable table = new HashTable(50);
		Object number;
		Object name; 
		table.put("Åke", "0701213");
		table.put("Gustav", "0406666");
		table.put("Per", "0704323553");
		table.put("Göran", "08436323");
		table.put("Erik", "0703356245");
		
		LinkedList<Object> entrySet = table.getInsertionOrder();
		Iterator<Object> it = entrySet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());	
		}

		int quit = 0;
		String[] choices = {"Insert new", "Find phone number by name", 
				"Delete person", "Display all", "Quit"};
		while(quit != 1){
			int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Directory",
					 JOptionPane.DEFAULT_OPTION,
					 JOptionPane.QUESTION_MESSAGE,
					 null, choices, -1);
			switch(choice){
			case 0: 
				name = JOptionPane.showInputDialog("Please enter a name");
				number = JOptionPane.showInputDialog("Please enter a phone number");
				table.put(name, number);
				break;
			case 1:
				name = JOptionPane.showInputDialog("Please enter a name to find number");
				number = table.get(name);
				JOptionPane.showMessageDialog(null, 
						name + "number is " + number);
				break;
			case 2:
				name = JOptionPane.showInputDialog("Please enter a name to delete");
				number = table.get(name);
				table.remove(name);
				table.remove(number);
				JOptionPane.showMessageDialog(null, 
						"Deleted " + name + "number (" + number + ") from table");
				break;
			case 3:
				if (table.getInsertionOrder() == null){
					JOptionPane.showMessageDialog(null, 
							"There are no numbers yet");
				}
				else {JOptionPane.showMessageDialog(null, 
						table.getInsertionOrder());
				}
				break;
			case 4:
				quit = 1;
				break;
			}
		}
	}
}


