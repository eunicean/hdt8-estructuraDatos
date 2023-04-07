package project;

public class Node<T> {
	protected T value;
	Node<T> parent;
	Node<T> left;
	Node<T> rigth;
	
	public Node(T value, Node<T> parent) {
		this.value = value;
		this.parent = parent;
		this.left = null;
		this.rigth = null;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRigth() {
		return rigth;
	}
	public void setRigth(Node<T> rigth) {
		this.rigth = rigth;
	}
	
	
}
