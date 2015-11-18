package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	/**
	 * 1��ʹ�� @RequestMapping ע����ӳ�������URL
	 * 2������ֵ��ͨ���ڲ���Դ��ͼ������(��ͼ������)����Ϊʵ�ʵ�������ͼ��
	 * ����InternalResourceViewResolver����ͼ�������������µĽ�����
	 * ͨ�� prefix + returnValue + suffix �ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ���� ת��(Ĭ��)��redirect������  
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello......");
		return "success";
	}
}
