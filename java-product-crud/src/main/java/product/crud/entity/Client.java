package product.crud.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="T_CLIENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Client {

	@Id
	@Column(name="client_id")
	@SequenceGenerator(name="client",sequenceName="SQ_T_CLIENT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="client")
	private int id;

	@Column(name="client_name",nullable=false)
	private String name;
	
	@Column(name="ds_email", nullable=false)
	private String email;
	
	@ManyToMany(mappedBy = "clients")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Establishment> establishments;
	
	public Client() {
		super();
	}
	
	public Client(String name) {
		super();
		this.name = name;
	}

	public Client(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Client(int id, String name, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	public List<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
