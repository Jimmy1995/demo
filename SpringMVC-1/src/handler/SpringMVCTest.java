package handler;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.User;

//@SessionAttributes(value={"user"},types={String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	/**
	 * 有 @ModelAttribute 标记的方法，会在每个目标方法执行之前被SpringMVC 调用！
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		System.out.println("被 ModelAttribute 注解的方法。。。。。。");
		if(id!=null){
			//	 模拟从数据库中获取对象，然后把该对象放入Map中
			User user=new User(1, "Jimmy", "123", "123456@qq.com", 18);
			System.out.println("从数据库中获取一个对象： "+user);
			map.put("user", user);
		}
	}

	/**
	 * 运行流程：
	 * 1. 执行 @ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放到 Map 中，键为：user
	 * 2.SpringMVC 从 Map 中取出 User 对象，并把表单中的请求参数赋给 User对象的对应属性
	 * 3.SpringMVC 把上述对象传入目标方法的参数中.
	 * 
	 * 注意：在@ModelAttibute 修饰的方法中，放入到Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致  
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("修改。。。"+user);
		return SUCCESS;
	}
	
	/**
	 * @SessionAttribute 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值)，
	 * 还可以通过模型属性的对象类型制指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
	 * 
	 * 这个注解只能放在类上，不能放在方法上
	 * @param map
	 * @return
	 */
	//	@SessionAttributes(value={"user"},types={String.class})
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String,Object> map){
		User user=new User("Tom","123","234@qq.com",23);
		map.put("user",user);
		map.put("school", ".com");
		return SUCCESS;
	}
	
	/**
	 * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testaMap(Map<String,Object> map){
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("Tom","Jimmy","Kelly"));
		return SUCCESS;
	}
	
	/**
	 * 目标方法的返回值可以是ModelView 类型
	 *  其中可以包含视图和模型信息
	 *  SpringMV会把ModelAndView的 model 中的数据放到 request 域对象中.
	 * @return
	 */
	@RequestMapping("/testModelAndView")   
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView modelAndView=new ModelAndView(viewName);
		
		//添加模型数据到ModelAndView中
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		String sdate = sdf.format(date);
		
		modelAndView.addObject("time",new Date());
		
		return modelAndView;
	}

	
	/**
	 * 可以使用Servlet原生的 API 作为目标参数 具体支持以下类型：
	 * HttpServletRequest、HttpServletResponse
	 * 、HttpSession、java.security.principal
	 * 、Locale、InputStream、OutputStream|、Reader、Writer
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("testServletAPI")
	public void testServletAPI(HttpServletRequest req,
			HttpServletResponse resp,Writer out) throws IOException {
		System.out.println("testServletAPI.....REQUEST: " + req
				+ "  RESPONSE: " + resp);
		out.write("hello SpingMVC");
		//return SUCCESS;
	}

	/**
	 * SpringMVC 会按请求参数名和POJO属性名进行自动匹配
	 * 自动为该对象填充属性值。支持级联属性。如：dept.deptId、dept.deptName 等
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo...." + user);
		return SUCCESS;
	}

	/**
	 * 了解
	 * 
	 * @CookieValue:映射一个Cookie值，属性同RequestParam
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/testCookieValue", method = RequestMethod.GET)
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue.....sessionId: " + sessionId);
		return SUCCESS;
	}

	/**
	 * 映射请求头信息，使用机会较少，了解 用法同@RequestParam
	 * 
	 * @param al
	 * @return
	 */
	@RequestMapping(value = "testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String al) {
		System.out.println("testRequestHeader....Accept-Language: " + al);
		return SUCCESS;
	}

	/**
	 * @RequestParam 来映射请求参数 value值 即请求参数的参数名 required 该参数是否必须，默认为true
	 *               defaultValue 请求参数的默认值
	 * @param uname
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(
			@RequestParam(value = "username") String uname,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) { // Integer
																							// age

		System.out.println("testRequestParam..... " + uname + ": " + age);
		return SUCCESS;
	}

	/**
	 * REST 风格的 URL -CRUD 为例： 新增：/order POST 修改：/order/1 PUT update?id=1
	 * 获取：/order/1 GET get?id=1 删除：/order/1 DELETE delet?id=1
	 * 
	 * 
	 * 如何发送PUT 和DELETE请求 1.需要配置 HiddenHttpMethodFilter 2.需要发送POST 请求
	 * 3.需要在发送POST请求时携带一个隐藏域 name="_name" 的隐藏域，值为 DELETE 或 PUT
	 * 
	 * 在SpringMVC中的目标方法中如何得到id 呢？ 是用 @PathVariable 注解
	 * 
	 * @param d
	 * @return
	 */
	@RequestMapping(value = "/testRest/{d}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("d") Integer d) {
		System.out.println("testRest.....PUT" + d);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{d}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("d") int d) {
		System.out.println("testRest.....DELETE" + d);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest.....POST");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{d}", method = RequestMethod.GET)
	public String testRest(@PathVariable("d") Integer d) {
		System.out.println("testRest.....GET" + d);
		return SUCCESS;
	}

	/**
	 * @PathVariable 可以来映射 URL 中的占位符到目标方法的参数中
	 * @param id
	 * @return
	 */
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVarible(@PathVariable(value = "id") Integer id) {
		System.out.println("testPathVariable...." + id);
		return SUCCESS;
	}

	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath.....");
		return SUCCESS;
	}

	/**
	 * 了解使用 params、headers来更加精确的映射请求，params、headers支持简单的表达式
	 * 
	 * @param r
	 * @return
	 */
	@RequestMapping(value = "testParamsAndMethods", params = { "username",
			"age!=10" }, headers = { "Accept-Language=zh-CN" })
	// en-U则会报错
	public String testParamsAndMethods(HttpServletRequest r) {
		int age = Integer.parseInt(r.getParameter("age"));
		System.out.println("testParamsAndMethods...." + age);
		return SUCCESS;
	}

	/**
	 * value: 映射请求的URL 常用：使用method来制定请求的提交方式, 如果不指定该属性则以 POST、GET 方式提交的都可以
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod.....");
		return SUCCESS;
	}

	/**
	 * @RequestMapping 除了可以修饰方法，还可以修饰类 1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录 2).
	 *                 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。 若类定义处未标注
	 * @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping......");
		return SUCCESS;
	}

}
