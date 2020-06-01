package com.ds.linkedlist.singlelist;

class Node {
	private int data;
	private Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "" + this.getData();  
	}

}

class SLinkedList {
	private Node head;
	private int length;

	/*
	 * Head will be the next of new node.
	 * Make current node as the head.
	 * Update the length of list.
	 */
	public synchronized void insertAtBegening(Node node) {
		node.setNext(this.head);
		this.setHead(node);
		this.setLength(this.getLength() + 1);
	}
	
	/*
	 * Check whether head is null or not.
	 * If head is null, make current node as head.
	 * If head is not null, traverse until last node's next is not null.
	 * Set current node as next of the last node.
	 * Update the length of list.
	 */
	public synchronized void insertAtEnd(Node node) {
		if (this.head == null) {
			this.setHead(node);
		} else {
			Node temp = this.getHead();
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		this.setLength(this.getLength() + 1);
	}
	
	public synchronized void insertAtPosition(Node node, int pos) {
		if (pos < 0) {
			pos = 0;
		}
		if (pos > this.getLength()) {
			pos = this.getLength();
		}
		if (this.head == null) {
			this.setHead(node);
		} else if (pos == 0) {
			node.setNext(this.getHead());
			this.setHead(node);
		} else {
			Node temp = this.getHead();
			for (int i=1; i<pos; i++) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		this.setLength(this.getLength() + 1);
	}
	
	/*
	 * Check if the list is not empty.
	 * Store head's next node.
	 * Make head's next node as head.
	 * Update list length.
	 */
	public synchronized void deleteFromBegin() {
		if (this.getLength() > 0) {
			Node temp = this.getHead().getNext();
			this.setHead(temp);
			this.setLength(this.getLength() - 1);
		}
	}
	
	/*
	 * Check list length.
	 * if Length is only one then delete head and make it null.
	 * if length is greater than 1 then traverse until length - 1
	 * Make that node's next as null.
	 * Update list length.
	 */
	public synchronized void deleteFromEnd() {
		if (this.getLength() > 0) {
			if (this.getLength() == 1) {
				this.setHead(null);
			} else {
				Node temp = this.getHead();
				for (int i=1; i<this.getLength()-1; i++) {
					temp = temp.getNext();
				}
				temp.setNext(null);
			}
			this.setLength(this.getLength() - 1);
		}
	}
	
	/*
	 * Check if head is null then return null as list is empty.
	 * Otherwise make two pointer one is pre and one is next.
	 * Make pre node's next as null.
	 * Update length of list.
	 */
	public synchronized Node deleteFromEnd2() {
		if (this.head == null) {
			return null;
		}
		Node pre = null;
		Node next = this.getHead();
		
		while(next.getNext() != null) {
			pre = next;
			next = next.getNext();
		}
		pre.setNext(null);
		this.setLength(this.getLength() - 1);
		return next;
	}
	
	/*
	 * Validate the position or empty list.
	 * Loop through the list until the < position.
	 * Set the current node's next to next -> next, removing the position element.
	 * Update the list length.
	 */
	public synchronized void delete(int pos) {
		if (pos > this.getLength()) { pos = this.getLength(); }
		if (pos < 0) { pos = 0; }
		if (this.head == null) {
			return;
		}
		if (pos == 0) {
			Node next = this.getHead().getNext();
			this.setHead(next);
		} else {
			Node temp = this.getHead();
			for (int i=1; i<pos; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		this.setLength(this.getLength() - 1);
	}
	
	public synchronized void traverse() {
		Node temp = this.getHead();
		while (temp != null) {
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}

public class SingleLinkedList {

	public static void main(String[] args) {
		SLinkedList list = new SLinkedList();
		list.insertAtBegening(new Node(2));
		list.insertAtBegening(new Node(4));
		list.insertAtEnd(new Node(34));
		list.insertAtPosition(new Node(11), 1);
		list.traverse();
		list.delete(0);
		list.traverse();
	}

}
