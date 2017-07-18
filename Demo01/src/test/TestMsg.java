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
	//在eclipse中，可以JUnit视图里面选择，可以选择这个方法
	//idea中，测试了前面有个箭头圆的符号，或者选择方法，或者放到方法前面有时候会有下三角的图标
	
	@Test
	public void demoLiu(){
		System.out.println("我是测试类...");
//		return "测试返回..."; //为啥不能有返回值呢？
	}
}
