package model;

public class JavaBeans {

	private String idCode;
	private String nome;
	private String phone;
	private String email;

	public JavaBeans(String idCode, String nome, String phone, String email) {
		super();
		this.idCode = idCode;
		this.nome = nome;
		this.phone = phone;
		this.email = email;
	}

	public JavaBeans() {
		super();
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
