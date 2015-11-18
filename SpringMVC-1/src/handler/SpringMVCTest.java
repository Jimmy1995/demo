package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	private static final String SUCCESS="success";
	
	/**
	 * 使用method来制定请求的提交方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod.....");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping 除了可以修饰方法，还可以修饰类
	 * 1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
	 * 2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
	 * 若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping......");
		return SUCCESS;
	}
	
	

}
