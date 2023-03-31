package product.crud.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="T_PHYSICAL_PERSON_CLIENT")
@DiscriminatorValue("PF")
public class PhysicalPersonClient extends Client implements Serializable {
	private static final long serialVersionUID = -5189522578065868608L;

	@Column(name="estado_civil", length = 20)
	private String maritalStatus;

	@Column(length = 20)
	private String schooling;

	public PhysicalPersonClient() {
		super();
	}
	
	public PhysicalPersonClient(String name) {
		super(name);
	}
	
	public PhysicalPersonClient(int id, String name) {
		super(id, name);
	}
	
	public PhysicalPersonClient(String name, String email) {
		super(name, email);
	}
	
	public PhysicalPersonClient(int id, String name, String email) {
		super(id, name, email);
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getSchooling() {
		return schooling;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setSchooling(String schooling) {
		this.schooling = schooling;
	}
}
