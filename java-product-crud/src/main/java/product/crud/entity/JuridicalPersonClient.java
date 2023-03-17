package product.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="T_JURIDICAL_PERSON_CLIENT")
@DiscriminatorValue("PJ")
public class JuridicalPersonClient extends Client {
	@Column(name="inscricao_estadual", length = 20)
	private String stateRegistration;

	@Column(length = 50)
	private String fantasyName;

	public JuridicalPersonClient() {
		super();
	}

	public String getStateRegistration() {
		return stateRegistration;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setStateRegistration(String stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}
}
