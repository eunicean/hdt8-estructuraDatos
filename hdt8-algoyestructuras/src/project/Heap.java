package project;

public class Heap <T>{

	private int sizeTree;
	private Node<T> root;
	
	private Node<T> getParent(Node<T> current){
		return current.getParent();
	}
	private void swap(Node a,Node b) {
		T temp = (T) a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
	}
	
	private String route() {
		var size = sizeTree;
		var position = size + 1;
		var binary = Integer.toBinaryString(position);
		var branchRoute = binary.substring(1);
		
		return branchRoute;
	}
	
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
	
	private void shiftUp(Node<T> current) {
	    Patients currentVal = (Patients) current.getValue();

	    while (current != root) {
	        Node<T> parent = current.getParent();
	        Patients parentVal = (Patients) parent.getValue();

	        if (currentVal.compareTo(parentVal) < 0) {
	            swap(parent, current);
	            current = parent;
	        } else {
	            break;
	        }
	    }
	}
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
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(T value) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
