package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import entity.Student;

public class StudentDao {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//	��ѯ����ѧ����Ϣ
	public List<Student> queryAll(){
		String sql="select * from student";
		List<Map<String, Object>> list = template.queryForList(sql);
		List<Student> stus=new ArrayList<Student>();
		for (Map<String,Object> map : list) {
			Student s=new Student();
			int id = (int) map.get("id");
			s.setId(id);
			String name = (String) map.get("name");
			s.setName(name);
			stus.add(s);
		}
		return stus;
	}
	
	//	�����ݿ��в��뵥��ѧ����Ϣ
	public void insertOneStudent(Student stu){
		String sql="insert into student values(?,?)";
		System.out.println(stu+"/////");
		int count=template.update(sql,new Object[]{stu.getId(),stu.getName()});
		System.out.println("update>>>>..."+count);
	}
}
