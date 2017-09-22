package problem1;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
public class MyBST {
	/** The tree root. */
	private BinaryNode root;

	public MyBST() {
		root = null;
	}
	public void preOrder(){
			preOrder(root);
		}
	private void preOrder(BinaryNode t)
	{
		if( t != null ){
		  System.out.print(t.element+",");
		  preOrder( t.left );		
		  preOrder( t.right );
		} 		
	}
		
	public void postOrder()
	{
		postOrder(root);
	}
	
	private void postOrder(BinaryNode t)
	{ 
		if( t != null ){
			if( t.left != null ){
			postOrder( t.left );
			}	
			if( t.right != null ){
			postOrder( t.right );
			}
			System.out.print(t.element+",");
			} 		
	}
		public boolean contains(Integer key)
		{
			if(root==null)
			{
				return false;
			}
			
			BinaryNode n=root;
			boolean exitLoop=true;
			while(exitLoop){
			if(n.element.compareTo(key)>0)//go and check the left side
				{
					if(n.left==null)//If there is no element in the left side, key not found!
					{
						exitLoop=false;
						return false;
					}

					n=n.left;
				}
				else if(n.element.compareTo(key)<0)//go and check the right side
				{
					if(n.right==null)//If there is no element in the right side, key not found!
					{
						exitLoop=false;
						return false;
					}

					n=n.right;
				}
				else//key found
				{
					exitLoop=false;
					return true;
				}
			}
			return false;
		}
		public Integer getRoot()
		{
			return this.root.element;
		}
		public Integer leafNodes()
		{
			return leafNodes(root);
		}
		 private int leafNodes(BinaryNode t)
		 {
			 int count=0;
			 if(t==null)
			 {
				 return 0;
			 }
			if(t.left==null && t.right==null)
			{
				System.out.println(t.element+ ", ");
				return 1;
			}
			
			return leafNodes(t.left) + leafNodes(t.right);
		 }
		 public int size()
		 {
			 BinaryNode n=root;
			 int s= mySize(n);			 
			return s;
		 }
		 int mySize(BinaryNode n)
		 {
			 if(n==null)
			 {
				 return 0;
			 }
			  return 1 + mySize(n.left) + mySize(n.right);
		 }
		 public boolean isEmpty()
		 {
			 if(root==null)
			 {
				 return true;
			 }
			 return false;// check the tree is empty or not
		 }
		 public Integer findMin()
		 {
			 return findMin(this.root);
		 }
		 private Integer findMin(BinaryNode root)
		 {
			 if(root.left==null)
			 {
				 return root.element;
			 }
			 return findMin(root.left);
		 }
		 public Integer findMax()
		 {
		 return findMax(this.root);
		}
		public Integer findMax(BinaryNode root)
		{
			if(root.right==null)
			{
				return root.element;
			}
			return findMax(root.right);
		}
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void printTree() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			printTree(root);
	}
	// Inorder Traversal to print the nodes in Ascending order
	private void printTree( BinaryNode t ){
		if( t != null ){
			printTree( t.left );
		    System.out.print(t.element+",");
		    printTree( t.right );
		} 
	}
		 
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}
	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left;      // Left child
		private BinaryNode right;     // Right child	  
		// Constructors 
		
		BinaryNode( Integer theElement ){
			this( theElement, null, null );
		}	

		BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
	}
		

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		//int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
		int [] a = {43, 15, 60, 8, 30, 50, 82, 20, 35, 70};
	
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);
					
		}
		mybst.insert(12);
		System.out.println("________________InOrder______________ \n");
		mybst.printTree();
		System.out.println("\n");
		System.out.println("________________PreOrder______________ \n");
		mybst.preOrder();
		System.out.println("\n");
		System.out.println("________________PostOrder______________ \n");
		mybst.postOrder();
		System.out.println("\n");
		
		System.out.println("Minimum value: " + mybst.findMin());
		System.out.println("Maximum value: " + mybst.findMax());
		System.out.println("Contens: " + mybst.contains(19));
		System.out.println("No of Leaf Node: " + mybst.leafNodes());
		System.out.println("No of Node(Size): " + mybst.size());
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for (int j = 0; j < a.length; j++ ) {
			ts.add(a[j]);
			System.out.println("\nAfter inserting " + j + "th item " + a[j]);
			Iterator<Integer> it = ts.iterator();		
			Integer nextItem = null;
			while(it.hasNext()) {
				nextItem = it.next();
				System.out.print(nextItem + " ");
			} 
			System.out.println();
		}
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(8, "Hello");
		map.put(10, "World!");
		map.put(11, "Welcome");
		map.remove(8);
		String str = map.get(11)+", "+ map.get(10);
		System.out.println(str);
			
	}
}
