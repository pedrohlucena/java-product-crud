package product.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="T_PHYSICAL_PERSON_CLIENT")
@DiscriminatorValue("PF")
public class PhysicalPersonClient extends Client {
	@Column(name="estado_civil", length = 20)
	private String maritalStatus;

	@Column(length = 20)
	private String schooling;

	public PhysicalPersonClient() {
		super();
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
