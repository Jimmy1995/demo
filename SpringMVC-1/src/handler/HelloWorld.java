package handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	/**
	 * 1、使用 @RequestMapping 注解来映射请求的URL
	 * 2、返回值会通过内部资源视图处理器(视图解析器)解析为实际的物理视图，
	 * 对于InternalResourceViewResolver，视图解析器会做如下的解析：
	 * 通过 prefix + returnValue + suffix 的方式得到实际的物理视图，然后做 转发(默认)【redirect】操作  
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello......");
		return "success";
	}
}
