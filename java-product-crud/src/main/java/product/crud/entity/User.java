package product.crud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="T_USER")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	

	@Id
	@SequenceGenerator(name="user",sequenceName="SQ_T_USER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user")
	private int id;

	@Column(length=12,nullable=false)
	private String username;

	@Column(nullable=false)
	private String password;

	@Column(length=50,nullable=false)
	private String name;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
}