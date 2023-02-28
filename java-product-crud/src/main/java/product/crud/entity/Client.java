package product.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CLIENT")
public class Client {

	@Id
	@Column(name="client_id")
	@SequenceGenerator(name="client",sequenceName="SQ_T_CLIENT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="client")
	private int id;

	@Column(name="client_name",nullable=false)
	private String name;
	
	public Client() {
		super();
	}

	public Client(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
