package cn.sunjian.net_uploadpic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadTask implements Runnable {

	private Socket s;
	public UploadTask(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		
		int count = 0;

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+".........connected");
		
		try {
			
			//��ȡ�ͻ��˷���������
			InputStream in = s.getInputStream();
			
			//����ȡ�����ݴ洢���ļ�����
			File dir = new File("C:\\pic");
			if(!dir.exists()){
				dir.mkdirs();
			}
			File file = new File(dir,ip+".bmp");
			
			//����ļ��Ѿ������ڷ����
			while(file.exists()) {
				file = new File(dir,ip+"("+(++count)+")"+".bmp");
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			
			while((len= in.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
			
			//��ȡSocket����������ϴ��ɹ����������ͻ���
			OutputStream out = s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());
			
			fos.close();
			s.close();
		} catch (Exception e) {

		}
		
	}

}