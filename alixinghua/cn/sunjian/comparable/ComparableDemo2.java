package cn.sunjian.comparable;

/**
 * 实现以二叉树算法：
 * 
 * 		此排序算法，很重要，多练习
 * 
 * @author jack
 *
 */
class BinaryTree{
	@SuppressWarnings("rawtypes")
	
	//内部类
	class Node{//声明一个节点类
		private Comparable data;//保存具体的内容
		private Node left;//保存左子树
		private Node right;//保存右子树
		
		public Node(Comparable data){
			this.data = data;
		}
		
		//判断是放在左子树还是右子树
		@SuppressWarnings("unchecked")
		public void addNode(Node newNode){
			
			if (newNode.data.compareTo(this.data)<0) {//内容小，放在左子树
				if (this.left == null) {		//如果没有左子树			
					this.left = newNode;//直接将新的节点设置成左子树
				}else {
					this.left.addNode(newNode);//继续向下判断
				}
			}
			
			if (newNode.data.compareTo(this.data)>=0) {//内容大，放在右子树
				if (this.right == null) {		//如果没有右子树
					this.right = newNode;//直接将新的节点设置成右子树
				}else {
					this.right.addNode(newNode);//继续向下判断
				}
			}
		}
		
		//输出节点内容
		public void printNode(){//输出的时候采用中序遍历
			
			if (this.left != null) {
				this.left.printNode();//输出左子树
			}
			System.out.println(this.data+"\t");
			
			if (this.right != null) {
				this.right.printNode();//输出右子树
			}
		}
	}
	
	private Node root;//根元素
	public void add(@SuppressWarnings("rawtypes") Comparable data){//加入元素
		Node newNode = new Node(data);//定义新的节点
		
		//判断
		if (root == null) {//没有根节点
			root = newNode;//第一个元素作为根节点
		}else {
			root.addNode(newNode);//确定是放在左子树还是右子树
		}
	}
	
	//通过根节点输出
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
		
		System.out.println("通过二叉树排序：");
		
		bt.print();
		
	}

}
