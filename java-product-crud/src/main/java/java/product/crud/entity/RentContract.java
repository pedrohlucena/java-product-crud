package java.product.crud.entity;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_RENT_CONTRACT")
public class RentContract {
	@Id
	@Column(name="contract_id")
	private int id;

	@Column(name="contract_value", nullable=false)
	private float value;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date ", nullable=false)
	private Calendar dueDate;

	@OneToOne
	@JoinColumn(name="id_establishment")
	private Establishment establishment;

	public RentContract() {
		super();
	}

	public RentContract(int id, float value, Calendar dueDate, Establishment establishment) {
		super();
		this.id = id;
		this.value = value;
		this.dueDate = dueDate;
		this.establishment = establishment;
	}

	public int getId() {
		return id;
	}

	public float getValue() {
		return value;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
}