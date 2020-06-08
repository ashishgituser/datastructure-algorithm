package com.ds.linkedlist.doubly;

class Node {
	private int data;
	private Node prev;
	private Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}
	
	public Node(int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getData());
	}
}

public class DoublyLinkedList {

	private Node head;
	private int length;

	public synchronized void insertInBegin(int data) {
		Node newNode = new Node(data);
		if (this.getHead() == null) {
			this.setHead(newNode);
		} else {
			this.getHead().setPrev(newNode);
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setLength(this.getLength() + 1);
	}
	
	public synchronized void insertAtEnd(int data) {
		Node newNode = new Node(data);		
		if (this.getHead() == null) {
			this.setHead(newNode);
		} else {
			Node last = this.getHead();
			while(last.getNext() != null) {
				last = last.getNext();
			}
			newNode.setPrev(last);
			newNode.setNext(null);
			last.setNext(newNode);
		}
		this.setLength(this.getLength() + 1);
	}
	
	public synchronized void insert(int data, int pos) {
		Node newNode = new Node(data);
		if (pos > this.getLength() || pos < 0) { return; }
		if (this.getHead() == null) {
			this.setHead(newNode);
		} else if (pos == 0) {
			this.insertInBegin(data);
		} else {
			Node last = this.getHead();
			for (int i=1; i<pos; i++) {
				last = last.getNext();
			}
			newNode.setPrev(last);
			newNode.setNext(last.getNext());
			last.getNext().setPrev(newNode);
			last.setNext(newNode);
		}
		this.setLength(this.getLength() + 1);
	}
	
	public synchronized void deleteFromBegin() {
		if (this.getHead() == null) return;
		if (this.getLength() == 1) { 
			this.setHead(null);
			this.setLength(0);
			return; 
		}
		Node headNext = this.getHead().getNext();
		headNext.setPrev(null);
		this.setHead(headNext);
		this.setLength(this.getLength() - 1);
	}
	
	public synchronized void deleteFromEnd() {
		if (this.getHead() == null) return;
		if (this.getLength() == 1) { 
			this.setHead(null);
			this.setLength(0);
			return; 
		}
		Node next = this.getHead();
		while(next.getNext() != null) {
			next = next.getNext();
		}
		Node nextPrev = next.getPrev();
		nextPrev.setNext(null);
		this.setLength(this.getLength() - 1);
	}

	public synchronized void traverse() {
		Node temp = this.getHead();
		while(temp != null) {						
			System.out.print(temp + ", ");
			temp = temp.getNext();
		}
		System.out.println("Length : " + this.getLength());
		System.out.println();
	}
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insertInBegin(20);
		dl.insertInBegin(30);
		dl.insertAtEnd(22);
		dl.insert(44, 2);
		dl.traverse();
		dl.deleteFromBegin();
		dl.traverse();
		dl.deleteFromEnd();
		dl.traverse();
	}

}
