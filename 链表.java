package com.upon.brush;

public class ���� {
	public static void main(String[] args) {
		SingleList singleList = new SingleList();

		singleList.addFirst(new Node(1, "lily"));
		singleList.addFirst(new Node(2, "rocy"));
		singleList.addFirst(new Node(3, "jack"));
		singleList.addFirst(new Node(4, "upon"));
		singleList.addFirst(new Node(5, "jane"));

		singleList.show();
		
		singleList.Reverse(singleList.head);

		singleList.show();
	}
}

class SingleList {

	// ��ʼ��,����ͷ���
	Node head = new Node(-1, "");

	public void Reverse(Node node) {
		Node pre = head.next;
		Node cur = pre.next;
		while (cur != null) {
			pre.next = cur.next;
			cur.next = head.next;
			head.next = cur;
			cur = pre.next;
		}

	}

	// ͷ��
	public void FrontInsert(int no, Node node) {
		Node tmp = head;
		boolean flg = false;
		while (true) {
			if (tmp.next == null) {
				break;
			} else if (tmp.next.no == no) {
				flg = true;
				break;
			}
			tmp = tmp.next;
		}
		if (flg) {
			node.next = tmp.next;
			tmp.next = node;
		} else {
			System.out.println("cannot find");
		}
	}

	// ͷ��
	public void addFirst(Node node) {
		Node tmp = head;
		node.next = tmp.next;
		tmp.next = node;
	}

	// β��
	public void addLast(Node node) {
		Node tmp = head;
		while (true) {
			if (tmp.next == null) {
				break;
			}
			tmp = tmp.next;
		}
		// ���
		tmp.next = node;
	}

	// ɾ��
	public void remove(int no) {
		Node tmp = head;
		boolean flg = false;

		while (true) {
			if (tmp.next == null) {
				break;
			} else if (tmp.next.no == no) {
				flg = true;
				break;
			}
			tmp = tmp.next;
		}
		if (flg) {
			tmp.next = tmp.next.next;
			System.out.println("remove success");
		} else {
			System.out.println("cannot find");
		}
	}

	// ����
	public void update(int no, String item) {
		Node tmp = head;
		boolean flg = false;

		while (true) {
			if (tmp.next == null) {
				break;
			} else if (tmp.next.no == no) {
				flg = true;
				break;
			}
			tmp = tmp.next;
		}
		if (flg) {
			tmp.next.item = item;
			System.out.println("update success");
		} else {
			System.out.println("cannot find");
		}
	}

	// ����
	public void show() {
		Node tmp = head;
		while (true) {
			if (tmp.next == null) {
				break;
			}
			tmp = tmp.next;
			System.out.println(tmp.toString());
		}
	}
}

class Node {
	public int no;
	public String item;
	public Node next;

	public Node(int no, String element) {
		this.no = no;
		this.item = element;
	}

	@Override
	public String toString() {
		return "item:" + " " + item + " " + "no:" + no;
	}

}