package mypack.my_linkedlist;

public class MyLinkedList {
	public static void main(String[] args) {//10,20

		LL ll1 = new LL(new LL.Node(10));
		
		ll1.addNodeAtEnd(20);
		
		ll1.printLL();

	}

}

class LL {
	Node head;

	LL(Node head) {
		this.head = head;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	void printLL() {
		Node dummyHead = this.head;
		while (dummyHead != null) {
			System.out.println(dummyHead.data);
			dummyHead = dummyHead.next;
		}

	}

	Node addNodeAtEnd(int data) {
		Node tail = this.getTailNode();
		tail.next = new LL.Node(data);
		return tail.next;
	}

	Node getTailNode() {// traversal of a linked list...each linkedlist is identified with head
		Node dummyHead = this.head;//
		Node prevToDummyHead = null;

		while (dummyHead != null) {
			// System.out.println(dummyHead.data);
			prevToDummyHead = dummyHead;
			dummyHead = dummyHead.next;
		}

		return prevToDummyHead;
	}
	
	int getSize(){
		Node dummyHead = this.head;
		int count = 0;
		while (dummyHead != null) {
			++count;
			dummyHead = dummyHead.next;
		}
		return count;
	}
}