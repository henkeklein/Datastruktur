package Uppgift1;

/**
 * @author Henrik Klein
 */
public class TestStack {
	
	private static boolean NDEBUG = true;
	
	public static void main(String[] args) {		
		int myObject1 = 1;
		String myObject2 = "myObject2";
		String myObject3 = "myObject3";
		
		Stack myStack = new Stack();
		assertTest(myStack.Count() == 0, "Not correct number of Nodes");
		assertTest(myStack.Peek() == null, "Peek is not correct");
		myStack.Push(myObject1);
		myStack.Push(myObject2);
		assertTest(myStack.Count() == 2, "Not correct number of Nodes");
		myStack.Push(myObject3);
		assertTest(myStack.Peek() == myObject3, "Peek is not correct");
		assertTest(myStack.Count() == 3, "Not correct number of Nodes");
				
		assertTest(myStack.Pop() == myObject3, "Pop is not correct");
		assertTest(myStack.Peek() == myObject2, "Stack is not correct");
		
		myStack.Pop();	
		String myObject4 = "myObject4";
		myStack.Push(myObject4);
		assertTest(myStack.Peek() == myObject4, "Peek is not correct");

		myStack.Pop();
		assertTest((int)myStack.Pop() == 1, "Pop is not correct");
		myStack.Pop();
		myStack.Pop();
		assertTest(myStack.Pop() == null, "Pop is not correct");
		
		System.out.println("All code is working");
	}

   private static void printStack(String why) {
	   Throwable t = new Throwable(why);
	   t.printStackTrace();
	   System.exit(1);
   }

   public static void assertTest(boolean expression, String why) {
	   if (NDEBUG && !expression) {
		   printStack(why);
	   }
   }
}
