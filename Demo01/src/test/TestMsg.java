package test;

import org.junit.Test;

import com.ziroom.servlet.MessageUtil;

public class TestMsg {
	/*public static void main(String[] args){
		String url="http://localhost:8080/Demo01/greeting";
		String param = "";
		MessageUtil.postWithResJson(url, param);
		
	}*/
	@Test
	public void  test(){
		String url="http://localhost:8080/Demo01/greeting";
		String param = "";
		MessageUtil.postWithResJson(url, param);
		
	}
	
	@Test
	public void demo(){
		String url="http://localhost:8080/Demo01/greeting";
		String param = "";
		MessageUtil.postWithResJson(url, param);
	}
	//��eclipse�У�����JUnit��ͼ����ѡ�񣬿���ѡ���������
	//idea�У�������ǰ���и���ͷԲ�ķ��ţ�����ѡ�񷽷������߷ŵ�����ǰ����ʱ����������ǵ�ͼ��
	
	@Test
	public void demoLiu(){
		System.out.println("���ǲ�����...");
//		return "���Է���..."; //Ϊɶ�����з���ֵ�أ�
	}
}
