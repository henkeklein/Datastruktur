package Uppgift1;
import javax.swing.JOptionPane;

/**
 * @author Henrik Klein
 */
public class Parenthesis {

	private static String message;
	private static Stack stack;
	/**
	 * Skickar med en String parameter.
	 * Sapar en ny stack.
	 * Sedan går den igenom för varje tecken i strängen och tilldelar det till mark.
	 * Sedan görs en koll om där finns tecken "[, (, {" så pushas dessa till stacken.
	 * Om mark = "], }, )" och om stacken är tom så kollar den om tecknena matchar varandra och sedan används Pop.
	 * Annars om de inte matchar varandra så returneras att de inte är balanserade.
	 * Samma sak gäller för om där bara finns "], }, )" i text strängen så returneras att de inte är balanserade.
	 * Och om stacken är tom efter denna kod så vet vi att parenteserna är balanserade.
	 * Om de inte är balanserade så returneas "icke balanserade parenteser".
	 */
	public static String  checkParenthesis(String str) {
		stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			char mark = str.charAt(i);
			if (mark == '[' || mark == '(' || mark == '{') {
				stack.Push(mark);
			} else if ((mark == ']' || mark == '}' || mark == ')')
					&& (!stack.isEmpty())) {
				if (((char) stack.Peek() == '(' && mark == ')') || ((char) stack.Peek() == '{' && mark == '}') || ((char) stack.Peek() == '[' && mark == ']')) {
					stack.Pop();
				} else {
					return "Icke balanderade parenteser";
				}
			} else {
				if ((mark == ']' || mark == '}' || mark == ')')) {
					return "Icke balanserade parenteser";
				}
			}
		}
		if (stack.isEmpty())
			return "Balanserade parenteser";
		else
			return "Icke balanserade parenteser";
	}
	
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog(message);
		if (str.isEmpty()) {
			System.out.println("Empty String");
			return;
		}
		JOptionPane.showMessageDialog(null,Parenthesis.checkParenthesis(str));
		System.out.println(str);
	}
}
