package cn.sunjian.link;

/**
 * 链表
 * 
 * @author sunjian
 *
 */

class Node{//定义节点类
	private String data;//保存节点内容
	private Node next; //保存下一个节点
	
	public Node(String data){//通过构造设置节点内容
		this.data = data;
	}
	
	public void setNode(Node next){//设置下一个节点
		this.next = next;
	}
	public Node getNext(){//取得下一个节点
		return this.next;
	}
	
	public String getData(){//取得节点内容
		return this.data;
	}
}




public class LinkDemo {

	public static void main(String[] args) {
		Node root = new Node("火车头");
		Node n1 = new Node("车厢-A");
		Node n2 = new Node("车厢-B");
		Node n3 = new Node("车厢-C");
		
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
