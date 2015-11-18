package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS="success";
	
	/**
	 * ʹ��method���ƶ�������ύ��ʽ
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod.....");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping ���˿������η�����������������
	 * 1). �ඨ�崦: �ṩ����������ӳ����Ϣ������� WEB Ӧ�õĸ�Ŀ¼
	 * 2). ������: �ṩ��һ����ϸ��ӳ����Ϣ�� ������ඨ�崦�� URL��
	 * ���ඨ�崦δ��ע @RequestMapping���򷽷�����ǵ� URL����� WEB Ӧ�õĸ�Ŀ¼
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping......");
		return SUCCESS;
	}
	
	

}
