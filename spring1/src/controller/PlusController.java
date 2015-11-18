package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import dao.StudentDao;
import entity.Student;

public class PlusController extends BaseController{
	
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("save......");
		return new ModelAndView("success","data","��̨���ݡ����������ɹ�");
		//	return new ModelAndView("/success.jsp");
	}
	
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("delete......");
		return new ModelAndView("success","data","��̨���ݡ�����ɾ���ɹ�......");
	}
	
	//	��ѯ����ѧ������Ϣ
	public ModelAndView selAll(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Student> list = studentDao.queryAll();
		return new ModelAndView("data_list","list",list);
	}
	
	//	���ӵ���ѧ��
	public ModelAndView insertStudent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Student stu=new Student();
		stu.setId(id);
		stu.setName(name);
		studentDao.insertOneStudent(stu);
		return new ModelAndView("success","data","����ѧ���ɹ�������������");
	}
	
	//	��ѯ����ѧ����Ϣ
	public ModelAndView selOne_detail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("selAll....controller");
		return new ModelAndView("success","data","���ø���.....");
	}
	
	
	
	
}
