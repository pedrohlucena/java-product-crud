package product.crud.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int user;
	private int establishment;
	
	public RatingId() {
		super();
	}

	public RatingId(int user, int establishment) {
		super();
		this.user = user;
		this.establishment = establishment;
	}

	public int getUser() {
		return user;
	}

	public int getEstablishment() {
		return establishment;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public void setEstablishment(int establishment) {
		this.establishment = establishment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(establishment, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingId other = (RatingId) obj;
		return establishment == other.establishment && user == other.user;
	}
}