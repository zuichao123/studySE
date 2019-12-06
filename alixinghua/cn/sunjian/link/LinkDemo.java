package cn.sunjian.link;

/**
 * ����
 * 
 * @author sunjian
 *
 */

class Node{//����ڵ���
	private String data;//����ڵ�����
	private Node next; //������һ���ڵ�
	
	public Node(String data){//ͨ���������ýڵ�����
		this.data = data;
	}
	
	public void setNode(Node next){//������һ���ڵ�
		this.next = next;
	}
	public Node getNext(){//ȡ����һ���ڵ�
		return this.next;
	}
	
	public String getData(){//ȡ�ýڵ�����
		return this.data;
	}
}




public class LinkDemo {

	public static void main(String[] args) {
		Node root = new Node("��ͷ");
		Node n1 = new Node("����-A");
		Node n2 = new Node("����-B");
		Node n3 = new Node("����-C");
		
		root.setNode(n1);
		n1.setNode(n2);
		n2.setNode(n3);
		
		print(root);
	}
	
	public static void print(Node node){
		System.out.print(node.getData()+"\t");
		if (node.getNext()!=null) {
			print(node.getNext());
		}
	}

}
