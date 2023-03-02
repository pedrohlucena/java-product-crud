package product.crud.entity;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "T_RATING")
@IdClass(RatingId.class)
public class Rating implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Rating() {
		super();
	}
	
	@Id
	@JoinColumn(name = "user_id")
	@ManyToOne(optional = false)
	private User user;

	@Id
	@JoinColumn(name = "establishment_id")
	@ManyToOne(optional = false)
	private Establishment establishment;

	private int score;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rating_date")
	private Calendar ratingDate;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public int getScore() {
		return score;
	}

	public Calendar getRatingDate() {
		return ratingDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setRatingDate(Calendar ratingDate) {
		this.ratingDate = ratingDate;
	}
}
