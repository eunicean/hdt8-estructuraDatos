package project;

public class Heap <T>{

	private Node<T> getParent(Node<T> current){
		return current.getParent();
	}
	private void swap(Node<T> a,Node<T> b) {
		T temp = a.getValue();
		a.setValue(b.getValue());
		b.setValue(temp);
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
