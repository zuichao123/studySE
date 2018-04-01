package cn.sunjian.link;

class Link{		// ����������
	class Node{	// ����ÿһ���ڵ㣬�˴�Ϊ�˷���ֱ�Ӷ�����ڲ���
		private String data ;	// ����ڵ������
		private Node next ;		// ������һ���ڵ�
		public Node(String data){
			this.data = data ;		// ͨ�����췽�����ýڵ�����
		}
		public void add(Node newNode){		// ���ڵ���뵽���ʵ�λ��
			if(this.next==null){			// �����һ���ڵ�Ϊ�գ�����½ڵ�������next��λ����
				this.next = newNode ;
			}else{		// �����Ϊ�գ�����Ҫ���¼�����next
				this.next.add(newNode) ;
			}
		}
		public void print(){
			System.out.print(this.data + "\t") ;	// ����ڵ�����
			if(this.next!=null){		// ������һ��Ԫ�أ���Ҫ�������
				this.next.print() ;	// ��һ���ڵ��������print
			}
		}
		public boolean search(String data){	// �ڲ������ķ���
			if(data.equals(this.data)){		// �ж�����������Ƿ�͵�ǰ�ڵ������һ��
				return true ;
			}else{	// ���¼����ж�
				if(this.next!=null){	// ��һ���ڵ�������ڣ����������
					return this.next.search(data) ;	// ������һ���Ĳ�ѯ���
				}else{
					return false ;		// ������еĽڵ㶼��ѯ��֮��û��������ȣ��򷵻�false
				}
			}
		}
		public void delete(Node previous,String data){
			if(data.equals(this.data)){	// �ҵ���ƥ��Ľڵ�
				previous.next = this.next ;	// �ճ���ǰ�Ľڵ�
			}else{
				if(this.next!=null){	// ���Ǵ�����һ���ڵ�
					this.next.delete(this,data) ;	// ��������
				}
			}
		}
	};
	private Node root ;		// �����б�Ȼ����һ�����ڵ�
	public void addNode(String data){	// ���ӽڵ�
		Node newNode = new Node(data) ;	// �����µĽڵ�
		if(this.root==null){			// û�и��ڵ�
			this.root = newNode ;	// ����һ���ڵ����óɸ��ڵ�
		}else{		// ���Ǹ��ڵ㣬�ŵ����һ���ڵ�֮��
			this.root.add(newNode) ;	// ͨ��Node�Զ����Ŵ˽ڵ�ŵ�λ��
		}
	}
	public void printNode(){		// ���ȫ������������
		if(this.root!=null){		// �����Ԫ�ز�Ϊ��
			this.root.print() ;	// ����Node���е��������
		}
	}
	public boolean contains(String name){	// �ж�Ԫ���Ƿ����
		return this.root.search(name) ;	// ����Node���еĲ��ҷ���
	}
	public void deleteNode(String data){		// ɾ���ڵ�
		if(this.contains(data)){	// �жϽڵ��Ƿ����
			// һ��Ҫ�жϴ�Ԫ�������ǲ��Ǹ�Ԫ����ȵ�
			if(this.root.data.equals(data)){	// �����Ǹ��ڵ�
				this.root = this.root.next ;	// �޸ĸ��ڵ㣬����һ���ڵ����óɸ��ڵ�
			}else{
				this.root.next.delete(root,data) ;	// ����һ���ڵ��ǰ�ڵ������һ�����ȥ
			}
		}
	}
};
public class LinkDemo2{
	public static void main(String args[]){
		Link l = new Link() ;
		l.addNode("A") ;		// ���ӽڵ�
		l.addNode("B") ;		// ���ӽڵ�
		l.addNode("C") ;		// ���ӽڵ�
		l.addNode("D") ;		// ���ӽڵ�
		l.addNode("E") ;		// ���ӽڵ�
		System.out.println("======= ɾ��֮ǰ ========") ;
		l.printNode() ;
		// System.out.println(l.contains("X")) ;
		l.deleteNode("C") ;		// ɾ���ڵ�
		l.deleteNode("D") ;		// ɾ���ڵ�
		l.deleteNode("A") ;		// ɾ���ڵ�
		System.out.println("\n====== ɾ��֮�� =========") ;
		l.printNode() ;
		System.out.println("\n��ѯ�ڵ㣺" + l.contains("B")) ;
	}
};