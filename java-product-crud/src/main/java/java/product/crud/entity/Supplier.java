package java.product.crud.entity;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="T_SUPPLIER")
@Entity
public class Supplier {
	@Id
	@Column(name="cd_supplier")
	@SequenceGenerator(name="supplier",sequenceName="sq_t_supplier",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="supplier")
	private int code;

	@Column(name="nm_supplier",nullable=false,length=50)
	private int name;

	@CreationTimestamp
	@Column(name="dt_registration")
	private Calendar registrationDate;
	
	@UpdateTimestamp
	@Column(name="dt_modification")
	private Calendar modificationDate;
	
	public Supplier() { super(); } ;
	
	public Supplier(int code, int name, Calendar registrationDate, Calendar modificationDate) {
		super();
		this.code = code;
		this.name = name;
		this.registrationDate = registrationDate;
		this.modificationDate = modificationDate;
	}
	
	public int getCode() {
		return code;
	}

	public int getName() {
		return name;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public Calendar getModificationDate() {
		return modificationDate;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(int name) {
		this.name = name;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setModificationDate(Calendar modificationDate) {
		this.modificationDate = modificationDate;
	}
}
