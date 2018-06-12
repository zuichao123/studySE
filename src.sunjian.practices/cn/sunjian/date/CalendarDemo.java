package cn.sunjian.date;

/**
 * ����Calendar��Ĳ�����
 * 		��ȡ��ǰ����ʱ��
 * 		��ȡʱ���
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * �Ժ�ֱ��ͨ������Ϳ���ȡ������ʱ��
 */
class DateTime{
	
	private Calendar calendar = null;//����һ��calendar����
	
	public DateTime(){//���췽���У�ֱ��ʵ��������
		this.calendar = new GregorianCalendar();
	}
	
	/*
	 * ���巽����getDate
	 * 	 �õ�һ�����ڣ���ʽΪ��
	 * 		yyyy-MM-dd HH:mm:ss.SSS
	 */
	public String getDate(){
		
		//���ǵ�����ҪƵ���޸��ַ���������ʹ��StringBuffer��������
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR)).append("-");//������
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2)).append("-");//������
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2)).append(" ");//������
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2)).append(":");//����ʱ
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2)).append(":");//���ӷ�
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2)).append(".");//������
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3));//���Ӻ���
		
		return buf.toString();
	}
	/*
	 * ���巽����getDateComplete
	 * 		�õ�һ������,��ʽΪ��
	 * 			yyyy��MM��dd��HHʱmm��ss��SSS����
	 */
	public String getDateComplete(){
		
		//���ǵ�����ҪƵ���޸��ַ���������ʹ��StringBuffer��������
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR)).append("��");//������
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2)).append("��");//������
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2)).append("��");//������
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2)).append("ʱ");//����ʱ
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2)).append("��");//���ӷ�
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2)).append("��");//������
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3)).append("����");//���Ӻ���
		
		return buf.toString();
	}
	/*
	 * ���巽����getTimeStamp
	 * 		�õ�һ��ʱ���
	 */
	public String getTimeStamp(){
		
		//���ǵ�����ҪƵ���޸��ַ���������ʹ��StringBuffer��������
		StringBuffer buf = new StringBuffer();
		
		buf.append(calendar.get(Calendar.YEAR));
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1, 2));
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2));
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2));
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2));
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2));
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3));
		
		return buf.toString();
	}
	
	
	/*
	 * ���巽����addZero
	 * 		���ǵ������д���ǰ��0�������ڴ˴����ϲ���ķ���
	 */
	private String addZero(int num,int len){
		StringBuffer sb = new StringBuffer();
		
		sb.append(num);
		while(sb.length()<len){
			sb.insert(0,"0");//�����������ڵĳ���С��ָ���ĳ��ȣ����ڵ�һλ���ϲ�0
		}
		return sb.toString();
	}
}


public class CalendarDemo {
	
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		
		System.out.println("ϵͳʱ�䣺"+dt.getDate());
		System.out.println("����ϵͳʱ�䣺"+dt.getDateComplete());
		System.out.println("ʱ�����"+dt.getTimeStamp());
	}
	
	/*
	 * ���ϳ����Ѿ�ȡ��������ʱ�䡢���ĵ�����ʱ�䡢ʱ������������еĲ������Ƚ��鷳��
	 * ��Ϊÿһ���ط�����Ҫ���в�����������У���ֱ��ʹ��Calendar���ʱ����Ȼ���Է���Ľ�ʱ��ȡ�þ�ȷ�����룬
	 * �����ڶ�Ӧȡ���������ڵ�ʱ��ȴ����ô��ʹ�ˡ�
	 */
}
