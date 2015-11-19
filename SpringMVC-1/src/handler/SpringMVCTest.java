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
	 * �� @ModelAttribute ��ǵķ���������ÿ��Ŀ�귽��ִ��֮ǰ��SpringMVC ���ã�
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		System.out.println("�� ModelAttribute ע��ķ���������������");
		if(id!=null){
			//	 ģ������ݿ��л�ȡ����Ȼ��Ѹö������Map��
			User user=new User(1, "Jimmy", "123", "123456@qq.com", 18);
			System.out.println("�����ݿ��л�ȡһ������ "+user);
			map.put("user", user);
		}
	}

	/**
	 * �������̣�
	 * 1. ִ�� @ModelAttributeע�����εķ����������ݿ���ȡ�����󣬰Ѷ���ŵ� Map �У���Ϊ��user
	 * 2.SpringMVC �� Map ��ȡ�� User ���󣬲��ѱ��е������������ User����Ķ�Ӧ����
	 * 3.SpringMVC ������������Ŀ�귽���Ĳ�����.
	 * 
	 * ע�⣺��@ModelAttibute ���εķ����У����뵽Map ʱ�ļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ��  
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("�޸ġ�����"+user);
		return SUCCESS;
	}
	
	/**
	 * @SessionAttribute ���˿���ͨ��������ָ����Ҫ�ŵ��Ự�е�������(ʵ����ʹ�õ��� value ����ֵ)��
	 * ������ͨ��ģ�����ԵĶ���������ָ����Щģ��������Ҫ�ŵ��Ự��(ʵ����ʹ�õ��� types ����ֵ)
	 * 
	 * ���ע��ֻ�ܷ������ϣ����ܷ��ڷ�����
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
	 * Ŀ�귽��������� Map ����(ʵ����Ҳ������ Model ���ͻ� ModelMap ����)�Ĳ���
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
	 * Ŀ�귽���ķ���ֵ������ModelView ����
	 *  ���п��԰�����ͼ��ģ����Ϣ
	 *  SpringMV���ModelAndView�� model �е����ݷŵ� request �������.
	 * @return
	 */
	@RequestMapping("/testModelAndView")   
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView modelAndView=new ModelAndView(viewName);
		
		//���ģ�����ݵ�ModelAndView��
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		String sdate = sdf.format(date);
		
		modelAndView.addObject("time",new Date());
		
		return modelAndView;
	}

	
	/**
	 * ����ʹ��Servletԭ���� API ��ΪĿ����� ����֧���������ͣ�
	 * HttpServletRequest��HttpServletResponse
	 * ��HttpSession��java.security.principal
	 * ��Locale��InputStream��OutputStream|��Reader��Writer
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
	 * SpringMVC �ᰴ�����������POJO�����������Զ�ƥ��
	 * �Զ�Ϊ�ö����������ֵ��֧�ּ������ԡ��磺dept.deptId��dept.deptName ��
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
	 * �˽�
	 * 
	 * @CookieValue:ӳ��һ��Cookieֵ������ͬRequestParam
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(value = "/testCookieValue", method = RequestMethod.GET)
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue.....sessionId: " + sessionId);
		return SUCCESS;
	}

	/**
	 * ӳ������ͷ��Ϣ��ʹ�û�����٣��˽� �÷�ͬ@RequestParam
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
	 * @RequestParam ��ӳ��������� valueֵ ����������Ĳ����� required �ò����Ƿ���룬Ĭ��Ϊtrue
	 *               defaultValue ���������Ĭ��ֵ
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
	 * REST ���� URL -CRUD Ϊ���� ������/order POST �޸ģ�/order/1 PUT update?id=1
	 * ��ȡ��/order/1 GET get?id=1 ɾ����/order/1 DELETE delet?id=1
	 * 
	 * 
	 * ��η���PUT ��DELETE���� 1.��Ҫ���� HiddenHttpMethodFilter 2.��Ҫ����POST ����
	 * 3.��Ҫ�ڷ���POST����ʱЯ��һ�������� name="_name" ��������ֵΪ DELETE �� PUT
	 * 
	 * ��SpringMVC�е�Ŀ�귽������εõ�id �أ� ���� @PathVariable ע��
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
	 * @PathVariable ������ӳ�� URL �е�ռλ����Ŀ�귽���Ĳ�����
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
	 * �˽�ʹ�� params��headers�����Ӿ�ȷ��ӳ������params��headers֧�ּ򵥵ı��ʽ
	 * 
	 * @param r
	 * @return
	 */
	@RequestMapping(value = "testParamsAndMethods", params = { "username",
			"age!=10" }, headers = { "Accept-Language=zh-CN" })
	// en-U��ᱨ��
	public String testParamsAndMethods(HttpServletRequest r) {
		int age = Integer.parseInt(r.getParameter("age"));
		System.out.println("testParamsAndMethods...." + age);
		return SUCCESS;
	}

	/**
	 * value: ӳ�������URL ���ã�ʹ��method���ƶ�������ύ��ʽ, �����ָ������������ POST��GET ��ʽ�ύ�Ķ�����
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod.....");
		return SUCCESS;
	}

	/**
	 * @RequestMapping ���˿������η����������������� 1). �ඨ�崦: �ṩ����������ӳ����Ϣ������� WEB Ӧ�õĸ�Ŀ¼ 2).
	 *                 ������: �ṩ��һ����ϸ��ӳ����Ϣ�� ������ඨ�崦�� URL�� ���ඨ�崦δ��ע
	 * @RequestMapping���򷽷�����ǵ� URL����� WEB Ӧ�õĸ�Ŀ¼
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping......");
		return SUCCESS;
	}

}
