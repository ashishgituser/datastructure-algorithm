package com.ds.linkedlist.doubly;

class Node {
	private int data;
	private Node prev;
	private Node next;

	public Node() {
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
	private Node tail;
	private int length;
	
	public DoublyLinkedList() {
		this.head = new Node(Integer.MIN_VALUE, null, null);
		this.tail = new Node(Integer.MIN_VALUE, this.head, null);
		this.length = 0;
	}

	public synchronized void insertInBegin(int data) {
		Node newNode = new Node(data, null, this.getHead());
		this.getHead().setPrev(newNode);
		this.setHead(newNode);
		this.setLength(this.getLength() + 1);
	}

	public synchronized void traverse() {
		Node temp = this.getHead();
		while(temp.getNext() != null) {
			System.out.print(temp + ", ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
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
		dl.traverse();
	}

}
