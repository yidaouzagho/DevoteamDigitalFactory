package fr.d2factory.libraryapp.member;

import fr.d2factory.libraryapp.library.Library;

/**
 * A member is a person who can borrow and return books to a {@link Library}
 * A member can be either a student or a resident.
 */
public abstract class Member {
	
	/** The id. */
	private String id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
			
    /** An initial sum of money the member has. */
    private float wallet;

    /** An initial state to show if the member is late in giving back his books. */
    private boolean isLate = false;
        
    /**
     * Instantiates a new member.
     */
    public Member() {
		super();		
	}

	/**
	 * Instantiates a new member.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param wallet the wallet
	 * @param isLate the is late
	 */
	public Member(String id, String firstName, String lastName, float wallet, boolean isLate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.wallet = wallet;
		this.isLate = isLate;
	}
    
	/**
	 * Instantiates a new member.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Member(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * The member should pay their books when they are returned to the library.
	 *
	 * @param numberOfDays the number of days they kept the book
	 */
    public abstract void payBook(int numberOfDays);

    /**
     * Gets the wallet.
     *
     * @return the wallet
     */
    public float getWallet() {
        return wallet;
    }

    /**
     * Sets the wallet.
     *
     * @param wallet the new wallet
     */
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Checks if is late.
	 *
	 * @return true, if is late
	 */
	public boolean isLate() {
		return isLate;
	}

	/**
	 * Sets the late.
	 *
	 * @param isLate the new late
	 */
	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", wallet=" + wallet
				+ ", isLate=" + isLate + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isLate ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + Float.floatToIntBits(wallet);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isLate != other.isLate)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Float.floatToIntBits(wallet) != Float.floatToIntBits(other.wallet))
			return false;
		return true;
	}
}
