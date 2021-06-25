import java.util.NoSuchElementException;

/**
	 * This is a BST data structure and also maintains the insertion order.
	 *
	 */
	public class OrderedBSTree {
		//PAGE 329 FOR SOME REFERENCE
		//you may add any method or variable here.
		
		
		
		
		public void doItForMe(BSTNode myGoodFriend) { //Method to add the new node to the linked list
			
			myGoodFriend.prev = tail.prev; //first, make our new value's previous as tail.prev, and next as tail
			myGoodFriend.next = tail;
			
			tail.prev.next = myGoodFriend; //then, make our tail.prev.next = pointing to our new inserted one
			
			tail.prev = myGoodFriend; //and lastly, make tail.prev point to our new value
			
			size++; //update the size
		}
		
		
		
		private class BSTNode{
			int val; //this is for both the tree and linked list
			BSTNode left; //tree
			BSTNode right; //tree
			BSTNode next; //linked list
	        BSTNode prev; //linked list


		}

	    private final BSTNode head = new BSTNode(); //linked list
	    private final BSTNode tail = new BSTNode(); //linked list
	    private BSTNode root; //tree
	    private int size; //Both
	    
	    public OrderedBSTree() {
	        head.next = tail;
	        tail.prev = head;
	      }
	    
	    public OrderedBSTree(BSTNode r) {
	        root = r;
	        head.next = tail;
	        tail.prev = head;
	      }
	    
		/**
		 * return the last inserted element
		 * Runtime is O(1)
		 * @return
		 * @throws Exception 
		 */
		public int getLast() throws Exception {
			//your code goes here
			BSTNode testNode = tail.prev; // new BSTNode();
			//testNode = tail.prev;
			if (size == 0 || head.next == tail.prev || root == null) {
			      throw new NoSuchElementException("Tree is Empty.");
			    }
			return testNode.val;
		}
		
		/**
		 * return the min value of the tree.
		 * Runtime is â‰¤ O(lgN)
		 * @return
		 */
		public int getMin() {
			BSTNode testNode = root; //new BSTNode();
			if (size == 0 || head.next == tail.prev || root == null) {
			      throw new NoSuchElementException("Tree is Empty.");
			    }
			//testNode = root;
			while (testNode.left != null) {
				testNode = testNode.left;
			}
			
			return testNode.val;
		}
		
		/**
		 * return the max value of the tree.R
		 * Runtime is â‰¤ O(lgN)
		 * @return
		 */
		public int getMax() {
			//your code goes here.
			BSTNode testNode = root;// new BSTNode();
			if (size == 0 || head.next == tail.prev || root == null) {
			      throw new NoSuchElementException("Tree is Empty.");
			    }
			//testNode = root;
			while (testNode.right != null) {
				testNode = testNode.right;
			}
			return testNode.val;
		}
		
		/**
		 * delete element from the tree.
		 * Runtime is â‰¤ O(lgN)
		 * @param val 
		 * @return true if successfully removed. otherwise return false.
		 */
		public boolean delete(int val) {
			//your code goes here.
			BSTNode deletor = root;
			BSTNode del_parent = null;
			BSTNode parent_of_new_root = null;
			
			
			//Check for empty 
			if (size == 0 || head.next == tail.prev || root == null) {
			      throw new NoSuchElementException("Tree is Empty.");
			    }
			
			
			//Delete the value from the linked list			
			
			
//			if (head.next == null)
//				return false;
//			
//			BSTNode p = head.next;
//			if (p.next == null) {
//				p.prev.next = p.next; //Set the previous node's next to p's next node
//				p.next.prev = p.prev; //Set p's next node's prev to p's previous node
//				size--;
//			}
//				
//			if (p.next != null) {
//			while (p.next.val != val) { //this sets it up so that our p is in the correct place
//				p = p.next;
//			}
//			
//			//now for the actual deletion
//			p.prev.next = p.next; //Set the previous node's next to p's next node
//			p.next.prev = p.prev; //Set p's next node's prev to p's previous node
//			size--; //reduce the size
//			}
					
			
			
			//now remove "deletion" from linked list O(1)
			  if(val == tail.prev.val) {
			    (tail.prev.prev).next = tail;
			    tail.prev = tail.prev.prev;
			  } //checks whether val is the last element in the doubly linked-list, and if it is, update the tail.prev value (without doing this, an error will be thrown)
			  else if(val == head.next.val){
			    (head.next.next).prev = head; 
			    head.next = head.next.next;
			  } //checks whether val is the first element in the doubly linked-list, and if it is, update the head.next value (without doing this, an error will be thrown)
			  else {
			    deletor.prev.next = deletor.next;
				  deletor.next.prev = deletor.prev;
			  } //if the value is just in the middle of the list then just remove accordingly 
			  
			  
			  
			
			//First find the right node to delete
			while (deletor.val != val) { //once it is the loop has found the right place
				
				//set parent to the deletor current spot
				del_parent = deletor;
				
				//Move right if the val > deletor.val
				if (deletor.right != null && val > deletor.val)
					deletor = deletor.right;
				
				//otherwise move left
				else if (deletor.left != null && val < deletor.val)
					deletor = deletor.left;
				
				//otherwise return false
				else return false;
			}
			
			//now starts the actual deletion part
			
			//This deletes the deletor if deletor has no children
			if (deletor.left == null && deletor.right == null) {
				if (del_parent.left == deletor) //these if statements find out if the deletor is to the right or left of the del_parent
					del_parent.left = null;
				else if (del_parent.right == deletor)
					del_parent.right = null;
				return true;
				}
			
			//This will delete the deletor when it only has children on the right
			if (deletor.left == null && deletor.right != null) {
				if (del_parent.left == deletor) { //these if statements find out if the deletor is to the right or left of the del_parent
					del_parent.left = deletor.right; //set the child of the del_parent equal to the deletor's child
				}
				else if (del_parent.right == deletor) {
					del_parent.right = deletor.right;
				}
				return true;
			}
			
			//This will delete the deletor when it only has children on the left
			if (deletor.right == null && deletor.left != null) {
				if (del_parent.left == deletor) { //these if statements find out if the deletor is to the right or left of the del_parent
					del_parent.left = deletor.left; //set the child of the del_parent equal to the deletor's child
				}
				else if (del_parent.right == deletor) {
					del_parent.right = deletor.left;
				}
				return true;
			}
			
			//This is for when the deletor node has two children
			if (deletor.right != null && deletor.left != null) {
				//if the deletor is on the right of the del_parent
				if (del_parent.right == deletor) { 
					deletor = deletor.right; //move it over one time to the right
					
					
					while (deletor.left != null) { //this sets it up so that we find the next closest node to the root using inorder
						parent_of_new_root = deletor;
						deletor = deletor.left;
					}
					del_parent.right.val = parent_of_new_root.left.val; //instead of changing the nodes entirely, I just copied over the value
					parent_of_new_root.left = null; //At this point I delete the original inorder new node, effectively "swapping" it
				}
				
				//Now for when the deletor is on the left of del_parent
				if (del_parent.left == deletor) { 
					deletor = deletor.left; //move it over one time to the left
					
					
					while (deletor.right != null) { //this sets it up so that we find the next closest node to the root using inorder
						parent_of_new_root = deletor;
						deletor = deletor.right;
					}
					del_parent.left.val = parent_of_new_root.right.val; //instead of changing the nodes entirely, I just copied over the value
					parent_of_new_root.right = null; //At this point I delete the original inorder new node, effectively "swapping" it
				}
				return true;
			}
			
			
			return false;
		}
		
		/**
		 * insert element into the tree.
		 * Runtime is â‰¤ O(lgN)
		 * @param val 
		 * @return true if successfully added. otherwise return false.
		 */
		 public boolean insert(int val) {
			//your code goes here.
			//System.out.println("Work");
			
			BSTNode newNode = new BSTNode();
				newNode.val = val;
				
			if (root == null) {
//				 root = new BSTNode();
//				root.val = val;
//				doItForMe(root);
//				
//				return true;
				
				
				
				
				root = newNode;
				doItForMe(root); 
				return true;
				
			}
			
			BSTNode traversingNode = new BSTNode();// root; //new BSTNode();
			traversingNode = root;
			traversingNode.val = root.val;
			//traversingNode.val = val;
			while(traversingNode != null) {
				
				if (newNode.val == traversingNode.val) //if the value we try to put in is already in there
			return false;
					
				
				else if (newNode.val > traversingNode.val ) {//if the value of our new node is > our traversing node, move the traversing node to the right
					//current = current.right;
					
					if (traversingNode.right == null) { //this section says that if there was no node already there, return true
						traversingNode.right = newNode;
						doItForMe(newNode); //put the node into the linked list. Then, put it into the tree as well
						//current.right.val = val;
						return true;
					}
					
					traversingNode = traversingNode.right;
				}
				
				else if  (newNode.val < traversingNode.val ) { 
					//current = current.left;
					
					if (traversingNode.left == null) {
						traversingNode.left = newNode;
						doItForMe(newNode);
						//current.left.val = val;
						return true;
				}
					traversingNode = traversingNode.left;
					
				}					
			}
			
			return false;
		} 
		
		
		
		/**
		 * delete the last inserted element.
		 * Runtime is â‰¤ O(lgN)
		 * @return
		 * @throws Exception 
		 */
		public int removeLast() throws Exception {
			//your code goes here.
			//delete from the linked list
			//call the delete method
			
			//or just call the delete method
			//get the value you're deleting, delete it
			
			int value = 0;
			
			if (size == 0 || head.next == tail.prev || root == null) {
			      throw new NoSuchElementException("Tree is Empty.");
			    }
			else {
				value = getLast();
				delete(value);
				return value;
			}
			
		}
		
		
		public static void main(String[] args) throws Exception {
			//example1
			OrderedBSTree tree = new OrderedBSTree();
			tree.insert(15);
			tree.insert(12);
			tree.insert(10);
			tree.insert(29);
			tree.insert(5);
			tree.insert(100);
			tree.insert(100);
			System.out.println(tree.getMax()); 			//100
			System.out.println(tree.getLast());			//100
			System.out.println(tree.removeLast());		//100
			System.out.println(tree.delete(100)); 		//false
			System.out.println(tree.getLast());			//5
			System.out.println(tree.getMin()); 			//5
			System.out.println(tree.getMax()); 			//29
			System.out.println(tree.delete(12)); 		//true
			System.out.println(tree.delete(12)); 		//false
			System.out.println(tree.insert(10)); 		//false

		}

	}
	
	/*
	 public boolean insert(int val) {
			//your code goes here.
			System.out.println("Work");
			
			BSTNode new_node = new BSTNode();
				new_node.val = val;
				
			if (root == null) {
//				 root = new BSTNode();
//				root.val = val;
//				doItForMe(root);
//				
//				return true;
				
				
				
				
				root = new_node;
				doItForMe(root); 
				return true;
				
			}
			
			BSTNode traversingNode = new BSTNode();// root; //new BSTNode();
			traversingNode = root;
			traversingNode.val = root.val;
			//traversingNode.val = val;
			while(true) {
				
				if (val == traversingNode.val) //if the value we try to put in is already in there
			return false;
					
				
				if (val > traversingNode.val ) {//if the value of our new node is > our traversing node, move the traversing node to the right
					traversingNode = traversingNode.right;
					
					if (traversingNode.right == null) { //this section says that if there was no node already there, return true
						doItForMe(traversingNode); //put the node into the linked list. Then, put it into the tree as well
						traversingNode.right.val = val;
						return true;
					}
				}
				
				else if  (val < traversingNode.val ) { 
					traversingNode = traversingNode.left;
					
					if (traversingNode.left == null) {
						doItForMe(traversingNode);
						traversingNode.left.val = val;
						return true;
				}
					
				}					
			}
			
			
		} 
		*/

