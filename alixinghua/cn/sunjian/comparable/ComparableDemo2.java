package cn.sunjian.comparable;

/**
 * ʵ���Զ������㷨��
 * 
 * 		�������㷨������Ҫ������ϰ
 * 
 * @author jack
 *
 */
class BinaryTree{
	@SuppressWarnings("rawtypes")
	
	//�ڲ���
	class Node{//����һ���ڵ���
		private Comparable data;//������������
		private Node left;//����������
		private Node right;//����������
		
		public Node(Comparable data){
			this.data = data;
		}
		
		//�ж��Ƿ�������������������
		@SuppressWarnings("unchecked")
		public void addNode(Node newNode){
			
			if (newNode.data.compareTo(this.data)<0) {//����С������������
				if (this.left == null) {		//���û��������			
					this.left = newNode;//ֱ�ӽ��µĽڵ����ó�������
				}else {
					this.left.addNode(newNode);//���������ж�
				}
			}
			
			if (newNode.data.compareTo(this.data)>=0) {//���ݴ󣬷���������
				if (this.right == null) {		//���û��������
					this.right = newNode;//ֱ�ӽ��µĽڵ����ó�������
				}else {
					this.right.addNode(newNode);//���������ж�
				}
			}
		}
		
		//����ڵ�����
		public void printNode(){//�����ʱ������������
			
			if (this.left != null) {
				this.left.printNode();//���������
			}
			System.out.println(this.data+"\t");
			
			if (this.right != null) {
				this.right.printNode();//���������
			}
		}
	}
	
	private Node root;//��Ԫ��
	public void add(@SuppressWarnings("rawtypes") Comparable data){//����Ԫ��
		Node newNode = new Node(data);//�����µĽڵ�
		
		//�ж�
		if (root == null) {//û�и��ڵ�
			root = newNode;//��һ��Ԫ����Ϊ���ڵ�
		}else {
			root.addNode(newNode);//ȷ���Ƿ�������������������
		}
	}
	
	//ͨ�����ڵ����
	public void print(){
		this.root.printNode();
	}
	
}


public class ComparableDemo2 {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		
		bt.add(23);
		bt.add(203);
		bt.add(123);
		bt.add(230);
		bt.add(223);
		bt.add(239);
		
		System.out.println("ͨ������������");
		
		bt.print();
		
	}

}
