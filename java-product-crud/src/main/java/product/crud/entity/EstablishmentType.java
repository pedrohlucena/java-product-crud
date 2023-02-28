package product.crud.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_ESTABLISHMENT_TYPE")
public class EstablishmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "establishment_type_id")
	private Integer id;

	@Column(name = "establishment_type_name", length=25,nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "establishmentType")
	private Collection<Establishment> establishments;

	public EstablishmentType() {
		super();
	}

	public EstablishmentType(String name, Collection<Establishment> establishments) {
		super();
		this.name = name;
		this.establishments = establishments;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(Collection<Establishment> establishments) {
		this.establishments = establishments;
	}
}