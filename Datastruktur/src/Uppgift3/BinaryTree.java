package Uppgift3;

public class BinaryTree {

	private static TreeNode root;
	private int size;
	
	public BinaryTree(){
		this.root = null;
	}
	
	public void add (int data) {
		TreeNode newNode = new TreeNode(data);
		if (root ==  null){
			root = newNode;
		}
		else {
			root = insert(root, newNode);
		}
		
	}
	
	public TreeNode insert(TreeNode current, TreeNode newNode){
		
		if (current == null) {
			current = newNode;
			return current;
		}

		else if (current.getData() > newNode.getData()) {
			if (current.getLeft() == null) {
				current.setLeft(new TreeNode(newNode.getData()));
			} else {
				insert(current.getLeft(), newNode);
			}
		}

		else if (current.getData() < newNode.getData()) {
			if (current.getRight() == null) {
				current.setRight(new TreeNode(newNode.getData()));
			} else {
				insert(current.getRight(), newNode);
			}
		}

		else if (current.getData() == newNode.getData()) {
			try {
				throw new Exception();
			} catch (Exception e) {
			}
		}

		return current;
 				
	}
	
	public void delete (int data){
		root = remove (root, data);
	}
	
	public TreeNode remove (TreeNode node, int value){
		if (node == null) {
            return node;
        }
        if (node.getData() == value) {

            if ((node.getLeft() == null) && (node.getRight() == null)) {
                node = null;
                return node;
            }

            else if ((node.getLeft() != null) && (node.getRight() == null)) {
                TreeNode left = node.getLeft();
                node.setData(left.getData());
                node.setRight(left.getRight());
                node.setLeft(left.getLeft());;
            }
            else if (node.getRight() != null && node.getLeft() == null) {
                TreeNode right = node.getRight();
                node.setData(right.getData());
                node.setRight(right.getRight());
                node.setLeft(right.getLeft());
            }
            else {
                TreeNode success  = findSuccessor(node);
                node.setData(success.getData());
                
                if (node.getRight() == success){
                	node.setRight(success.getRight());
                } else {
                	deleteSuccessor(node.getRight(), success, null);
                }
            }
        } 
        if (value < node.getData()){
        	node.setLeft(remove(node.getLeft(), value));
        }
        else if (value > node.getData()){
        	node.setRight(remove(node.getRight(), value));
        }
        return node;
    }
	
	private TreeNode findSuccessor (TreeNode current){
		TreeNode node = current.getRight();
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
	
	private TreeNode deleteSuccessor(TreeNode node, TreeNode success, TreeNode parent){
		if (success == null){
			parent.setLeft(null);
		}
		else if (success.getData() < node.getData()){
			deleteSuccessor(node.getLeft(), success, parent);
		}
		else if (success.getData() > node.getData()){
			deleteSuccessor(node.getRight(), success, parent);
		}
		return parent;
	}
	
	private void inOrder(TreeNode current){
		
	}
	
	public TreeNode find(TreeNode node, int data){
		int current = node.getData(); 
		if (node.getData() == data){
			System.out.println(data);
		}
		if (current > data){
			find(node.getLeft(), data);
		}
		else if (current < data){
			find(node.getRight(), data);
		}
		return node;
	}
	
	public void print (){
		root.printTree();
	}
	
	public static void main (String [] args){
		BinaryTree tree = new BinaryTree();
		tree.add(7);
		tree.add(3);
		tree.add(1);
		tree.add(5);
		tree.add(0);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(11);
		tree.add(9);
		tree.add(13);
		tree.add(8);
		tree.add(10);
		tree.add(12);
		tree.add(14);
		tree.print();
		tree.delete(7);
		System.out.println("-----------------------------");
		tree.print();
		System.out.println("-----------------------------");
		tree.find(root, 0);
	}

}
