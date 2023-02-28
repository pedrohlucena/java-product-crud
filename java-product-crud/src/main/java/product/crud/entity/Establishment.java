package product.crud.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "T_ESTABLISHMENT")
public class Establishment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_establishment")
	private Integer id;

	@Column(name = "establishment_name", length = 50)
	private String name;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Calendar creationDate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "establishment_type_id")
	private EstablishmentType establishmentType;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
		joinColumns = @JoinColumn(name = "id_estabelecimento"),
		inverseJoinColumns = @JoinColumn(name = "id_cliente"),
		name = "T_CLIENT_ESTABLISHMENT"
	)
	private List<Client> clients;
	
	@OneToOne(mappedBy = "establishment", cascade=CascadeType.PERSIST)
	private RentContract rentContract;
	
	private static final long serialVersionUID = 1L;

	public Establishment() {
		super();
	}
	
	public Establishment(String name, List<Client> clients, RentContract rentContract, EstablishmentType establishmentType) {
		super();
		this.name = name;
		this.clients = clients;
		this.rentContract = rentContract;
		this.establishmentType = establishmentType;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EstablishmentType getEstablishmentType() {
		return establishmentType;
	}

	public void setEstablishmentType(EstablishmentType establishmentType) {
		this.establishmentType = establishmentType;
	}

	public RentContract getRentContract() {
		return rentContract;
	}

	public void setRentContract(RentContract rentContract) {
		this.rentContract = rentContract;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
}
