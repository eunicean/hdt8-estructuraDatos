/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * @author Eunice Mata - 21231
 * Object that simulates the heap or list that will order the patients
 * It took an ass long time to read all my ss
 */

package project;

public class Heap <T>{

	private int sizeTree;
	private Node<T> root;
	
	/**
	 * Method to get the parent of the current node
	 * @param current node that we need to know its parent 
	 * @return Node with the parent
	 */
	private Node<T> getParent(Node<T> current){
		return current.getParent();
	}
	/**
	 * Method that switches of  position two nodes
	 * @param a node to swap for b
	 * @param b node to swap for a
	 */
	private void swap(Node a,Node b) {
		T temp = (T) a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
	}
	
	/**
	 * Method that gets the route where its needed to add the node/patient
	 * @return String branchRoute whit the route
	 */
	private String route() {
		var size = sizeTree;
		var position = size + 1;
		var binary = Integer.toBinaryString(position);
		var branchRoute = binary.substring(1);
		
		return branchRoute;
	}
	
	/**
	 * Method that simulates de insertion of a new node/patient
	 * @param root Node that is the root/parent of our new node
	 * @param route String with the brancRoute where is needed to be added the node/patient
	 * @param value type T or patient to add to the tree
	 * @return Node
	 */
	private Node<T> insert(Node<T> root, String route, T value){
		var nextNode = "" + route.charAt(0);
		if(route.length() > 1) {
	        var node = (nextNode.equals("0")) ? root.getLeft() : root.getRigth();
	        return insert(node, route.substring(1), value);
	    }
		
		sizeTree = sizeTree + 1;
		var newNode = new Node<T>(value, root);
		
		Node<T> node = null;
	    if (nextNode.equals("0")) {
	        node = root.getLeft();
	        newNode.setParent(root);
	        root.setLeft(newNode);

	    } else {
	        node = root.getRigth();
	        newNode.setParent(root);
	        root.setRigth(newNode);
	    }

	    return newNode;
	}
	
	/**
	 * Method that simulates the shift up of the nodes
	 * @param current is the node/patient that will mode the rest
	 */
	private void shiftUp(Node<T> current) {
	    Patients currentValue = (Patients) current.getValue();

	    while (current != root) {
	        Node<T> parent = current.getParent();
	        Patients parentValue = (Patients) parent.getValue();

	        if (currentValue.compareTo(parentValue) < 0) {
	            swap(parent, current);
	            current = parent;
	        } else {
	            break;
	        }
	    }
	}

	/**
	 * Method that simulates the shift down of the nodes
	 * @param current is the node/patient that will mode the rest
	 */
	private void shiftDown(Node<T> current) {
	    while (current.getLeft() != null) {
	        Node<T> minChild = current.getLeft();
	        if (current.getRigth() != null && ((Patients) current.getRigth().getValue()).compareTo((Patients) minChild.getValue()) < 0) {
	            minChild = current.getRigth();
	        }
	        if (((Patients) current.getValue()).compareTo((Patients) minChild.getValue()) <= 0) {
	            break;
	        }
	        swap(current, minChild);
	        current = minChild;
	    }
	}
	
	/**
	 * Method that will simulate the addition of a new node/patient to the tree
	 * @param value T in this case the patient to add to the tree
	 */
	public void insert(T value) {
		if(root == null) {
			root = new Node<T>(value,null);
			this.sizeTree = 1;
		}
		else {
			var branchR = route();
			var newNode = insert(root, branchR,value);
			shiftUp(newNode);
		}
	}
	
	/**
	 * Method that will print the nood and all others under them
	 * @param root
	 * @param branchRoute
	 * @return
	 */
	private Node<T> PrintNode(Node<T> root, String branchRoute) {
	    if (branchRoute.isEmpty()) {
	        return root;
	    }
	    var node = (branchRoute.charAt(0) == '0') ? root.getLeft() : root.getRigth();
	    if (node == null) {
	        return null;
	    }
	    return PrintNode(node, branchRoute.substring(1));
	}
	
	/**
	 * Methos tha will print the entire tree
	 */
	public void printTree() {
	    for (int i = 1; i <= sizeTree; i++) {
	        var binary = Integer.toBinaryString(i);
	        var branchRoute = binary.substring(1);
	        var node = PrintNode(root, branchRoute);
	        if (node != null) {
	            System.out.println(node.getValue().toString());
	        }
	    }
	}
	
	/**
	 * Method that will get the root
	 * @return the root node
	 */
	public Node<T> getFirst() {
		return root;
	}

	/**
	 * Method that will remove a node/patient and make the rest to move their new positions
	 * @return
	 */
	public T remove() {
	    if (root == null) {
	        System.out.println("La cola esta vacia");
	        return null;
	    }
	    
	    T rootValue = root.getValue();
	    Node<T> lastNode = getLastNode();
	    
	    if (lastNode == root) {
	        root = null;
	    } else {
	        root.setValue(lastNode.getValue());
	        if (lastNode.getParent().getLeft() == lastNode) {
	            lastNode.getParent().setLeft(null);
	        } else {
	            lastNode.getParent().setRigth(null);
	        }
	        shiftDown(root);
	    }
	    
	    sizeTree = sizeTree-1;
	    return rootValue;
	}

	/**
	 * Methods that will get the last Node in the tree
	 * @return
	 */
	private Node<T> getLastNode() {
	    if (root == null) {
	        return null;
	    }
	    
	    int binarySize = Integer.toBinaryString(sizeTree).length() - 1;
	    String binaryString = Integer.toBinaryString(sizeTree);
	    
	    Node<T> current = root;
	    for (int i = 1; i <= binarySize; i++) { // iterate to binarySize instead of binarySize - 1
	        if (binaryString.charAt(i) == '0') {
	            current = current.getLeft();
	        } else {
	            current = current.getRigth();
	        }
	    }
	    return current;
	}
	
	public void add(T value) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		if(sizeTree > 1)
			return true;
		else
			return false;
	}

	public int size() {
		return this.sizeTree;
	}

	public void clear() {
	}
	
	public int getSizeTree() {
		return sizeTree;
	}
	public void setSizeTree(int sizeTree) {
		this.sizeTree = sizeTree;
	}
	public Node<T> getRoot() {
		return root;
	}
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	

}
