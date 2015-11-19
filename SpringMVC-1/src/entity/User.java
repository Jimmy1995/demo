package entity;

public class User {
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private Integer age;

	// ¼¶ÁªÊôÐÔ
	private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User() {
		super();
	}

	public User(String userName, String password, String email, Integer age) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public User(Integer id, String userName, String password, String email,
			Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", age=" + age + "]";
	}

}
